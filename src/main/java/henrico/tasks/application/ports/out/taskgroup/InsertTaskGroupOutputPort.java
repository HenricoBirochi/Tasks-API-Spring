package henrico.tasks.application.ports.out.taskgroup;

import henrico.tasks.application.core.domain.TaskGroup;

public interface InsertTaskGroupOutputPort {

    void insertTaskGroup(TaskGroup taskGroup);

}
