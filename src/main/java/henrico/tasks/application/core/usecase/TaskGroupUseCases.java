package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.TaskGroupInputPort;
import henrico.tasks.application.ports.out.repository.TaskGroupRepositoryOutputPort;

import java.util.List;
import java.util.UUID;

public class TaskGroupUseCases implements TaskGroupInputPort {

    private final TaskGroupRepositoryOutputPort taskGroupRepositoryOutputPort;

    public TaskGroupUseCases(TaskGroupRepositoryOutputPort taskGroupRepositoryOutputPort) {
        this.taskGroupRepositoryOutputPort = taskGroupRepositoryOutputPort;
    }

    @Override
    public TaskGroup insertTaskGroup(TaskGroup taskGroup) {
        return taskGroupRepositoryOutputPort.insert(taskGroup);

    }

    @Override
    public TaskGroup findTaskGroupById(UUID taskGroupId) {
        return taskGroupRepositoryOutputPort.findById(taskGroupId);
    }

    @Override
    public List<TaskGroup> findAllTaskGroups(UUID userId) {
        return taskGroupRepositoryOutputPort.findAll(userId);
    }

    @Override
    public void deleteTaskGroup(UUID taskGroupId) {
        taskGroupRepositoryOutputPort.delete(taskGroupId);
    }
}
