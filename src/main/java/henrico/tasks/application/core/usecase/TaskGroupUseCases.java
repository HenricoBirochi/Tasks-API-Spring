package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.TaskGroupInputPort;
import henrico.tasks.application.ports.out.repository.TaskGroupRepository;

import java.util.List;
import java.util.UUID;

public class TaskGroupUseCases implements TaskGroupInputPort {

    private final TaskGroupRepository taskGroupRepository;

    public TaskGroupUseCases(TaskGroupRepository taskGroupRepository) {
        this.taskGroupRepository = taskGroupRepository;
    }

    @Override
    public TaskGroup insertTaskGroup(TaskGroup taskGroup) {
        return taskGroupRepository.insert(taskGroup);

    }

    @Override
    public TaskGroup findTaskGroupById(UUID taskGroupId) {
        return taskGroupRepository.findById(taskGroupId);
    }

    @Override
    public List<TaskGroup> findAllTaskGroups(UUID userId) {
        return taskGroupRepository.findAll(userId);
    }

    @Override
    public void deleteTaskGroup(UUID taskGroupId) {
        taskGroupRepository.delete(taskGroupId);
    }
}
