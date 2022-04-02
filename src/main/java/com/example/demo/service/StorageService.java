package com.example.demo.service;

import com.example.demo.domain.Storage;
import com.example.demo.domain.User;
import com.example.demo.repository.StorageRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public String join(Storage storage){
        storageRepository.save(storage);
        return storage.getFav_repository();
    }

}
