package ru.geekbrains.homework6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework6.exceptions.NoSuchTaskException;
import ru.geekbrains.homework6.model.TaskEntity;
import ru.geekbrains.homework6.repo.iTasksRepo;

import java.util.List;

@Service
public class TasksService implements iTasksService{
    @Autowired
    private iTasksRepo tasksRepo;

    public TaskEntity createTask(String description){
        TaskEntity newTask = new TaskEntity(description);
        return tasksRepo.save(newTask);
    }

    public List<TaskEntity> readTasks(){
        return tasksRepo.findAll();
    }

    public List<TaskEntity> readTasks(TaskEntity.Status taskStatus){
        return tasksRepo.findByStatus(taskStatus);
    }

    public TaskEntity readTask(Integer id){
        return tasksRepo.findById(id).orElseThrow(NoSuchTaskException::new);
    }

    public TaskEntity updateTask(Integer id, TaskEntity.Status status){
        TaskEntity updatedTask = tasksRepo.findById(id).orElseThrow(NoSuchTaskException::new);
        updatedTask.setStatus(status);
        return tasksRepo.save(updatedTask);
    }

    public void deleteTask(Integer id){
        tasksRepo.findById(id).orElseThrow(NoSuchTaskException::new);
        tasksRepo.deleteById(id);
    }
}
