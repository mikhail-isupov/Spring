package ru.geekbrains.feedback_server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.feedback_server.model.FeedbackEntity;
import ru.geekbrains.feedback_server.model.ItemEntity;

import java.util.List;

public interface iFeedbackRepo extends JpaRepository<FeedbackEntity, Integer> {
    List<FeedbackEntity> findByItem(ItemEntity item);
}
