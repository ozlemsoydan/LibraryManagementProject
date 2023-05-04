package com.ozlemaglar.LibraryManagementProject.controller;

import com.ozlemaglar.LibraryManagementProject.DTO.BookDTOResponse;
import com.ozlemaglar.LibraryManagementProject.entity.Book;
import com.ozlemaglar.LibraryManagementProject.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public Book add(@RequestBody Book book) {
        return bookService.save(book);
    }


    @GetMapping
    public Page<Book> getAll(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "size", required = true) int size) {
        return bookService.getAll(page,size);
    }

    @GetMapping("/{id}")
    public Optional<Book> find(@PathVariable(value = "id") String id) {
        return bookService.find(id);
    }

    @PutMapping("/update")
    public Book update(Book book) {
        return bookService.update(book);
    }


    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable(value = "id", required = true) String id) {
        return bookService.delete(id);
    }


    @GetMapping("/search")
    public List<BookDTOResponse> search(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
                                        @RequestParam (value = "searchText") String searchText) {

        return bookService.search(page,size, searchText);
    }



}
