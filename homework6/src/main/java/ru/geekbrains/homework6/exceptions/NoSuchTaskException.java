package ru.geekbrains.homework6.exceptions;

import java.util.NoSuchElementException;

public class NoSuchTaskException extends NoSuchElementException {
    public NoSuchTaskException(){
        super("Задача не найдена.");
    }
}
