package ru.geekbrains.homework12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.homework12.model.TasksFabric;

@Configuration
public class AppConfig {
    @Bean
    public TasksFabric tasksFabric(){
        return new TasksFabric();
    }
}
