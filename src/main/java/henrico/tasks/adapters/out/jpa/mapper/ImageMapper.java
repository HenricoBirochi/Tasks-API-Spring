package henrico.tasks.adapters.out.jpa.mapper;

import henrico.tasks.adapters.out.jpa.entity.ImageEntity;
import henrico.tasks.application.core.domain.Image;

public class ImageMapper {
    public static ImageEntity toImageEntity(Image image) {
        return ImageEntity
                .builder()
                .id(image.getId())
                .imageName(image.getImageName())
                .imageExtension(image.getImageExtension())
                .build();
    }
    public static Image toImage(ImageEntity imageEntity) {
        return new Image(
                imageEntity.getId(),
                imageEntity.getImageName(),
                imageEntity.getImageExtension()
        );
    }
}
