package ru.geekbrains.homework12.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * POJO для описания задачи.
 */

@MappedSuperclass
public class Task implements ITask{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String taskTitle;
    @Column(nullable = false)
    private TaskStatus taskStatus;
    @Column(nullable = false)
    private Date taskCreationTime;
    @Column(nullable = true)
    private Date taskModificationTime;


    public Task(){}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getTaskTitle() {
        return taskTitle;
    }

    @Override
    public void setTaskTitle(String title){
        this.taskTitle = title;
    }

    @Override
    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    @Override
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public Date getTaskCreationTime() {
        return taskCreationTime;
    }

    @Override
    public void setTaskCreationTime(Date time){
        this.taskCreationTime = time;
    }

    @Override
    public Date getTaskModificationTime() {
        return taskModificationTime;
    }

    @Override
    public void setTaskModificationTime(Date time){
        this.taskModificationTime = time;
    }

}
