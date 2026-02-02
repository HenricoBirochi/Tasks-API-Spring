package henrico.tasks.application.core.domain;

import java.util.List;
import java.util.UUID;

public class TaskGroup {
    private UUID id;
    private String name;
    private List<Task> tasks;
    private UUID userId;

    public TaskGroup(UUID id, String name, List<Task> tasks, UUID userId) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
        this.userId = userId;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
