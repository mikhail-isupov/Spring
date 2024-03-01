package ru.geekbrains.homework10.service;

import ru.geekbrains.homework10.model.User;
import ru.geekbrains.homework10.model.UserEntity;

public interface iAuthService {
    Integer register(User user);

    String login(User user);

    void logout(User user);
}
