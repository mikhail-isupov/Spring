package ru.geekbrains.homework6.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Задача
 */
@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status;

    public enum Status{
        NOT_STARTED,
        IN_PROGRESS,
        FINISHED;
    }

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = true)
    private Date finishDate;

    public TaskEntity(String description){
        this.description = description;
        this.startDate = new Date();
        this.status = Status.NOT_STARTED;
        this.finishDate = null;
    }

    public TaskEntity(){

    }

    public void setStatus(Status status){
        this.status = status;
        if (status == Status.NOT_STARTED) {
            this.startDate = new Date();
            this.finishDate = null;
        }
        if (status == Status.FINISHED){
            this.finishDate = new Date();
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Date getStartDate() {
        return startDate;
    }
}
