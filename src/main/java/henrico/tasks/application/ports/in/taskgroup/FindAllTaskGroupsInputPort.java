package henrico.tasks.application.ports.in.taskgroup;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.TaskGroup;

public interface FindAllTaskGroupsInputPort {

    List<TaskGroup> findAllTaskGroups(UUID userId);

}
