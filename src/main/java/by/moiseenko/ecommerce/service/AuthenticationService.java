package by.moiseenko.ecommerce.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import by.moiseenko.ecommerce.db.RoleName;
import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.User;
import by.moiseenko.ecommerce.domain.dto.request.UserRequest;
import by.moiseenko.ecommerce.domain.mapper.UserMapper;
import by.moiseenko.ecommerce.domain.validation.UserValidator;
import by.moiseenko.ecommerce.domain.validation.Validator;
import by.moiseenko.ecommerce.exception.DomainNotFoundException;
import by.moiseenko.ecommerce.exception.ResourceMappingException;
import by.moiseenko.ecommerce.repository.JdbcRoleRepository;
import by.moiseenko.ecommerce.repository.JdbcUserRepository;
import by.moiseenko.ecommerce.repository.RoleRepository;
import by.moiseenko.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Map;

public class AuthenticationService {

    // FIELD
    private static AuthenticationService instance;
    private final Validator<UserRequest> userRequestValidator = UserValidator.getInstance();
    private final UserRepository userRepository = JdbcUserRepository.getInstance();
    private final RoleRepository roleRepository = JdbcRoleRepository.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();

    // CONSTRUCTOR
    private AuthenticationService() {}

    // METHOD
    public static AuthenticationService getInstance() {
        if (instance == null)
            instance = new AuthenticationService();

        return instance;
    }

    public boolean authorization(UserRequest request) {
        userRequestValidator.validate(request);

        User user = userMapper.toDomain(request);
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));

        Long savedUserId = userRepository.save(user);
        user.setId(savedUserId);

        if (savedUserId == 0L)
            throw new ResourceMappingException("Error while authorization user");

        addRoleToUser(user, RoleName.USER.getName());

        return true;
    }

    private void addRoleToUser(User user, String roleName) {
        Role role = roleRepository.findByName(roleName).orElseThrow(
                () -> new DomainNotFoundException(Role.class, Map.of("Role name", roleName))
        );

        userRepository.addRole(user, role);
    }
}
