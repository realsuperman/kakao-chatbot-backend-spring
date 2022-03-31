package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Storage {
    @Id
    String fav_repository;
    String git_api_address;
    String git_updated_at;

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


    public String getGit_updated_at() {
        return git_updated_at;
    }

    public void setGit_updated_at(String git_updated_at) {
        this.git_updated_at = git_updated_at;
    }
}
