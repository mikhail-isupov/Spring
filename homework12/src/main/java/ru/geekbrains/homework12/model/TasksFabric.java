package ru.geekbrains.homework12.model;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/**
 * Фабрика создает из DTO объекты разных классов-наследников задачи, представляющих разные сущности.
 */
public class TasksFabric implements ITasksFabric{

    public Task createTask(TaskDTO task){
        Task newTask = null;
        switch (task.taskPriority()){
            case URGENT -> newTask = new UrgentTaskEntity();
            case ORDINARY -> newTask = new OrdinaryTaskEntity();
        }
        TaskBuilder builder = new TaskBuilder(newTask);
       builder
               .setTaskTitle(task.taskTitle())
               .setTaskStatus(task.taskStatus())
               .setTaskCreationTime()
               .build();

        return newTask;
    }
}
