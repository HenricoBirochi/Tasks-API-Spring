package henrico.tasks.config;

import henrico.tasks.adapters.out.jpa.JpaTaskGroupRepositoryAdapter;
import henrico.tasks.application.core.usecase.TaskGroupUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskGroupConfig {
    @Bean
    public TaskGroupUseCases taskGroupUseCases(JpaTaskGroupRepositoryAdapter jpaTaskGroupRepositoryAdapter) {
        return new TaskGroupUseCases(jpaTaskGroupRepositoryAdapter);
    }
}
