package ru.geekbrains.homework6.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework6.exceptions.NoSuchExecutorException;
import ru.geekbrains.homework6.exceptions.NoSuchTaskException;
import ru.geekbrains.homework6.model.ExecutorEntity;
import ru.geekbrains.homework6.model.TaskEntity;
import ru.geekbrains.homework6.repo.iExecutorsRepo;
import ru.geekbrains.homework6.repo.iTasksRepo;

import java.util.List;

@Service
public class ExecutorsService implements iExecutorsService {
    @Autowired
    private iExecutorsRepo executorsRepo;
    @Autowired
    private iTasksRepo tasksRepo;

    public ExecutorEntity createExecutor(String name){
        ExecutorEntity newExecutor = new ExecutorEntity(name);
        return executorsRepo.save(newExecutor);
    }

    public ExecutorEntity readExecutor(Integer id){
        return executorsRepo.findById(id).orElseThrow(NoSuchExecutorException::new);
    }

    public List<ExecutorEntity> readExecutors(){
        return executorsRepo.findAll();
    }
    public List<ExecutorEntity> readExecutors(Integer taskId){
        TaskEntity task = tasksRepo.findById(taskId).orElseThrow(NoSuchTaskException::new);
        return executorsRepo.findByTask(task);
    }

    /**
     * Присвоение исполнителю задачи.
     * @param executorId id исполнителя
     * @param taskId id задачи.
     * @return Исполнителя с обновленной задачей.
     */
    public ExecutorEntity updateExecutor(Integer executorId, Integer taskId){
        TaskEntity task = tasksRepo.findById(taskId).orElseThrow(NoSuchTaskException::new);
        ExecutorEntity executor = executorsRepo.findById(executorId).orElseThrow(NoSuchExecutorException::new);
        executor.setTask(task);
        return executorsRepo.save(executor);
    }

    public void deleteExecutor(Integer id){
        executorsRepo.findById(id).orElseThrow(NoSuchExecutorException::new);
        executorsRepo.deleteById(id);
    }


}
