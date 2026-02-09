package henrico.tasks.application.core.domain;

import henrico.tasks.application.core.domain.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private UUID id;
    private Integer coins;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private TaskStatus taskStatus;
    private UUID taskTagId;
    private UUID userId;

    public Task() {

    }

    public Task(String title, String description, Integer coins, LocalDateTime deadline, TaskStatus taskStatus, UUID taskTagId, UUID userId) {
        this.title = title;
        this.description = description;
        this.coins = coins;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
        this.taskTagId = taskTagId;
        this.userId = userId;
    }

    public Task(UUID id, String title, String description, Integer coins, LocalDateTime deadline, TaskStatus taskStatus, UUID taskTagId, UUID userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coins = coins;
        this.deadline = deadline;
        this.taskStatus = taskStatus;
        this.taskTagId = taskTagId;
        this.userId = userId;
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

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
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

    public UUID getTaskTagId() {
        return taskTagId;
    }

    public void setTaskTagId(UUID taskTagId) {
        this.taskTagId = taskTagId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
