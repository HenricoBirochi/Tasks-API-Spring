package henrico.tasks.adapters.out;

import henrico.tasks.adapters.out.entity.TaskDbContext;
import henrico.tasks.adapters.out.entity.mapper.TaskMapper;
import henrico.tasks.adapters.out.entity.repository.JpaTaskRepository;
import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.out.InsertTaskOutputPort;
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
