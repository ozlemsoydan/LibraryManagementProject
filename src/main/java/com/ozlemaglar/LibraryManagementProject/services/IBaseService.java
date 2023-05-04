package com.ozlemaglar.LibraryManagementProject.services;


import java.util.Optional;


public interface IBaseService<T> {

     T save(T entity);

     Optional<T> find(String id);

     T update(T entity);

     Boolean delete(String id);

}
