package henrico.tasks.adapters.out;

import henrico.tasks.adapters.out.entity.mapper.TaskMapper;
import henrico.tasks.adapters.out.entity.repository.JpaTaskRepository;
import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.out.FindAllTasksOutputPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllTasksAdapter implements FindAllTasksOutputPort {

    private final JpaTaskRepository jpaTaskRepository;

    public FindAllTasksAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public List<Task> findAllTasks() {
        return jpaTaskRepository
                .findAll()
                .stream()
                .map(taskEntity -> TaskMapper.toDomain(taskEntity))
                .toList();
    }
}
