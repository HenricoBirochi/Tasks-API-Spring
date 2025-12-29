package henrico.tasks.application.core.domain;

import java.util.UUID;

public class Image {
    private UUID id;
    private String imageName;
    private String imagePath;

    public Image(UUID id, String imageName, String imagePath) {
        this.id = id;
        this.imageName = imageName;
        this.imagePath = imagePath;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
