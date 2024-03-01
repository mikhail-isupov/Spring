package ru.geekbrains.goods_server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.goods_server.model.ItemEntity;

import java.util.List;


public interface iGoodsController {

    ItemEntity postItem(ItemEntity item);

    ItemEntity getItem(Integer itemId);

    List<ItemEntity> getItems();

    void deleteItem(Integer itemId);

}
