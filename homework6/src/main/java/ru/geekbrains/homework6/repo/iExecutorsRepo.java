package ru.geekbrains.homework6.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework6.model.ExecutorEntity;
import ru.geekbrains.homework6.model.TaskEntity;

import java.util.List;

public interface iExecutorsRepo extends JpaRepository<ExecutorEntity, Integer> {
    List<ExecutorEntity> findByTask(TaskEntity task);
}
