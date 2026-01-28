package henrico.tasks.application.ports.in;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.core.domain.User;

import java.util.List;

public interface FindAllTaskGroupsInputPort {

    List<TaskGroup> findAllTaskGroups(Integer userId);

}
