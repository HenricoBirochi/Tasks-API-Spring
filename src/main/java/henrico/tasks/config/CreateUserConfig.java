package henrico.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import henrico.tasks.adapters.out.jpa.JpaTaskRepositoryAdapter;
import henrico.tasks.adapters.out.jpa.JpaUserRepositoryAdapter;
import henrico.tasks.application.core.usecase.user.CreateUserWithoutImageUseCase;

@Configuration
public class CreateUserConfig {
    @Bean
    public CreateUserWithoutImageUseCase createUserUseCase(
        JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter,
        JpaUserRepositoryAdapter jpaUserRepositoryAdapter
    ) {
        return new CreateUserWithoutImageUseCase(jpaTaskRepositoryAdapter, jpaUserRepositoryAdapter);
    }
}
