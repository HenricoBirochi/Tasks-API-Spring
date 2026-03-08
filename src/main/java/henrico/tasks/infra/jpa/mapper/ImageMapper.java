package henrico.tasks.infra.jpa.mapper;

import henrico.tasks.infra.jpa.entity.ImageEntity;
import henrico.tasks.core.domain.Image;

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
