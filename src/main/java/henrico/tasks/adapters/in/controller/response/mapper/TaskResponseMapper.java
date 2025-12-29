package henrico.tasks.adapters.in.controller.response.mapper;

import henrico.tasks.adapters.in.controller.response.TaskResponse;
import henrico.tasks.application.core.domain.Task;

public class TaskResponseMapper {
    public static TaskResponse toTaskResponse(Task task) {
        return TaskResponse
                .builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .deadline(task.getDeadline())
                .taskStatus(task.getTaskStatus())
                .build();
    }
}
