package com.ozlemaglar.LibraryManagementProject.controller;


import com.ozlemaglar.LibraryManagementProject.entity.User;
import com.ozlemaglar.LibraryManagementProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/save")
    public User save(User user){
        return userService.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/find/{id}")
    public Optional<User> find(@PathVariable(value = "id") String id){
        return userService.find(id);
    }

    @PutMapping("/update")
    public User update(User user){
        return userService.update(user);
    }

    @DeleteMapping("/delete{id}")
    public Boolean delete(@PathVariable(value = "id") String id){
        return userService.delete(id);
    }
}
