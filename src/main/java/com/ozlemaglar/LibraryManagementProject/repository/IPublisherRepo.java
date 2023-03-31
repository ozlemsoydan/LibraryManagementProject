package com.ozlemaglar.LibraryManagementProject.repository;


import com.ozlemaglar.LibraryManagementProject.entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublisherRepo extends CrudRepository<Publisher,Long> {
}
