package com.ozlemaglar.LibraryManagementProject.services;


import com.ozlemaglar.LibraryManagementProject.entity.Book;
import com.ozlemaglar.LibraryManagementProject.repository.IBookRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService implements IBaseService<Book> {

    private final IBookRepo bookRepo;

    public BookService(IBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book save(Book book) {
        bookRepo.save(book);
        return book;
    }



    public Page<Book> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return bookRepo.findAll(pageable);
    }

    @Override
    public Optional<Book> find(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook;
    }

    @Override
    public Book update(Book book) {
        if (StringUtils.isNotEmpty(book.getId().toString())) {
         Optional<Book> optionalBook = bookRepo.findById(book.getId());

            if (optionalBook.isPresent()) {
                bookRepo.save(book);
            }
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
        return book;
    }

    @Override
    public Boolean delete(Long id) {

        Optional<Book> optionalBook =bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            bookRepo.deleteById(id);
            return true;

        }else{
            throw new IllegalArgumentException("kayıt bulunamadı");
        }
    }
}
