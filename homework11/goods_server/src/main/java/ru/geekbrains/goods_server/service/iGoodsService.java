package ru.geekbrains.goods_server.service;

import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.goods_server.model.ItemEntity;

import java.util.List;

public interface iGoodsService {
    ItemEntity postItem(ItemEntity item);
    ItemEntity getItem(Integer itemId);
    List<ItemEntity> getItems();
    void deleteItem(Integer itemId);

}
