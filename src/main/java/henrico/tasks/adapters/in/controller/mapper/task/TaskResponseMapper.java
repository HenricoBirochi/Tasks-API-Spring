package henrico.tasks.adapters.in.controller.mapper.task;

import henrico.tasks.adapters.in.controller.dto.task.TaskResponseDTO;
import henrico.tasks.application.core.domain.Task;

public class TaskResponseMapper {
    public static TaskResponseDTO toTaskResponse(Task task) {
        return TaskResponseDTO
                .builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .taskStatus(task.getTaskStatus())
                .build();
    }
}
