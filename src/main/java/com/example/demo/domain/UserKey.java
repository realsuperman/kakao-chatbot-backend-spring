package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;

public class UserKey implements Serializable {
    private String id;
    private String fav_repository;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserKey userKey = (UserKey) o;
        return Objects.equals(id, userKey.id) &&
                Objects.equals(fav_repository, userKey.fav_repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fav_repository);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFav_repository() {
        return fav_repository;
    }

    public void setFav_repository(String fav_repository) {
        this.fav_repository = fav_repository;
    }
}
