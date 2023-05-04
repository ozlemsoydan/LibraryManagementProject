package com.ozlemaglar.LibraryManagementProject.services;


import com.ozlemaglar.LibraryManagementProject.entity.Author;
import com.ozlemaglar.LibraryManagementProject.repository.IAuthorRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService implements IBaseService<Author> {


    private final IAuthorRepo authorRepo;

    public AuthorService(IAuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author save(Author author) {
        authorRepo.save(author);
        return author;
    }


    public List<Author> getAll(){
        return (List<Author>) authorRepo.findAll();
    }

    @Override
    public Optional<Author> find(String id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        return optionalAuthor;
    }

    @Override
    public Author update(Author author) {
        if (StringUtils.isNotEmpty(author.getId())) {
            Optional<Author> optionalAuthor = authorRepo.findById(author.getId());

            if (optionalAuthor.isPresent()) {
                authorRepo.save(author);
            }
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
        return author;
    }

    @Override
    public Boolean delete(String id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if (optionalAuthor.isPresent()) {
            authorRepo.deleteById(id);
            return true;

        } else {
            throw new IllegalArgumentException("kayıt bulunamadı");
        }
    }

}