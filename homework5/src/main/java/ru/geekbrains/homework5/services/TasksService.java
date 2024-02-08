package ru.geekbrains.homework5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework5.model.TaskEntity;
import ru.geekbrains.homework5.repo.iTasksRepo;

import java.util.List;
@Service
public class TasksService implements iTasksService {
    @Autowired
    private iTasksRepo tasksRepo;
    public List<TaskEntity> getAllTasks(){
        return tasksRepo.findAll();
    }

    public TaskEntity saveTask(TaskEntity task){
        return tasksRepo.save(task);
    }

    public TaskEntity getTaskById(Long id){
        return tasksRepo.getReferenceById(id);
    }

    public TaskEntity modifyTaskStatus(Long id, TaskEntity.Status status){
        TaskEntity modifiedTask = getTaskById(id);
        modifiedTask.setStatus(status);
        return tasksRepo.save(modifiedTask);
    }

    public List<TaskEntity> getTasksByStatus(TaskEntity.Status status){
        return tasksRepo.findByStatus(status);
    }

    public void deleteTaskById(Long id){
        tasksRepo.deleteById(id);
    }

}
