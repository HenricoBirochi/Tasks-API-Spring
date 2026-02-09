package henrico.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import henrico.tasks.adapters.out.jpa.JpaTaskRepositoryAdapter;
import henrico.tasks.adapters.out.jpa.JpaUserRepositoryAdapter;
import henrico.tasks.application.core.usecase.user.CreateUserUseCase;

@Configuration
public class CreateUserConfig {
    @Bean
    public CreateUserUseCase createUserUseCase(
        JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter,
        JpaUserRepositoryAdapter jpaUserRepositoryAdapter
    ) {
        return new CreateUserUseCase(jpaTaskRepositoryAdapter, jpaUserRepositoryAdapter);
    }
}
