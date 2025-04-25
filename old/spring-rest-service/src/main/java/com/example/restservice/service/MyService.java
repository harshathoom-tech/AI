package com.example.restservice.service;

import com.example.restservice.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    private final MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Item> fetchItems() {
        return myRepository.findAll();
    }

    public void saveItem(Item item) {
        myRepository.save(item);
    }
}