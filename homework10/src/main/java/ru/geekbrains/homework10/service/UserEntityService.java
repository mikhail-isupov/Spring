package ru.geekbrains.homework10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework10.model.User;
import ru.geekbrains.homework10.model.UserEntity;

@Component
public class UserEntityService {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Генерация UserEntity из User
     * @param user User
     * @return UserEntity
     */
    public UserEntity createUserEntity(User user){
        return new UserEntity(user.username(), bCryptPasswordEncoder.encode(user.password()));
    }
}
