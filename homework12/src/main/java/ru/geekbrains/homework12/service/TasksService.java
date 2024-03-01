package ru.geekbrains.homework12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework12.model.*;
import ru.geekbrains.homework12.repo.IOrdinaryTasksRepo;
import ru.geekbrains.homework12.repo.IUrgentTasksRepo;

import java.util.List;

@Service
public class TasksService implements ITasksService {
    @Autowired
    private IOrdinaryTasksRepo ordinaryTasksRepo;
    @Autowired
    private IUrgentTasksRepo urgentTasksRepo;
    @Autowired
    private ITasksFabric tasksFabric;

    /**
     * Создает из DTO разные сущности и сохраняет их в разные репозитории.
     * @param task - DTO c описанием задачи.
     * @return Task
     */
    public Task createTask(TaskDTO task){
        Task newTask = tasksFabric.createTask(task);
        if (newTask instanceof UrgentTaskEntity) return urgentTasksRepo.save((UrgentTaskEntity) newTask);
        if (newTask instanceof OrdinaryTaskEntity) return ordinaryTasksRepo.save((OrdinaryTaskEntity) newTask);
        return null;
    }

    public List<Task> readTasks(TaskPriority taskPriority){
        switch (taskPriority){
            case URGENT: return urgentTasksRepo.findAll().stream().map(task -> (Task) task).toList();
            case ORDINARY: return ordinaryTasksRepo.findAll().stream().map(task -> (Task) task).toList();
        }
        return null;
    }


}
