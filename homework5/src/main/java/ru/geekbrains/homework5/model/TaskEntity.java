package ru.geekbrains.homework5.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Сущность для описания задачи
 */
@Entity
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Status status;
    @Column(nullable = false)
    private Date date;

    public enum Status {
        NOT_STARTED, IN_PROGRESS, FINISHED
    }

    public TaskEntity(String description) {
        this.description = description;
        this.status = Status.NOT_STARTED;
        this.date = new Date();
    }

    public TaskEntity() {
        //Пустой конструктор
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", date=" + date;
    }
}
