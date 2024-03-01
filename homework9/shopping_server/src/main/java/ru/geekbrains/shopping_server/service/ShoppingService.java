package ru.geekbrains.shopping_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.geekbrains.shopping_server.model.ItemEntity;
import ru.geekbrains.shopping_server.repo.iGoodsRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingService implements iShoppingService{
    private final iGoodsRepo goodsRepo;
    private final Map<Integer, ItemEntity> shoppingCart;
    public ShoppingService(iGoodsRepo goodsRepo){
        shoppingCart = new HashMap<>();
        this.goodsRepo = goodsRepo;
    }

    /**
     * Добавление товара в корзину по id.
     * @param itemId id товара
     * @return HttpStatus (ok или not found)
     */
    public ResponseEntity<String> postItem(Integer itemId){
        ItemEntity item = goodsRepo.findById(itemId).orElse(null);
        if (item != null) {
            shoppingCart.put(item.getId(), item);
            return ResponseEntity.ok(String.format("Товар %s добавлен в корзину.", item.getItemModel()));
        }
        return new ResponseEntity<String>("Товар не найден.", HttpStatus.NOT_FOUND);
    }

    /**
     *  * Удаление товара из корзины по id.
     *   @param itemId id товара
     *   @return HttpStatus (ok или not found)
     */
    public ResponseEntity<String> deleteItem(Integer itemId){
        if (shoppingCart.containsKey(itemId)) {
            return ResponseEntity.ok(String.format("Товар %s удален из корзины.", shoppingCart.remove(itemId).getItemModel()));
        }
        return new ResponseEntity<String>("Такого товара нет в корзине.", HttpStatus.NOT_FOUND);
    }

    public List<ItemEntity> makeOrder(){
        List<ItemEntity> order = shoppingCart.values().stream().toList();
        shoppingCart.clear();
        return order;
    }


}
