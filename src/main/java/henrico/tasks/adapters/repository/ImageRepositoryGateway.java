package henrico.tasks.adapters.repository;

import java.util.List;
import java.util.UUID;

import henrico.tasks.core.domain.Image;

public interface ImageRepositoryGateway {

    Image insert(Image image);
    Image update(Image image);
    Image findById(UUID imageId);
    List<Image> findAll();
    void delete(UUID imageId);

}
