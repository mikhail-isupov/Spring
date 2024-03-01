package ru.geekbrains.shopping_server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.shopping_server.model.ItemEntity;

public interface iGoodsRepo extends JpaRepository<ItemEntity, Integer> {
}
