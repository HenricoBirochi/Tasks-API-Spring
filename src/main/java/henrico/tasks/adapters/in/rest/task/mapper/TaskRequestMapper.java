package henrico.tasks.adapters.in.rest.task.mapper;

import henrico.tasks.adapters.in.rest.task.dto.TaskRequestDTO;
import henrico.tasks.application.core.domain.Task;

public class TaskRequestMapper {
    public static Task toTask(TaskRequestDTO taskRequestDTO) {
        return new Task(
                taskRequestDTO.getTitle(),
                taskRequestDTO.getDescription(),
                taskRequestDTO.getCoins(),
                taskRequestDTO.getDeadline(),
                taskRequestDTO.getTaskStatus(),
                taskRequestDTO.getTaskGroupId()
        );
    }
}
