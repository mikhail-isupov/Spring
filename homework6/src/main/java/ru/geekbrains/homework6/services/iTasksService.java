package ru.geekbrains.homework6.services;

import ru.geekbrains.homework6.model.TaskEntity;

import java.util.List;

public interface iTasksService {
    TaskEntity createTask(String description);//Создание задачи из описания
    TaskEntity readTask(Integer taskId);//Чтение задачи по Id
    List<TaskEntity> readTasks();//Чтение всех задач
    List<TaskEntity> readTasks(TaskEntity.Status taskStatus);//Чтение всех задач по статусу
    TaskEntity updateTask(Integer taskId, TaskEntity.Status taskStatus);//Обновление статуса задачи nо id
    void deleteTask(Integer taskId);//Удаление задачи по id
}
