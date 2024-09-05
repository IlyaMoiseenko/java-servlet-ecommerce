package by.moiseenko.ecommerce.repository;

import by.moiseenko.ecommerce.domain.Role;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
