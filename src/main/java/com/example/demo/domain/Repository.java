package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Repository {
    @Id
    String fav_repository;
    String git_api_address;
    String git_created_at;
    String git_updated_at;
    String created_at;
    String updated_at;

    public String getFav_repository() {
        return fav_repository;
    }

    public void setFav_repository(String fav_repository) {
        this.fav_repository = fav_repository;
    }

    public String getGit_api_address() {
        return git_api_address;
    }

    public void setGit_api_address(String git_api_address) {
        this.git_api_address = git_api_address;
    }

    public String getGit_created_at() {
        return git_created_at;
    }

    public void setGit_created_at(String git_created_at) {
        this.git_created_at = git_created_at;
    }

    public String getGit_updated_at() {
        return git_updated_at;
    }

    public void setGit_updated_at(String git_updated_at) {
        this.git_updated_at = git_updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
