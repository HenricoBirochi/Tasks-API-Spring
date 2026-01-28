package henrico.tasks.application.ports.out.taskgroup;

import henrico.tasks.application.core.domain.TaskGroup;

public interface InsertTaskGroupOutputPort {

    TaskGroup insertTaskGroup(TaskGroup taskGroup);

}
