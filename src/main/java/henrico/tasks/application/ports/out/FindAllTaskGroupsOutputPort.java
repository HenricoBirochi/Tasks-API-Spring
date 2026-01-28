package henrico.tasks.application.ports.out;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.core.domain.User;

import java.util.List;

public interface FindAllTaskGroupsOutputPort {

    List<TaskGroup> findAllTaskGroups(Integer userId);

}
