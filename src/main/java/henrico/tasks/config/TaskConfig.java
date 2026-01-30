package henrico.tasks.config;

import henrico.tasks.adapters.out.jpa.JpaTaskRepositoryImpl;
import henrico.tasks.application.core.usecase.TaskUseCases;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
    public TaskUseCases taskUseCases(JpaTaskRepositoryImpl jpaTaskRepositoryImpl) {
        return new TaskUseCases(jpaTaskRepositoryImpl);
    }
}
