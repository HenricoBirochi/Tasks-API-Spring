package henrico.tasks.application.core.usecase.taskgroup;

import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.in.taskgroup.InsertTaskGroupInputPort;
import henrico.tasks.application.ports.out.taskgroup.InsertTaskGroupOutputPort;

public class InsertTaskGroupUseCase implements InsertTaskGroupInputPort {

    private final InsertTaskGroupOutputPort insertTaskGroupOutputPort;

    public InsertTaskGroupUseCase(InsertTaskGroupOutputPort insertTaskGroupOutputPort) {
        this.insertTaskGroupOutputPort = insertTaskGroupOutputPort;
    }

    @Override
    public void insertTaskGroup(TaskGroup taskGroup) {
        insertTaskGroupOutputPort.insertTaskGroup(taskGroup);
    }
}
