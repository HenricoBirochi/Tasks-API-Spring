package henrico.tasks.adapters.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String message;
    private String possibleWrongVariable;
}
