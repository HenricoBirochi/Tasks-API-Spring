package henrico.tasks.application.ports.out;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.TaskGroup;

public interface FindAllTaskGroupsOutputPort {

    List<TaskGroup> findAllTaskGroups(UUID userId);

}
