package com.ozlemaglar.LibraryManagementProject.services;

import com.ozlemaglar.LibraryManagementProject.entity.Book;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Optional;


public interface IBaseService<T> {

    public T save(T entity);

    public Page<T> getAll(int page, int size);

    public Optional<T> find(Long id);

    public T update(T entity);

    public Boolean delete(Long id);

}
