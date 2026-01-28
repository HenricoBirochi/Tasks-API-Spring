package henrico.tasks.adapters.out.jpa.taskgroup;

import henrico.tasks.adapters.out.jpa.persistence.entity.TaskGroupDbContext;
import henrico.tasks.adapters.out.jpa.mapper.TaskGroupMapper;
import henrico.tasks.adapters.out.jpa.persistence.repository.JpaTaskGroupRepository;
import henrico.tasks.application.core.domain.TaskGroup;
import henrico.tasks.application.ports.out.taskgroup.InsertTaskGroupOutputPort;

public class InsertTaskGroupAdapter implements InsertTaskGroupOutputPort {

    private final JpaTaskGroupRepository jpaTaskGroupRepository;

    public InsertTaskGroupAdapter(JpaTaskGroupRepository jpaTaskGroupRepository) {
        this.jpaTaskGroupRepository = jpaTaskGroupRepository;
    }

    @Override
    public TaskGroup insertTaskGroup(TaskGroup taskGroup) {
        TaskGroupDbContext taskGroupDbContext = TaskGroupMapper.toTaskGroupDbContext(taskGroup);
        jpaTaskGroupRepository.save(taskGroupDbContext);
        return taskGroup;
    }

}
