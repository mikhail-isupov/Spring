package ru.geekbrains.homework12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Сущность для описания экстренных задач.
 *
 */
@Entity
@Table(name = "urgent_tasks")
public class UrgentTaskEntity extends Task {
}
