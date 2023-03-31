package com.ozlemaglar.LibraryManagementProject.repository;

import com.ozlemaglar.LibraryManagementProject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {
}
