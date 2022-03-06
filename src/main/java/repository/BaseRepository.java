package repository;

import java.util.Optional;

public interface BaseRepository<T, ID> {
        Optional<T> findById(ID id);

        void save(T entity);

        void update(T entity);
        
        void delete(T entity);
    }

