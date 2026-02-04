package henrico.tasks.adapters.in.controller.mapper.task;

import henrico.tasks.adapters.in.controller.dto.task.TaskRequestDTO;
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
