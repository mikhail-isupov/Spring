package ru.geekbrains.homework5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework5.model.TaskEntity;
import ru.geekbrains.homework5.services.TasksService;
import ru.geekbrains.homework5.services.iTasksService;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksRestApi {

    @Autowired
    iTasksService tasksService;
    /**
     * Добавление задачи
     * @return Task
     */
    @PostMapping
    TaskEntity postTask(@RequestBody String description){
        TaskEntity newTask = new TaskEntity(description);
        return tasksService.saveTask(newTask);
    }

    /**
     * Получение всего списка задач
     * @return список Task
     */
    @GetMapping
    List<TaskEntity> getAllTasks(){
        return tasksService.getAllTasks();
    }

    /**
     * Получение отфильтрованного списка задач
     */
    @GetMapping("/filter")
    List<TaskEntity> getTasksByStatus(@RequestParam TaskEntity.Status status){
        return tasksService.getTasksByStatus(status);
    }
    /**
     * Изменение статуса задачи
     */
    @PutMapping
    TaskEntity putTask(@RequestParam Long id, @RequestParam TaskEntity.Status status){
        return tasksService.modifyTaskStatus(id, status);
    }

    /**
     * Удаление задачи
     */
    @DeleteMapping
    void delTask(@RequestParam Long id){
        tasksService.deleteTaskById(id);
    }

}
