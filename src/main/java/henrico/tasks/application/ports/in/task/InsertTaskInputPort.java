package henrico.tasks.application.ports.in.task;

import henrico.tasks.application.core.domain.Task;

public interface InsertTaskInputPort {

    void insertTask(Task task);

}
