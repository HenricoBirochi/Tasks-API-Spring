package henrico.tasks.adapters.out.jpa.task;

import henrico.tasks.adapters.out.jpa.persistence.entity.TaskDbContext;
import henrico.tasks.adapters.out.jpa.mapper.TaskMapper;
import henrico.tasks.adapters.out.jpa.persistence.repository.JpaTaskRepository;
import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.out.task.InsertTaskOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertTaskAdapter implements InsertTaskOutputPort {

    public JpaTaskRepository jpaTaskRepository;

    public InsertTaskAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public void insertTask(Task task) {
        TaskDbContext taskDbContext = TaskMapper.toTaskDbContext(task);
        jpaTaskRepository.save(taskDbContext);
    }
}
