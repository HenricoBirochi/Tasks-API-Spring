package henrico.tasks.application.services;

import java.time.LocalDateTime;
import java.util.UUID;

import henrico.tasks.core.domain.Task;
import henrico.tasks.core.exceptions.DeadlineIsBeforeCurrentDateTimeException;
import henrico.tasks.core.exceptions.TaskAlreadyExistsException;
import henrico.tasks.core.exceptions.UserNotFoundException;
import henrico.tasks.core.usecases.CreateTaskUseCase;
import henrico.tasks.adapters.repository.TaskRepositoryGateway;
import henrico.tasks.adapters.repository.UserRepositoryGateway;

public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryGateway taskRepositoryGateway;
    private final UserRepositoryGateway userRepositoryGateway;

    public CreateTaskService(
        TaskRepositoryGateway taskRepositoryGateway,
        UserRepositoryGateway userRepositoryGateway
    ) {
        this.taskRepositoryGateway = taskRepositoryGateway;
        this.userRepositoryGateway = userRepositoryGateway;
    }

    @Override
    public Task createTask(Task task) {
        try {
            verifyIfDeadlineIsAfterNow(task.getDeadline());
            verifyIfTaskAlreadyExists(task.getId());
            verifyIfUserAlreadyExists(task.getUserId());
            return taskRepositoryGateway.insert(task);
        } catch (
            TaskAlreadyExistsException
            | DeadlineIsBeforeCurrentDateTimeException
            | UserNotFoundException exception
        ) {
            return new Task();
        }
    }

    public void verifyIfDeadlineIsAfterNow(LocalDateTime deadline) {
        if (deadline.isBefore(LocalDateTime.now())) {
            throw new DeadlineIsBeforeCurrentDateTimeException("The deadline must be after the current date and time!", deadline);
        }
    }

    public void verifyIfTaskAlreadyExists(UUID taskId) {
        var task = taskRepositoryGateway.findById(taskId);
        if (task != null) {
            throw new TaskAlreadyExistsException("The task already exists!");
        }
    }

    public void verifyIfUserAlreadyExists(UUID userId) {
        var user = userRepositoryGateway.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User doesn't exist!");
        }
    }
}
