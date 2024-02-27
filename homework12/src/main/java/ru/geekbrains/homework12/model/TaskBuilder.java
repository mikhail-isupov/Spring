package ru.geekbrains.homework12.model;

import java.util.Date;

/**
 * Bilder для построения задачи с интерфейсом ITask.
 */
public class TaskBuilder {
    private final ITask task;

    public TaskBuilder(ITask task){
        this.task = task;
    }

    public TaskBuilder setTaskTitle(String title){
        task.setTaskTitle(title);
        return this;
    }

    public TaskBuilder setTaskStatus(TaskStatus taskStatus){
        task.setTaskStatus(taskStatus);
        return this;
    }

    public TaskBuilder setTaskCreationTime(){
        task.setTaskCreationTime(new Date());
        return this;
    }

    public TaskBuilder setTaskModificationTime(){
        task.setTaskModificationTime(new Date());
        return this;
    }

    public ITask build(){
        return task;
    }

}
