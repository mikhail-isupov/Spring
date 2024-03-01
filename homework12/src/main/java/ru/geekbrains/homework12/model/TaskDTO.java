package ru.geekbrains.homework12.model;

/**
 * Data Transfer Object для получения информации о задаче
 */
public record TaskDTO(String taskTitle, TaskStatus taskStatus, TaskPriority taskPriority) {
}
