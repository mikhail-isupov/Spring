package ru.geekbrains.homework12.service;
import ru.geekbrains.homework12.model.*;

import java.util.List;

public interface ITasksService<T extends Task> {
    Task createTask(TaskDTO task); //Создание и добавление задачи со статусом
    List<Task> readTasks(TaskPriority taskPriority); // Чтение всех  задач для выбранного приоритета

}
