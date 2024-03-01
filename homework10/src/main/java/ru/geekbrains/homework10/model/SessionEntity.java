package ru.geekbrains.homework10.model;

import jakarta.persistence.*;

@Entity
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(nullable = false)
    private UserEntity user;
    @Column(nullable = false)
    private String token;

    public SessionEntity(){}

    public SessionEntity(UserEntity user, String token){
        this.user = user;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public UserEntity getUser() {
        return user;
    }
}
