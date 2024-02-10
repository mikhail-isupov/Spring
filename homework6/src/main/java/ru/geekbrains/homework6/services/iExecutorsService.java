package ru.geekbrains.homework6.services;

import ru.geekbrains.homework6.model.ExecutorEntity;
import ru.geekbrains.homework6.model.TaskEntity;

import java.util.List;

public interface iExecutorsService {
    ExecutorEntity createExecutor(String name);//Создание исполнителя
    List<ExecutorEntity> readExecutors();//Получение всех исполнителей
    ExecutorEntity readExecutor(Integer id);//Получение исполнителя по id
    List<ExecutorEntity> readExecutors(Integer taskId); //Получение всех исполнителей задачи

    ExecutorEntity updateExecutor(Integer executorId, Integer taskId);//Присвоение задачи исполнителю.

    void deleteExecutor(Integer executorId);//Удаление исполнителя.

}
