package ru.geekbrains.feedback_server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.feedback_server.model.ItemEntity;

public interface iGoodsRepo extends JpaRepository<ItemEntity, Integer> {
}
