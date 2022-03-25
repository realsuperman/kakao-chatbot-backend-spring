package com.example.demo.domain;

        import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* GenerationType이 시퀀스면 시퀀스를 선언해야함
       TABLE이면 위와 유사하게 TableGenerator가 필요(시퀀스테이블임)
       default면 AUTO면 기본값으로 따라감
     */
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
