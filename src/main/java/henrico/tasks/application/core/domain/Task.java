package henrico.tasks.application.core.domain;

import henrico.tasks.application.core.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private TaskStatus taskStatus;

    public Task(UUID id, String title, String description, LocalDateTime deadline, TaskStatus taskStatus) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
