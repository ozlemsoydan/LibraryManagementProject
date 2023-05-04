package com.ozlemaglar.LibraryManagementProject.services;

import com.ozlemaglar.LibraryManagementProject.entity.Publisher;
import com.ozlemaglar.LibraryManagementProject.repository.IPublisherRepo;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService implements IBaseService<Publisher> {


    private final IPublisherRepo publisherRepo;

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepo.save(publisher);
    }


    public List<Publisher> getAll() {
        return (List<Publisher>) publisherRepo.findAll();
    }


    @Override
    public Optional<Publisher> find(String id) {
        return publisherRepo.findById(id);
    }

    @Override
    public Publisher update(Publisher publisher) {
        if (StringUtils.isNotEmpty(publisher.getId())) {
            Optional<Publisher> optionalPublisher = publisherRepo.findById(publisher.getId());
            if (optionalPublisher.isPresent()) {
                publisherRepo.save(publisher);
            }
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
        return publisher;
    }

    @Override
    public Boolean delete(String id) {
        Optional<Publisher> optionalPublisher = publisherRepo.findById(id);
        if (optionalPublisher.isPresent()) {
            publisherRepo.deleteById(id);
            return true;
        } else {
            throw new IllegalArgumentException("id bulunamadı");
        }
    }
}