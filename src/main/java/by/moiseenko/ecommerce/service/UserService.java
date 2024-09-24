package by.moiseenko.ecommerce.service;

import by.moiseenko.ecommerce.domain.User;
import by.moiseenko.ecommerce.domain.dto.request.UserRequest;
import by.moiseenko.ecommerce.domain.dto.response.UserResponse;
import by.moiseenko.ecommerce.domain.mapper.UserMapper;
import by.moiseenko.ecommerce.domain.validation.UserValidator;
import by.moiseenko.ecommerce.domain.validation.Validator;
import by.moiseenko.ecommerce.exception.DomainNotFoundException;
import by.moiseenko.ecommerce.exception.ValidationException;
import by.moiseenko.ecommerce.repository.JdbcRoleRepository;
import by.moiseenko.ecommerce.repository.JdbcUserRepository;
import by.moiseenko.ecommerce.repository.RoleRepository;
import by.moiseenko.ecommerce.repository.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {

    // FIELD
    private static UserService instance;
    private static final UserMapper userMapper = UserMapper.getInstance();
    private static final UserRepository userRepository = JdbcUserRepository.getInstance();
    private static final RoleRepository rolerepository = JdbcRoleRepository.getInstance();
    private static final Validator<UserRequest> userValidator = UserValidator.getInstance();

    // CONSTRUCTOR
    private UserService() {}

    // METHOD
    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();

        return instance;
    }

    public UserResponse getByEmail(String email) {
        if (email == null)
            throw new ValidationException("Please, check email");

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new DomainNotFoundException(User.class, Map.of("User email", email))
        );

        return userMapper.toResponse(user);
    }

    public UserResponse getByFirstname(String firstname) {
        if (firstname == null)
            throw new ValidationException("Please, check firstname");

        User user = userRepository.findByFirstName(firstname).orElseThrow(
                () -> new DomainNotFoundException(User.class, Map.of("User firstname", firstname))
        );

        return userMapper.toResponse(user);
    }

    public UserResponse getById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        User user = userRepository.findById(id).orElseThrow(
                () -> new DomainNotFoundException(User.class, Map.of("User id", id.toString()))
        );

        return userMapper.toResponse(user);
    }

    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void removeById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        userRepository.removeById(id);
    }

    public void updateById(UserRequest request, Long id) {
        userValidator.validate(request);

        userRepository.update(
                userMapper.toDomain(request),
                id
        );
    }
}
