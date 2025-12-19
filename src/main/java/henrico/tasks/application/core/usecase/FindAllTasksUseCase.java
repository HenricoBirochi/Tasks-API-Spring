package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.in.FindAllTasksInputPort;
import henrico.tasks.application.ports.out.FindAllTasksOutputPort;

import java.util.List;

public class FindAllTasksUseCase implements FindAllTasksInputPort {

    private final FindAllTasksOutputPort findAllTasksOutputPort;

    public FindAllTasksUseCase(FindAllTasksOutputPort findAllTasksOutputPort) {
        this.findAllTasksOutputPort = findAllTasksOutputPort;
    }

    @Override
    public List<Task> findAllTasks() {
        return findAllTasksOutputPort.findAllTasks();
    }

}
