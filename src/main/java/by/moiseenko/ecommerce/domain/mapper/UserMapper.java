package by.moiseenko.ecommerce.domain.mapper;

import by.moiseenko.ecommerce.domain.User;
import by.moiseenko.ecommerce.domain.dto.request.UserRequest;
import by.moiseenko.ecommerce.domain.dto.response.UserResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserMapper {

    private static UserMapper instance;
    private static final AddressMapper addressMapper = AddressMapper.getInstance();
    private static final RoleMapper roleMapper = RoleMapper.getInstance();

    private UserMapper() {}

    public static UserMapper getInstance() {
        if (instance == null)
            instance = new UserMapper();

        return instance;
    }

    public User toDomain(UserRequest from) {
        return User
                .builder()
                .email(from.getEmail())
                .password(from.getPassword())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .build();
    }

    public UserResponse toResponse(User from) {
        return UserResponse
                .builder()
                .email(from.getEmail())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .addresses(mapToResponse(from.getAddresses(), addressMapper::toResponse))
                .roles(mapToResponse(from.getRoles(), roleMapper::toResponse))
                .build();
    }

    private <T, R> List<R> mapToResponse(List<T> domains, Function<T, R> mapper) {
        return domains.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
