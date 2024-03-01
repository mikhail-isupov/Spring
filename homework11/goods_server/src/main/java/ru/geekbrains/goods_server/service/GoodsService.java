package ru.geekbrains.goods_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.goods_server.model.ItemEntity;
import ru.geekbrains.goods_server.repo.iGoodsRepo;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoodsService implements iGoodsService{

    @Autowired
    iGoodsRepo goodsRepo;

    public ItemEntity postItem(ItemEntity item){
        return goodsRepo.save(item);
    }

    public ItemEntity getItem(Integer itemId){
        return goodsRepo.findById(itemId).orElseThrow(NoSuchElementException::new);
    }

    public List<ItemEntity> getItems(){
        return goodsRepo.findAll();
    }

    public void deleteItem(Integer itemId) {
        goodsRepo.deleteById(itemId);
    }
}
