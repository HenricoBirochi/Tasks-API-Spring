package henrico.tasks.application.ports.out.repository;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.Image;

public interface ImageRepositoryOutputPort {

    Image insert(Image image);
    Image update(Image image);
    Image findById(UUID imageId);
    List<Image> findAll();
    void delete(UUID imageId);

}
