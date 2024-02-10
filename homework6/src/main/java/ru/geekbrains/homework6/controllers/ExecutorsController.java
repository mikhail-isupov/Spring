package ru.geekbrains.homework6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework6.model.ExecutorEntity;
import ru.geekbrains.homework6.services.iTasksService;
import ru.geekbrains.homework6.services.iExecutorsService;

import java.util.List;

@RestController
@RequestMapping("/api/executors")
public class ExecutorsController {
    @Autowired
    private iExecutorsService executorsService;

    @GetMapping
    public List<ExecutorEntity> readExecutors() {
        return executorsService.readExecutors();
    }

    @GetMapping("/filter")
    public List<ExecutorEntity> readExecutors(@RequestParam Integer taskId){
        return executorsService.readExecutors(taskId);
    }

    @GetMapping("/{id}")
    public ExecutorEntity readExecutor(@PathVariable Integer id) {
        return executorsService.readExecutor(id);
    }

    @PostMapping
    public ExecutorEntity createExecutor(@RequestBody String name) {
        return executorsService.createExecutor(name);
    }

    @PutMapping("/{executorId}/{taskId}")
    public ExecutorEntity updateExecutor(@PathVariable Integer executorId, @PathVariable Integer taskId) {
        return executorsService.updateExecutor(executorId, taskId);
    }

    @DeleteMapping("/{id}")
    public void deleteExecutor(@PathVariable Integer id) {
        executorsService.deleteExecutor(id);
    }


}
