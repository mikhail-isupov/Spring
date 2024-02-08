package ru.geekbrains.homework6.model;

/**
 * Record для передачи данных логина.
 * @param username - имя пользователя
 * @param password - пароль
 */
public record UserDTO(
            String username,
            String password){ }
