package ru.geekbrains.homework6.model;

import jakarta.persistence.*;

/**
 * Исполнитель
 */
@Entity
public class ExecutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(nullable = true)
    private TaskEntity task;

    public ExecutorEntity(String name){
        this.name = name;
        this.task = null;
    }

    public ExecutorEntity(){

    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TaskEntity getTask() {
        return task;
    }
}
