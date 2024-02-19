package ru.geekbrains.homework10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework10.model.SessionEntity;
import ru.geekbrains.homework10.model.UserEntity;

@Component
public class SessionEntityService {

    @Autowired
    private JwtTokenService jwtTokenService;

    public SessionEntity createSessionEntity(UserEntity registeredUser){
        return new SessionEntity(registeredUser, jwtTokenService.generateToken(registeredUser));
    }
}
