package com.ozlemaglar.LibraryManagementProject.services;

import com.ozlemaglar.LibraryManagementProject.entity.Book;
import org.springframework.data.domain.Page;
import java.util.Map;
import java.util.Optional;


public interface IBookService {

    public Book save(Book book);
    public Page<Book> getAllBooks(int page, int size);
    public Optional<Book> find(Long id);
    public Book update(Book book);
    public Boolean delete(Long id);

}
