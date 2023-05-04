package com.ozlemaglar.LibraryManagementProject.controller;

import com.ozlemaglar.LibraryManagementProject.entity.Author;
import com.ozlemaglar.LibraryManagementProject.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    public final AuthorService authorService;

    @PostMapping("/add")
    public Author add(Author author) {
        authorService.save(author);
        return author;
    }

    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @GetMapping("/find/{id}")
    public Author find(@PathVariable(value = "id") String id) {
        return authorService.find(id).get();
    }

    @PutMapping("/update/{id}")
    public Author update(Author author) {
        return authorService.update(author);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable(value = "id") String id) {
        return authorService.delete(id);
    }

}
