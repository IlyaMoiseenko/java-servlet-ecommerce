package by.moiseenko.ecommerce.service;

import by.moiseenko.ecommerce.domain.Address;
import by.moiseenko.ecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.ecommerce.domain.dto.response.AddressResponse;
import by.moiseenko.ecommerce.domain.mapper.AddressMapper;
import by.moiseenko.ecommerce.domain.validation.AddressValidator;
import by.moiseenko.ecommerce.domain.validation.Validator;
import by.moiseenko.ecommerce.exception.DomainNotFoundException;
import by.moiseenko.ecommerce.exception.ResourceMappingException;
import by.moiseenko.ecommerce.exception.ValidationException;
import by.moiseenko.ecommerce.repository.AddressRepository;
import by.moiseenko.ecommerce.repository.JdbcAddressRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressService {

    // FIELD
    private static AddressService instance;
    private static final AddressMapper addressMapper = AddressMapper.getInstance();
    private static final AddressRepository addressRepository = JdbcAddressRepository.getInstance();
    private static final Validator<AddressRequest> addressValidator = AddressValidator.getInstance();

    // CONSTRUCTOR
    private AddressService() {}

    // METHOD
    public static AddressService getInstance() {
        if (instance == null)
            instance = new AddressService();

        return instance;
    }

    public Long save(AddressRequest request) {
        addressValidator.validate(request);
        Long savedAddressId = addressRepository.save(
                addressMapper.toDomain(request)
        );

        if (savedAddressId == 0)
            throw new ResourceMappingException("Error while saving address");

        return savedAddressId;
    }

    public AddressResponse getById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        Address address = addressRepository.findById(id).orElseThrow(
                () -> new DomainNotFoundException(Address.class, Map.of("Address id", id.toString()))
        );

        return addressMapper.toResponse(address);
    }

    public List<AddressResponse> getAll() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void removeById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        addressRepository.removeById(id);
    }

    public void updateById(AddressRequest request, Long id) {
        addressValidator.validate(request);
        addressRepository.update(
                addressMapper.toDomain(request),
                id
        );
    }
}
