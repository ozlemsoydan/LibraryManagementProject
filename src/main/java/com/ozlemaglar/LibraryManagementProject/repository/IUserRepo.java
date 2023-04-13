package com.ozlemaglar.LibraryManagementProject.repository;

import com.ozlemaglar.LibraryManagementProject.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepo extends CrudRepository<User,String> {

    Optional<User> findByEmail(String email);
}
