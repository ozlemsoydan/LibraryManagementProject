package com.ozlemaglar.LibraryManagementProject.controller;


import com.ozlemaglar.LibraryManagementProject.entity.Publisher;
import com.ozlemaglar.LibraryManagementProject.services.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping("/add")
    public Publisher add(Publisher publisher) {
        publisherService.save(publisher);
        return publisher;
    }

    @GetMapping("/")
    public List<Publisher> getAll(){
        return publisherService.getAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Publisher> find(@PathVariable(value = "id") Long id) {
        return publisherService.find(id);
    }

    @PutMapping("/update/{id}")
    public Publisher update(Publisher publisher) {
        return publisherService.update(publisher);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable(value = "id") Long id) {
        return publisherService.delete(id);
    }

}
