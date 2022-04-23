package com.example.demo.service;

import com.example.demo.domain.Storage;
import com.example.demo.repository.StorageRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class StorageService {
    private final StorageRepository storageRepository;

    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public String join(Storage storage){
        if(!findRepository(storage).isPresent()) storageRepository.save(storage);
        return storage.getFav_repository();
    }

    public Optional<Storage> findRepository(Storage storage){
        return storageRepository.findById(storage.getFav_repository());
    }

}
