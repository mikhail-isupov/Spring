package ru.geekbrains.homework10.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework10.model.SessionEntity;
import ru.geekbrains.homework10.model.UserEntity;

import java.util.Optional;

public interface iSessionRepo extends JpaRepository<SessionEntity, Integer> {
    Optional<SessionEntity> findByUser(UserEntity user);
}
