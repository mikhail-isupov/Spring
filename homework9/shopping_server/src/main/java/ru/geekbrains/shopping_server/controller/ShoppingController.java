package ru.geekbrains.shopping_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.shopping_server.model.ItemEntity;
import ru.geekbrains.shopping_server.service.iShoppingService;

import java.util.List;

@RestController
@RequestMapping("api/cart")
public class ShoppingController implements iShoppingController{

    @Autowired
    iShoppingService shoppingService;

    /**
     * Добавление товара в корзинку по itemId
     * @param itemId @PathVariable
     * @return HttpStatus
     */
    @PostMapping("/{itemId}")
    public ResponseEntity<String> postItem(@PathVariable Integer itemId){
        return shoppingService.postItem(itemId);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable Integer itemId){
        return shoppingService.deleteItem(itemId);
    }

    @GetMapping
    public List<ItemEntity> makeOrder(){
        return shoppingService.makeOrder();
    }
}
