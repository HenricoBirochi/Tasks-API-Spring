package henrico.tasks.infra.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import henrico.tasks.adapters.repository.ImageRepositoryGateway;
import henrico.tasks.core.domain.Image;
import henrico.tasks.infra.jpa.entity.ImageEntity;
import henrico.tasks.infra.jpa.mapper.ImageMapper;
import henrico.tasks.infra.jpa.repository.JpaImageRepository;
import jakarta.persistence.EntityNotFoundException;

@Repository
public class JpaImageRepositoryUsing implements ImageRepositoryGateway {
    private final JpaImageRepository jpaImageRepository;

    public JpaImageRepositoryUsing(
            JpaImageRepository jpaImageRepository
    ) {
        this.jpaImageRepository = jpaImageRepository;
    }

    @Override
    public Image insert(Image image) {
        ImageEntity imageEntity = ImageMapper.toImageEntity(image);
        ImageEntity newImageEntity = jpaImageRepository.save(imageEntity);
        return ImageMapper.toImage(newImageEntity);
    }

    @Override
    public Image update(Image image) {
        jpaImageRepository.findById(image.getId())
                                            .orElseThrow(() -> new EntityNotFoundException("Image not found!"));
        var newImageEntity = ImageEntity.builder()
                                        .id(image.getId())
                                        .imageName(image.getImageName())
                                        .imageExtension(image.getImageExtension())
                                        .build();
        var newImageEntityDb = jpaImageRepository.save(newImageEntity);
        return ImageMapper.toImage(newImageEntityDb);
    }

    @Override
    public Image findById(UUID imageId) {
        ImageEntity iamgeInDb = jpaImageRepository.findById(imageId).orElse(null);
        return ImageMapper.toImage(iamgeInDb);
    }

    @Override
    public List<Image> findAll() {
        List<ImageEntity> allImagesInDb = jpaImageRepository.findAll();
        List<Image> allImages = new ArrayList<>();
        for(ImageEntity image : allImagesInDb) {
            allImages.add(ImageMapper.toImage(image));
        }
        return allImages;
    }

    @Override
    public void delete(UUID imageId) {
        if(jpaImageRepository.findById(imageId).orElse(null) == null) {
            throw new EntityNotFoundException("Image not Found!");
        }
        jpaImageRepository.deleteById(imageId);
    }

}
