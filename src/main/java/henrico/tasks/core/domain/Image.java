package henrico.tasks.core.domain;

import java.util.UUID;

public class Image {
    private UUID id;
    private String imageName;
    private String imageExtension;

    public Image() {
    }

    public Image(String imageName, String imageExtension) {
        this.imageName = imageName;
        this.imageExtension = imageExtension;
    }

    public Image(UUID id, String imageName, String imageExtension) {
        this.id = id;
        this.imageName = imageName;
        this.imageExtension = imageExtension;
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

    public String getImageExtension() {
        return imageExtension;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }
}
