package ru.geekbrains.shopping_server.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.geekbrains.shopping_server.model.ItemEntity;

import java.util.List;

public interface iShoppingService {
    ResponseEntity<String> postItem(Integer itemId); //Добавление товара в корзину по id.

    ResponseEntity<String> deleteItem(Integer itemId); //Удаление товара из корзины по id

    List<ItemEntity> makeOrder(); // Создание заказа

}
