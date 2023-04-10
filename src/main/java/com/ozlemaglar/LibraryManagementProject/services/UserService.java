package com.ozlemaglar.LibraryManagementProject.services;


import com.ozlemaglar.LibraryManagementProject.entity.User;
import com.ozlemaglar.LibraryManagementProject.repository.IUserRepo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IBaseService<User>{

    private final IUserRepo userRepo;

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }


    public List<User> getAll() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public User update(User user) {
        if (StringUtils.isNotEmpty(user.getId().toString())) {
            Optional<User> optionalUser = userRepo.findById(user.getId());

            if (optionalUser.isPresent()) {
                userRepo.save(user);
            }
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
        return user;
    }

    @Override
    public Boolean delete(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
        userRepo.deleteById(id);
        return true;

    } else {
        throw new IllegalArgumentException("kayıt bulunamadı");
    }
    }
}
