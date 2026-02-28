package henrico.tasks.config;

import henrico.tasks.adapters.out.jpa.JpaImageRepositoryAdapter;
import henrico.tasks.adapters.out.jpa.JpaUserRepositoryAdapter;
import henrico.tasks.application.core.usecase.CreateUserWithImageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateUserWithImageConfig {

    @Bean
    public CreateUserWithImageUseCase createUserUseCase(
        JpaImageRepositoryAdapter jpaImageRepositoryAdapter,
        JpaUserRepositoryAdapter jpaUserRepositoryAdapter
    ) {
        return new CreateUserWithImageUseCase(
            jpaImageRepositoryAdapter,
            jpaUserRepositoryAdapter
        );
    }
}
