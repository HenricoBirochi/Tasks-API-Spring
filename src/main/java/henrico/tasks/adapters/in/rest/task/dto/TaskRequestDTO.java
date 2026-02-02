package henrico.tasks.adapters.in.rest.task.dto;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.core.domain.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    private String title;
    private String description;
    private Integer coins;
    private LocalDateTime deadline;
    private TaskStatus taskStatus;
    private UUID taskGroupId;
}
