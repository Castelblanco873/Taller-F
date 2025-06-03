package co.edu.javeriana.llaves.favoritos.core.use_cases;

import co.edu.javeriana.llaves.favoritos.core.use_cases.infraestructure.PersistanceAdapter;
import org.springframework.stereotype.Service;

@Service
public class DeleteFavoriteKeyUseCase {

    private final PersistanceAdapter<?> persistanceAdapter;

    public DeleteFavoriteKeyUseCase(PersistanceAdapter<?> persistanceAdapter) {
        this.persistanceAdapter = persistanceAdapter;
    }

    public boolean delete(String keyId) {
        return persistanceAdapter.delete(keyId);
    }
}