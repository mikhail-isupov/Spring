package ru.geekbrains.homework2;

import org.springframework.stereotype.Service;

/**
 * Генерация слова "Привет" на разных языках.
 */
@Service
public class HelloService implements iHelloService {

    private final iRepo repo;
    public HelloService(iRepo repo){
        this.repo = repo;
    }
    public String getHelloMessage(){
        return repo.getRandomHello();
    }
}
