package henrico.tasks.adapters.in.controller.dto;

import henrico.tasks.application.core.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
