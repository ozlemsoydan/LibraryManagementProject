package com.ozlemaglar.LibraryManagementProject.repository;


import com.ozlemaglar.LibraryManagementProject.entity.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends CrudRepository<Author, String> {

}
