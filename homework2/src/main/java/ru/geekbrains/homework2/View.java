package ru.geekbrains.homework2;

import org.springframework.stereotype.Component;

@Component
/**
 * Оборачивает сообщение в HTML код
 */
public class View implements iView {
    public String wrapMessage(String message){
        return "<p style = \"color: red\">" + message + "</p>";
    }
}
