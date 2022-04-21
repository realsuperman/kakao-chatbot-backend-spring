package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data // equals hashCode 자동으로 생성해줌
@NoArgsConstructor // 생성자 기본으로 만들어줌
@AllArgsConstructor // 필드값을 모두 포함한 생성자를 자동 생성해준다
public class UserKey implements Serializable {
    private String id;
    private String fav_repository;
}

/*
       매칭하고자 하는 키를 담는 클래스이다(복합키를 다 클래스로 넣는다)
       3개의 어노테이션을 달아준다
 */
