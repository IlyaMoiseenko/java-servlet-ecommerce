package by.moiseenko.ecommerce.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, I> {

    I save(T domain);
    Optional<T> findById(I id);
    List<T> findAll();
    void removeById(I id);
    void update(T newDomain, I updatedDomainId);
}
