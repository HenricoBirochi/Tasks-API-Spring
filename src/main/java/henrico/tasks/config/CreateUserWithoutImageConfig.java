package henrico.tasks.config;

import henrico.tasks.application.services.CreateUserWithoutImageService;
import henrico.tasks.infra.jpa.JpaUserRepositoryUsing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserWithoutImageConfig {
    @Bean
    public CreateUserWithoutImageService createUserWithoutImageService(
            JpaUserRepositoryUsing jpaUserRepositoryUsing
    ){
        return new CreateUserWithoutImageService(jpaUserRepositoryUsing);
    }
}
