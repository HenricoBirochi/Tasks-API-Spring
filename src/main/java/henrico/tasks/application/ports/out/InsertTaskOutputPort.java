package henrico.tasks.application.ports.out;

import henrico.tasks.application.core.domain.Task;

public interface InsertTaskOutputPort {

    void insert(Task task);

}
