package ru.geekbrains.homework12.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework12.model.*;

import java.util.List;


public interface ITasksController {

    Task createTask(TaskDTO task); //Создание и добавление задачи со статусом
    List<Task> readTasks(TaskPriority taskPriority); // Чтение всех  задач для выбранного приоритета
}
