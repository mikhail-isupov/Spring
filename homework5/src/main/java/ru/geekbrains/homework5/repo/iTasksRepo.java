package ru.geekbrains.homework5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework5.model.TaskEntity;

import java.util.List;

public interface iTasksRepo extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByStatus(TaskEntity.Status status);
}
