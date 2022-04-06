package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
@IdClass(UserKey.class) // 키를 따로 복합키 클래스로 사용한다고 지정
public class User implements Serializable {
    @Id
    private String id;
    @Id
    private String fav_repository;
    private String user_get_date;
}
