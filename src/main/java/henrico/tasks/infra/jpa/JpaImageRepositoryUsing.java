package henrico.tasks.infra.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import henrico.tasks.adapters.repository.ImageRepositoryGateway;
import henrico.tasks.core.domain.Image;
import henrico.tasks.infra.jpa.entity.ImageEntity;
import henrico.tasks.infra.jpa.mapper.ImageMapper;
import henrico.tasks.infra.jpa.repository.JpaImageRepository;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Image findById(UUID imageId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Image> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(UUID imageId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
