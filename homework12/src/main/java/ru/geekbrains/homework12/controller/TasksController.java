package ru.geekbrains.homework12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework12.model.*;
import ru.geekbrains.homework12.service.ITasksService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TasksController implements ITasksController{
    @Autowired
    ITasksService tasksService;
    @PostMapping
    @Override
    public Task createTask(@RequestBody TaskDTO task) {
        return tasksService.createTask(task);
    }

    @GetMapping("/{taskPriority}")
    @Override
    public List<Task> readTasks(@PathVariable TaskPriority taskPriority) {
        return tasksService.readTasks(taskPriority);
    }
}
