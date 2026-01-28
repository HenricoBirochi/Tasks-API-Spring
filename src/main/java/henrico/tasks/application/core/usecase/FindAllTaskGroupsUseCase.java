package henrico.tasks.application.core.usecase;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.FindAllTaskGroupsInputPort;
import henrico.tasks.application.ports.out.FindAllTaskGroupsOutputPort;

public class FindAllTaskGroupsUseCase implements FindAllTaskGroupsInputPort {

    private final FindAllTaskGroupsOutputPort findAllTaskGroupsOutputPort;

    public FindAllTaskGroupsUseCase(FindAllTaskGroupsOutputPort findAllTaskGroupsOutputPort) {
        this.findAllTaskGroupsOutputPort = findAllTaskGroupsOutputPort;
    }

    @Override
    public List<TaskGroup> findAllTaskGroups(UUID userId) {
        return findAllTaskGroupsOutputPort.findAllTaskGroups(userId);
    }

}
