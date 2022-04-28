package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user")
@IdClass(UserKey.class) // 키를 따로 복합키 클래스로 사용한다고 지정
public class User implements Serializable {
    @Id
    private String id;
    @Id
    private String fav_repository;
    //@Transient
    //private String git_api_address;
    private String user_get_date;

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

    public String getUser_get_date() {
        return user_get_date;
    }

    public void setUser_get_date(String user_get_date) {
        this.user_get_date = user_get_date;
    }
}
