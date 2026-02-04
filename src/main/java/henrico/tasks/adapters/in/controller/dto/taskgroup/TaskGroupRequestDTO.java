package henrico.tasks.adapters.in.controller.dto.taskgroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskGroupRequestDTO {
    private String name;
}
