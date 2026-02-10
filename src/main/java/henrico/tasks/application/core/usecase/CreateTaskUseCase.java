package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.core.usecase.exceptions.DeadlineIsBeforeCurrentDateTimeException;
import henrico.tasks.application.core.usecase.exceptions.TaskAlreadyExistsException;
import henrico.tasks.application.core.usecase.exceptions.UserNotExistsException;
import henrico.tasks.application.ports.in.CreateTaskInputPort;
import henrico.tasks.application.ports.out.repository.TaskRepositoryOutputPort;
import henrico.tasks.application.ports.out.repository.UserRepositoryOutputPort;
import java.time.LocalDateTime;
import java.util.UUID;

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
            | UserNotExistsException exception
        ) {
            return new Task();
        }
    }

    public void verifyIfDeadlineIsAfterNow(LocalDateTime deadline) {
        if (deadline.isBefore(LocalDateTime.now())) {
            throw new DeadlineIsBeforeCurrentDateTimeException(
                "The deadline must be after the current date and time!"
            );
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
            throw new UserNotExistsException("User doesn't exist!");
        }
    }
}
