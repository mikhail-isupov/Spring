package ru.geekbrains.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.homework10.model.User;
import ru.geekbrains.homework10.model.UserEntity;
import ru.geekbrains.homework10.service.iAuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private iAuthService authService;

    @PostMapping("/register")
    public Integer register(@RequestBody User user){
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {return authService.login(user);}

    @PostMapping("/logout")
    public void logout(@RequestBody User user) {authService.logout(user);}
}
