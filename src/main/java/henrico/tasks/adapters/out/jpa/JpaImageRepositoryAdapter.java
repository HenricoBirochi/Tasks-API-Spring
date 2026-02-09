package henrico.tasks.adapters.out.jpa;

import java.util.List;
import java.util.UUID;

import henrico.tasks.application.core.domain.Image;
import henrico.tasks.application.ports.out.repository.ImageRepositoryOutputPort;

public class JpaImageRepositoryAdapter implements ImageRepositoryOutputPort {

    @Override
    public Image insert(Image image) {
        throw new UnsupportedOperationException("Not supported yet.");
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
