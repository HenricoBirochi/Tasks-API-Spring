package henrico.tasks.application.core.usecase;

import java.time.LocalDateTime;
import java.util.UUID;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.core.usecase.exceptions.DeadlineIsBeforeCurrentDateTimeException;
import henrico.tasks.application.core.usecase.exceptions.TaskAlreadyExistsException;
import henrico.tasks.application.core.usecase.exceptions.UserNotFoundException;
import henrico.tasks.application.ports.in.CreateTaskInputPort;
import henrico.tasks.application.ports.out.repository.TaskRepositoryOutputPort;
import henrico.tasks.application.ports.out.repository.UserRepositoryOutputPort;

public class CreateTaskUseCase implements CreateTaskInputPort {

    private final TaskRepositoryOutputPort taskRepositoryOutputPort;
    private final UserRepositoryOutputPort userRepositoryOutputPort;

    public CreateTaskUseCase(
        TaskRepositoryOutputPort taskRepositoryOutputPort,
        UserRepositoryOutputPort userRepositoryOutputPort
    ) {
        this.taskRepositoryOutputPort = taskRepositoryOutputPort;
        this.userRepositoryOutputPort = userRepositoryOutputPort;
    }

    @Override
    public Task createTask(Task task) {
        try {
            verifyIfDeadlineIsAfterNow(task.getDeadline());
            verifyIfTaskAlreadyExists(task.getId());
            verifyIfUserAlreadyExists(task.getUserId());
            return taskRepositoryOutputPort.insert(task);
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
        var task = taskRepositoryOutputPort.findById(taskId);
        if (task != null) {
            throw new TaskAlreadyExistsException("The task already exists!");
        }
    }

    public void verifyIfUserAlreadyExists(UUID userId) {
        var user = userRepositoryOutputPort.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User doesn't exist!");
        }
    }
}
