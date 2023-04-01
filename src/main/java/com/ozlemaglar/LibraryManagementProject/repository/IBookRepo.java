package com.ozlemaglar.LibraryManagementProject.repository;

import com.ozlemaglar.LibraryManagementProject.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book, Long> {

    @Query("select b from Book b")
    Page<Book> getAllByBookName(Pageable pageable);
}
