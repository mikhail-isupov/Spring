package ru.geekbrains.homework12.model;

/**
 * Интерфейс фабрики задач.
 */
public interface ITasksFabric {
    Task createTask(TaskDTO task);
}
