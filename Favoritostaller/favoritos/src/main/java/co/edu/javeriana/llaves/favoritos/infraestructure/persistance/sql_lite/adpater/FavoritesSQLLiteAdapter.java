package co.edu.javeriana.llaves.favoritos.infraestructure.persistance.sql_lite.adpater;

import co.edu.javeriana.llaves.favoritos.core.domain.entities.FavoritesEntity;
import co.edu.javeriana.llaves.favoritos.core.use_cases.infraestructure.PersistanceAdapter;
import co.edu.javeriana.llaves.favoritos.infraestructure.persistance.sql_lite.mapper.FavoriteMapper;
import co.edu.javeriana.llaves.favoritos.infraestructure.persistance.sql_lite.repositories.FavoritesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritesSQLLiteAdapter implements PersistanceAdapter<FavoritesEntity> {

    private final FavoritesRepository repository;
    private final FavoriteMapper mapper;

    public FavoritesSQLLiteAdapter(FavoritesRepository repository, FavoriteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(FavoritesEntity entity) {
        repository.save(mapper.toDatabaseEntity(entity));
    }

    @Override
    public void update(FavoritesEntity entity) {
        repository.save(mapper.toDatabaseEntity(entity));
    }

    @Override
    public List<FavoritesEntity> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FavoritesEntity> findByKeyTextAndUser(String keyText, String user) {
        return repository.findByKeyTextAndUser(keyText, user)
                .map(mapper::toDomainEntity);
    }

    @Override
    public boolean delete(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Optional<FavoritesEntity> findById(String id) {
        return repository.findById(id).map(mapper::toDomainEntity);
    }

    @Override
    public void delete(FavoritesEntity entity) {
        repository.delete(mapper.toDatabaseEntity(entity));
    }
}
