package ru.geekbrains.homework10.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.homework10.model.UserEntity;

import java.util.Optional;

public interface iUserRepo extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
