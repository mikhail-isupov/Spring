package ru.geekbrains.homework12.model;

import org.springframework.scheduling.config.Task;

import java.io.Serializable;
import java.util.Date;

/**
 * Интерфейс задачи.
 */
public interface ITask extends Serializable {
    Long getId(); // Получить ID задачи.

    String getTaskTitle(); // Получить название задачи.
    void setTaskTitle(String title); //Установить название задачи

    TaskStatus getTaskStatus(); // получить текущий статус задачи.

    void setTaskStatus(TaskStatus taskStatus); // Установить текущий статус задачи.

    Date getTaskCreationTime(); // получить время создания задачи.

    void setTaskCreationTime(Date time); // установить время создания задачи.

    Date getTaskModificationTime(); // Получить время последней модификации задачи.

    void setTaskModificationTime(Date time); //Установить время последней модификации задачи.

}