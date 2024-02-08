package ru.geekbrains.homework5.services;

import ru.geekbrains.homework5.model.TaskEntity;

import java.util.List;

public interface iTasksService {
    List<TaskEntity> getAllTasks();
    TaskEntity saveTask(TaskEntity task);
    TaskEntity getTaskById(Long id);

    TaskEntity modifyTaskStatus(Long id, TaskEntity.Status status);

    List<TaskEntity> getTasksByStatus(TaskEntity.Status status);

    void deleteTaskById(Long id);

}
