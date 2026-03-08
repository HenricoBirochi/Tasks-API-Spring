package henrico.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import henrico.tasks.application.services.FindUserByIdService;

@Configuration
public class FindUserByIdConfig {
    @Bean
    public FindUserByIdService findUserByIdUseCase() {
        return new FindUserByIdService();
    }
}
