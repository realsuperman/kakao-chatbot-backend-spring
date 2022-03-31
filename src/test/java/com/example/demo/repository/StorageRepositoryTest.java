package com.example.demo.repository;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class StorageRepositoryTest {
    @Autowired
    StorageRepository storageRepository;

    @Test
    public void Insert() {
        Storage storage = new Storage();
        storage.setFav_repository("test");
        storage.setGit_api_address("test2");
        storage.setGit_updated_at("test3");

        storageRepository.save(storage); // Insert
    }

    @Test
    public void get(){
        storageRepository.findAll();
    }
}
