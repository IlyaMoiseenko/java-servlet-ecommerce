package by.moiseenko.ecommerce.repository;

import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByFirstName(String name);
    Long addRole(User to, Role role);
}
