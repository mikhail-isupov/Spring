package ru.geekbrains.homework6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework6.model.TaskEntity;

import java.util.List;

public interface iTasksRepo extends JpaRepository<TaskEntity, Integer> {
    List<TaskEntity> findByStatus(TaskEntity.Status status);
}
