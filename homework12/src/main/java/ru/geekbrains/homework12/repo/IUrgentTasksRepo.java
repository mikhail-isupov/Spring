package ru.geekbrains.homework12.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework12.model.UrgentTaskEntity;

/**
 * Репозиторий для задач.
 */
public interface IUrgentTasksRepo extends JpaRepository<UrgentTaskEntity, Long> {
}
