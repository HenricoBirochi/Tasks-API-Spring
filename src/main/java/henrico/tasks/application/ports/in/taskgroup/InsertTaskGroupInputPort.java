package henrico.tasks.application.ports.in.taskgroup;

import henrico.tasks.application.core.domain.TaskGroup;

public interface InsertTaskGroupInputPort {

    void insertTaskGroup(TaskGroup taskGroup);

}
