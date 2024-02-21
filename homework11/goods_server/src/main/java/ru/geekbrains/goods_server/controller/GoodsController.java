package ru.geekbrains.goods_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.goods_server.model.ItemEntity;
import ru.geekbrains.goods_server.service.iGoodsService;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController implements iGoodsController {
    @Autowired
    iGoodsService goodsService;

    /**
     * Запись товара в базу данных
     * @param item @RequestBody JSON ItemEntity c описанием товара:
     * {ItemEntity.ItemCategory itemCategory, String itemModel, String itemDescription}
     * @return ItemEntity c добавленным id
     */

    @PostMapping
    public ItemEntity postItem(@RequestBody ItemEntity item){
        return goodsService.postItem(item);
    }

    /**
     * Получение товара из базы данных по id
     * @param itemId - @PathVariable id товара.
     * @return
     */
    @GetMapping("/{itemId}")
    public ItemEntity getItem(@PathVariable Integer itemId){
        return goodsService.getItem(itemId);
    }

    /**
     * Получение списка всех товаров в базе данных.
     * @return List<ItemEntity> список всех товаров.
     */
    @GetMapping
    public List<ItemEntity> getItems(){
        return goodsService.getItems();
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Integer itemId){
        goodsService.deleteItem(itemId);
    }


}
