package henrico.tasks.config;

import henrico.tasks.infra.jpa.JpaImageRepositoryImpl;
import henrico.tasks.infra.jpa.JpaUserRepositoryImpl;
import henrico.tasks.application.services.CreateUserWithImageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserWithImageConfig {

    @Bean
    public CreateUserWithImageService createUserUseCase(
        JpaImageRepositoryImpl jpaImageRepositoryImpl,
        JpaUserRepositoryImpl jpaUserRepositoryImpl
    ) {
        return new CreateUserWithImageService(
                jpaImageRepositoryImpl,
                jpaUserRepositoryImpl
        );
    }
}
