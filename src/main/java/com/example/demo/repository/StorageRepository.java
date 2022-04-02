package com.example.demo.repository;

import com.example.demo.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StorageRepository extends JpaRepository<Storage, String> {

}
