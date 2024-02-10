package ru.geekbrains.homework6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework6.model.TaskEntity;
import ru.geekbrains.homework6.services.iTasksService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    private iTasksService tasksService;

    @GetMapping
    public List<TaskEntity> readTasks(){
        return tasksService.readTasks();
    }

    @GetMapping("/filter")
    public List<TaskEntity> readTasks(@RequestParam TaskEntity.Status status){
        return tasksService.readTasks(status);
    }

    @GetMapping("/{id}")
    public TaskEntity readTask(@PathVariable Integer id){
        return tasksService.readTask(id);
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody String description){
        return tasksService.createTask(description);
    }

    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable Integer id, @RequestParam TaskEntity.Status status){
        return tasksService.updateTask(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        tasksService.deleteTask(id);
    }








}
