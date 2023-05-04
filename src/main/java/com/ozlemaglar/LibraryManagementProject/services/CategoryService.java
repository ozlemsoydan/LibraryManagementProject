package com.ozlemaglar.LibraryManagementProject.services;


import com.ozlemaglar.LibraryManagementProject.entity.Category;
import com.ozlemaglar.LibraryManagementProject.repository.ICategoryRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements IBaseService<Category> {

    private final ICategoryRepo categoryRepo;

    public CategoryService(ICategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }


    public List<Category> getAll() {
        return (List<Category>) categoryRepo.findAll();
    }

    @Override
    public Optional<Category> find(String id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category update(Category category) {
        if (StringUtils.isNotEmpty(category.getId())) {
           Optional<Category> optionalCategory = categoryRepo.findById(category.getId());

            if (optionalCategory.isPresent()) {
                categoryRepo.save(category);
            }
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
        return category;
    }


    @Override
    public Boolean delete(String id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isPresent()) {
            categoryRepo.deleteById(id);
            return true;

        } else {
            throw new IllegalArgumentException("kayıt bulunamadı");
        }
    }
}
