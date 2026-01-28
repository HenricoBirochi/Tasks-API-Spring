package henrico.tasks.adapters.out;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import henrico.tasks.adapters.out.entity.mapper.TaskGroupMapper;
import henrico.tasks.adapters.out.entity.repository.JpaTaskGroupRepository;
import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.out.taskgroup.FindAllTaskGroupsOutputPort;

@Component
public class FindAllTaskGroupsAdapter implements FindAllTaskGroupsOutputPort {

    private final JpaTaskGroupRepository jpaTaskGroupRepository;

    public FindAllTaskGroupsAdapter(JpaTaskGroupRepository jpaTaskGroupRepository) {
        this.jpaTaskGroupRepository = jpaTaskGroupRepository;
    }

    @Override
    public List<TaskGroup> findAllTaskGroups(UUID userId) {
        return jpaTaskGroupRepository
                .findAll()
                .stream()
                .filter(taskGroupDbContext -> taskGroupDbContext.getUser().getId().equals(userId))
                .map(taskGroupDbContext -> TaskGroupMapper.toTaskGroup(taskGroupDbContext))
                .toList();
    }
}
