package com.ozlemaglar.LibraryManagementProject.repository;

import com.ozlemaglar.LibraryManagementProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBookRepo extends JpaRepository<Book, String> {

}
