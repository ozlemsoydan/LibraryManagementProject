package com.ozlemaglar.LibraryManagementProject.repository;

import com.ozlemaglar.LibraryManagementProject.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends CrudRepository<Category, String> {
}
