package henrico.tasks.application.core.domain;

import java.util.List;
import java.util.UUID;

public class TaskGroupCategory {
    private UUID id;
    private String name;
    private List<TaskGroup> taskGroups;

    public TaskGroupCategory(UUID id, String name, List<TaskGroup> taskGroups) {
        this.id = id;
        this.name = name;
        this.taskGroups = taskGroups;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TaskGroup> getTaskGroups() {
        return taskGroups;
    }

    public void setTaskGroups(List<TaskGroup> taskGroups) {
        this.taskGroups = taskGroups;
    }
}
