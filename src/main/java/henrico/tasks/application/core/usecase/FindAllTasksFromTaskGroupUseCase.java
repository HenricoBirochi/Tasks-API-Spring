package henrico.tasks.application.core.usecase;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.FindAllTasksFromTaskGroupInputPort;
import henrico.tasks.application.ports.out.FindAllTasksFromTaskGroupOutputPort;

public class FindAllTasksFromTaskGroupUseCase implements FindAllTasksFromTaskGroupInputPort {

    private final FindAllTasksFromTaskGroupOutputPort findAllTasksFromTaskGroupOutputPort;

    public FindAllTasksFromTaskGroupUseCase(FindAllTasksFromTaskGroupOutputPort findAllTasksFromTaskGroupOutputPort) {
        this.findAllTasksFromTaskGroupOutputPort = findAllTasksFromTaskGroupOutputPort;
    }

    @Override
    public List<Task> findAllTasks(UUID taskGroupId) {
        return findAllTasksFromTaskGroupOutputPort.findAllTasks(taskGroupId);
    }

}
