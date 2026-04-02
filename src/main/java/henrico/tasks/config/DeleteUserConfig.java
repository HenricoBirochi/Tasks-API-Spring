package henrico.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import henrico.tasks.application.services.DeleteUserService;
import henrico.tasks.infra.jpa.JpaImageRepositoryUsing;
import henrico.tasks.infra.jpa.JpaUserRepositoryUsing;

@Configuration
public class DeleteUserConfig {
    @Bean
    public DeleteUserService deleteUserService(
        JpaUserRepositoryUsing jpaUserRepositoryUsing,
        JpaImageRepositoryUsing jpaImageRepositoryUsing
    ) {
        return new DeleteUserService(jpaUserRepositoryUsing, jpaImageRepositoryUsing);
    }
}
