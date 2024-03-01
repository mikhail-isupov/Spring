package ru.geekbrains.goods_server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.goods_server.model.ItemEntity;

public interface iGoodsRepo extends JpaRepository<ItemEntity, Integer> {
}
