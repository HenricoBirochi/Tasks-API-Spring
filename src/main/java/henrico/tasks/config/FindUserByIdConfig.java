package henrico.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import henrico.tasks.application.core.usecase.user.FindUserByIdUseCase;

@Configuration
public class FindUserByIdConfig {
    @Bean
    public FindUserByIdUseCase findUserByIdUseCase() {
        return new FindUserByIdUseCase();
    }
}
