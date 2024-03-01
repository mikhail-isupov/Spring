package ru.geekbrains.homework12.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework12.model.OrdinaryTaskEntity;

public interface IOrdinaryTasksRepo extends JpaRepository<OrdinaryTaskEntity, Long> {
}
