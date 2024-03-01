package ru.geekbrains.homework10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework10.model.SessionEntity;
import ru.geekbrains.homework10.model.User;
import ru.geekbrains.homework10.model.UserEntity;
import ru.geekbrains.homework10.repo.iSessionRepo;
import ru.geekbrains.homework10.repo.iUserRepo;

import java.util.NoSuchElementException;

@Service
public class AuthService implements iAuthService {

    @Autowired
    private iUserRepo userRepo;

    @Autowired
    private iSessionRepo sessionRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserEntityService userEntityService;

    @Autowired
    private SessionEntityService sessionEntityService;

    /**
     * Регистрация нового пользователя в системе.
     * @param user user Data Transfer Object
     * @return id пользователя в БД
     */
    public Integer register(User user){
        UserEntity newUser = userEntityService.createUserEntity(user);
        newUser = userRepo.save(newUser);
        return newUser.getId();
    }

    /**
     * Логин пользователя в систему, генерация токена и сохранение его в базу данных.
     * @param user
     * @return токен
     */
    public String login(User user){
        UserEntity registeredUser = userRepo.findByUsername(user.username()).orElseThrow(NoSuchElementException::new);
        if (!bCryptPasswordEncoder.matches(user.password(), registeredUser.getEncodedPassword())) throw new RuntimeException("Неверный пароль");
        SessionEntity session = sessionEntityService.createSessionEntity(registeredUser);
        return sessionRepo.save(session).getToken();
    }

    /**
     * Выход юзера из системы, удаление сессии из бд.
     * @param user
     */
    public void logout(User user){
        UserEntity registeredUser = userRepo.findByUsername(user.username()).orElseThrow(NoSuchElementException::new);
        if (!bCryptPasswordEncoder.matches(user.password(), registeredUser.getEncodedPassword())) throw new RuntimeException("Неверный пароль");
        SessionEntity session = sessionRepo.findByUser(registeredUser).orElseThrow(NoSuchElementException::new);
        sessionRepo.delete(session);
    }
}
