package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.TaskInputPort;
import henrico.tasks.application.ports.out.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskUseCases implements TaskInputPort {

    private final TaskRepository taskRepository;

    public TaskUseCases(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task insertTask(Task task) {
        return taskRepository.insert(task);
    }

    @Override
    public Task findTaskById(UUID taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public List<Task> findAllTasks(UUID taskGroupId) {
        return taskRepository.findAll(taskGroupId);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepository.delete(taskId);
    }
}
