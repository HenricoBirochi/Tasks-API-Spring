package henrico.tasks.application.core.usecase;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.core.domain.User;
import henrico.tasks.application.ports.in.FindAllTaskGroupsInputPort;
import henrico.tasks.application.ports.out.FindAllTaskGroupsOutputPort;

import java.util.List;

public class FindAllTaskGroupsUseCase implements FindAllTaskGroupsInputPort {

    private final FindAllTaskGroupsOutputPort findAllTaskGroupsOutputPort;

    public FindAllTaskGroupsUseCase(FindAllTaskGroupsOutputPort findAllTaskGroupsOutputPort) {
        this.findAllTaskGroupsOutputPort = findAllTaskGroupsOutputPort;
    }

    @Override
    public List<TaskGroup> findAllTaskGroups(Integer userId) {
        return findAllTaskGroupsOutputPort.findAllTaskGroups(userId);
    }

}
