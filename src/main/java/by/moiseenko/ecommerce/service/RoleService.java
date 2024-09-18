package by.moiseenko.ecommerce.service;

import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.dto.request.RoleRequest;
import by.moiseenko.ecommerce.domain.dto.response.RoleResponse;
import by.moiseenko.ecommerce.domain.mapper.RoleMapper;
import by.moiseenko.ecommerce.domain.validation.RoleValidator;
import by.moiseenko.ecommerce.domain.validation.Validator;
import by.moiseenko.ecommerce.exception.DomainNotFoundException;
import by.moiseenko.ecommerce.exception.ResourceMappingException;
import by.moiseenko.ecommerce.exception.ValidationException;
import by.moiseenko.ecommerce.repository.JdbcRoleRepository;
import by.moiseenko.ecommerce.repository.RoleRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoleService {

    // FIELD
    private static RoleService instance;
    private static final Validator<RoleRequest> validator = RoleValidator.getInstance();
    private static final RoleMapper roleMapper = RoleMapper.getInstance();
    private static final RoleRepository roleRepository = JdbcRoleRepository.getInstance();

    // CONSTRUCTOR
    private RoleService() {}

    // METHOD
    public static RoleService getInstance() {
        if (instance == null)
            instance = new RoleService();

        return instance;
    }

    public RoleResponse getByName(String name) {
        Role role = roleRepository.findByName(name).orElseThrow(
                () -> new DomainNotFoundException(Role.class, Map.of("Role name", name))
        );

        return roleMapper.toResponse(role);
    }

    public Long save(RoleRequest request) {
        validator.validate(request);
        Long savedRoleId = roleRepository.save(
                roleMapper.toDomain(request)
        );

        if (savedRoleId == 0)
            throw new ResourceMappingException("Error while saving role");

        return savedRoleId;
    }

    public RoleResponse getById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        Role role = roleRepository.findById(id).orElseThrow(
                () -> new DomainNotFoundException(Role.class, Map.of("Role id", id.toString()))
        );

        return roleMapper.toResponse(role);
    }

    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void removeById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        roleRepository.removeById(id);
    }

    public void updateById(RoleRequest request, Long id) {
        validator.validate(request);
        roleRepository.update(
                roleMapper.toDomain(request),
                id
        );
    }
}
