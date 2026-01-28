package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.persistence.entity.ImageDbContext;
import henrico.tasks.application.core.domain.Image;

public class ImageMapper {
    public static ImageDbContext toImageDbContext(Image image) {
        return ImageDbContext
                .builder()
                .id(image.getId())
                .imageName(image.getImageName())
                .imagePath(image.getImagePath())
                .build();
    }
    public static Image toImage(ImageDbContext imageDbContext) {
        return new Image(
                imageDbContext.getId(),
                imageDbContext.getImageName(),
                imageDbContext.getImagePath()
        );
    }
}
