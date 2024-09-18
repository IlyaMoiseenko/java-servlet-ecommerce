package by.moiseenko.ecommerce.domain.mapper;

import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.dto.request.RoleRequest;
import by.moiseenko.ecommerce.domain.dto.response.RoleResponse;

public class RoleMapper {

    private static RoleMapper instance;

    private RoleMapper() {}

    public static RoleMapper getInstance() {
        if (instance == null)
            instance = new RoleMapper();

        return instance;
    }

    public Role toDomain(RoleRequest from) {
        return Role
                .builder()
                .name(from.getName())
                .build();
    }

    public RoleResponse toResponse(Role from) {
        return RoleResponse
                .builder()
                .name(from.getName())
                .build();
    }
}
