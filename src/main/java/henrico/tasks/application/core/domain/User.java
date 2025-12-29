package henrico.tasks.application.core.domain;

import henrico.tasks.application.core.domain.enums.UserRole;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private Integer coins;
    private Image image;
    private UserRole userRole;
    private List<TaskGroup> taskGroups;

    public User(List<TaskGroup> taskGroups, UserRole userRole, Image image, Integer coins, String name, UUID id) {
        this.taskGroups = taskGroups;
        this.userRole = userRole;
        this.image = image;
        this.coins = coins;
        this.name = name;
        this.id = id;
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

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<TaskGroup> getTaskGroups() {
        return taskGroups;
    }

    public void setTaskGroups(List<TaskGroup> taskGroups) {
        this.taskGroups = taskGroups;
    }
}
