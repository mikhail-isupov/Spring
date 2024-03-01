package ru.geekbrains.homework12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Сущность для описания стандартной задачи.
 */
@Entity
@Table(name = "ordinary_tasks")
public class OrdinaryTaskEntity extends Task {
}
