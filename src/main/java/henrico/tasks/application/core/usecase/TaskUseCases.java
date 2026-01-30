package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.TaskInputPort;
import henrico.tasks.application.ports.out.repository.TaskRepositoryOutputPort;

import java.util.List;
import java.util.UUID;

public class TaskUseCases implements TaskInputPort {

    private final TaskRepositoryOutputPort taskRepositoryOutputPort;

    public TaskUseCases(TaskRepositoryOutputPort taskRepositoryOutputPort) {
        this.taskRepositoryOutputPort = taskRepositoryOutputPort;
    }

    @Override
    public Task insertTask(Task task) {
        return taskRepositoryOutputPort.insert(task);
    }

    @Override
    public Task findTaskById(UUID taskId) {
        return taskRepositoryOutputPort.findById(taskId);
    }

    @Override
    public List<Task> findAllTasks(UUID taskGroupId) {
        return taskRepositoryOutputPort.findAll(taskGroupId);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepositoryOutputPort.delete(taskId);
    }
}
