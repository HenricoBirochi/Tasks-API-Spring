package henrico.tasks.config;

import henrico.tasks.adapters.out.jpa.JpaTaskGroupRepositoryImpl;
import henrico.tasks.application.core.usecase.TaskGroupUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskGroupConfig {
    @Bean
    public TaskGroupUseCases taskGroupUseCases(JpaTaskGroupRepositoryImpl jpaTaskGroupRepository) {
        return new TaskGroupUseCases(jpaTaskGroupRepository);
    }
}
