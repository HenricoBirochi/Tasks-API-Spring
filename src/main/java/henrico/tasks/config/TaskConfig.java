package henrico.tasks.config;

import henrico.tasks.adapters.out.jpa.JpaTaskRepositoryAdapter;
import henrico.tasks.application.core.usecase.TaskUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
    public TaskUseCases taskUseCases(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return new TaskUseCases(jpaTaskRepositoryAdapter);
    }
}
