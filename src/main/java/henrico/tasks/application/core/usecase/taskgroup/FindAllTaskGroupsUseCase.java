package henrico.tasks.application.core.usecase.taskgroup;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.taskgroup.FindAllTaskGroupsInputPort;
import henrico.tasks.application.ports.out.taskgroup.FindAllTaskGroupsOutputPort;

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
