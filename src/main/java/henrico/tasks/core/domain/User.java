package henrico.tasks.core.domain;

import java.util.UUID;

import henrico.tasks.core.domain.enums.UserRole;

public class User {
    private UUID id;
    private String userName;
    private String name;
    private String email;
    private String password;
    private Integer coins;
    private UserRole userRole;
    private Image image;

    public User() {
    }

    public User(String userName, String name, String email, String password) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(UUID id, String userName, String name, String email, String password, Integer coins, UserRole userRole) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.coins = coins;
        this.userRole = userRole;
    }

    public User(UUID id, String userName, String name, String email, String password, Integer coins, UserRole userRole, Image image) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.coins = coins;
        this.userRole = userRole;
        this.image = image;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
