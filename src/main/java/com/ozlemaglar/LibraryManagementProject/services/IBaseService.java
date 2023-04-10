package com.ozlemaglar.LibraryManagementProject.services;


import java.util.Optional;


public interface IBaseService<T> {

     T save(T entity);

     Optional<T> find(Long id);

     T update(T entity);

     Boolean delete(Long id);

}
