package henrico.tasks.application.core.domain;

import java.util.List;
import java.util.UUID;

public class TaskGroup {
    private UUID id;
    private String name;
    private TaskGroupCategory taskGroupCategory;
    private List<Task> tasks;
    private User user;

    public TaskGroup(UUID id, String name, TaskGroupCategory taskGroupCategory, List<Task> tasks, User user) {
        this.id = id;
        this.name = name;
        this.taskGroupCategory = taskGroupCategory;
        this.tasks = tasks;
        this.user = user;
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

    public TaskGroupCategory getTaskGroupCategory() {
        return taskGroupCategory;
    }

    public void setTaskGroupCategory(TaskGroupCategory taskGroupCategory) {
        this.taskGroupCategory = taskGroupCategory;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
