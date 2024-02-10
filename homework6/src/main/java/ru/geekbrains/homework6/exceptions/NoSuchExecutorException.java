package ru.geekbrains.homework6.exceptions;

import java.util.NoSuchElementException;

public class NoSuchExecutorException extends NoSuchElementException {
    public NoSuchExecutorException(){
        super("Исполнитель не найден.");
    }
}
