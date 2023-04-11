package com.ozlemaglar.LibraryManagementProject.services;


import com.ozlemaglar.LibraryManagementProject.DTO.BookDTOResponse;
import com.ozlemaglar.LibraryManagementProject.entity.Book;
import com.ozlemaglar.LibraryManagementProject.repository.IBookRepo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBaseService<Book> {

    private final IBookRepo bookRepo;

    @Value("${google.bookApi.url}")
    private String googleBookApiUrl;

    public BookService(IBookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book save(Book book) {
        bookRepo.save(book);
        return book;
    }

    public Page<Book> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepo.findAll(pageable);
    }

    @Override
    public Optional<Book> find(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook;
    }

    @Override
    public Book update(Book book) {
        if (StringUtils.isNotEmpty(book.getId().toString())) {
            Optional<Book> optionalBook = bookRepo.findById(book.getId());

            if (optionalBook.isPresent()) {
                bookRepo.save(book);
            }
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
        return book;
    }

    @Override
    public Boolean delete(Long id) {

        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            bookRepo.deleteById(id);
            return true;

        } else {
            throw new IllegalArgumentException("kayıt bulunamadı");
        }
    }


    public List<BookDTOResponse> search(int page, int size, String searchText) {

        String url = googleBookApiUrl +"q=" + searchText + "&maxresults="+size +"&startIndex="+((page*size)-size);

        ResponseEntity<BookDTOResponse> response = getRestTemplate().getForEntity(url, BookDTOResponse.class);

        // response'da dönen selftLink alanı ile yeni bir istek gönderilip, her kitap için detaylı bilgiler getirilecek
        //Modellerin düzenlenmesi gerekebilir. Eklenecek özelliğe göre karar verilmeli

        return (List<BookDTOResponse>) response;
    }

    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
        SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
                .getRequestFactory();
        rf.setReadTimeout(10000);
        rf.setConnectTimeout(10000);

        return restTemplate;
    }

}
