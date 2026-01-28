package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.TaskGroup;

import java.util.List;
import java.util.UUID;

public interface TaskGroupInputPort {

    TaskGroup insertTaskGroup(TaskGroup taskGroup);
    TaskGroup findTaskGroupById(UUID taskGroupId);
    List<TaskGroup> findAllTaskGroups(UUID userId);
    void deleteTaskGroup(UUID taskGroupId);

}
