package ru.geekbrains.homework2;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Имитация репозитория
 */
@Repository
public class Repo implements iRepo{
    private static final String[] DATA = {"Привет", "Hello", "Hola", "Hallo", "Салам"};

    public String getRandomHello(){
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(DATA.length);
        return DATA[randomIndex];
    }
}
