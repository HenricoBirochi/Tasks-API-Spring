package henrico.tasks.config;

import henrico.tasks.infra.jpa.JpaImageRepositoryUsing;
import henrico.tasks.infra.jpa.JpaUserRepositoryUsing;
import henrico.tasks.application.services.CreateUserWithImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserWithImageConfig {
    @Bean
    public CreateUserWithImageService createUserWithImageService(
        JpaImageRepositoryUsing jpaImageRepositoryUsing,
        JpaUserRepositoryUsing jpaUserRepositoryUsing
    ) {
        return new CreateUserWithImageService(
                jpaImageRepositoryUsing,
                jpaUserRepositoryUsing
        );
    }
}
