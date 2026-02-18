package henrico.tasks.adapters.out.jpa;

import java.util.List;
import java.util.UUID;

import henrico.tasks.adapters.out.jpa.entity.ImageEntity;
import henrico.tasks.adapters.out.jpa.mapper.ImageMapper;
import henrico.tasks.adapters.out.jpa.repository.JpaImageRepository;
import henrico.tasks.application.core.domain.Image;
import henrico.tasks.application.ports.out.repository.ImageRepositoryOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class JpaImageRepositoryAdapter implements ImageRepositoryOutputPort {
    private final JpaImageRepository jpaImageRepository;

    public JpaImageRepositoryAdapter(
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
