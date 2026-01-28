package henrico.tasks.adapters.out;

import java.util.List;
import java.util.UUID;

import henrico.tasks.adapters.out.entity.mapper.TaskMapper;
import henrico.tasks.adapters.out.entity.repository.JpaTaskRepository;
import henrico.tasks.application.core.domain.Task;
import henrico.tasks.application.ports.out.FindAllTasksFromTaskGroupOutputPort;

public class FindAllTasksFromTaskGroupAdapter implements FindAllTasksFromTaskGroupOutputPort {

    private final JpaTaskRepository jpaTaskRepository;

    public FindAllTasksFromTaskGroupAdapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public List<Task> findAllTasks(UUID taskGroupId) {
        var allTasks = jpaTaskRepository.findByTaskGroupId(taskGroupId);
        return allTasks
                .stream()
                .map(taskDbContext -> TaskMapper.toTaskDeep(taskDbContext))
                .toList();
    }

}
