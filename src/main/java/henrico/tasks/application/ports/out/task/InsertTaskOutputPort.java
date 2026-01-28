package henrico.tasks.application.ports.out.task;

import henrico.tasks.application.core.domain.Task;

public interface InsertTaskOutputPort {

    void insertTask(Task task);

}
