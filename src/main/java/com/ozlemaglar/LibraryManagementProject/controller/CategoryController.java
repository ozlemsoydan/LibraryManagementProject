package com.ozlemaglar.LibraryManagementProject.controller;

import com.ozlemaglar.LibraryManagementProject.entity.Category;
import com.ozlemaglar.LibraryManagementProject.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public Category add(Category category) {
        categoryService.save(category);
        return category;
    }

    @GetMapping("/")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/find/{id}")
    public Category find(@PathVariable(value = "id") Long id) {
        return categoryService.find(id).get();
    }

    @PutMapping("/update/{id}")
    public Category update(Category category) {
        return categoryService.update(category);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable(value = "id") Long id) {
        return categoryService.delete(id);
    }
}
