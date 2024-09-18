package by.moiseenko.ecommerce.service;

import by.moiseenko.ecommerce.domain.Country;
import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.dto.request.CountryRequest;
import by.moiseenko.ecommerce.domain.dto.response.CountryResponse;
import by.moiseenko.ecommerce.domain.mapper.CountryMapper;
import by.moiseenko.ecommerce.domain.validation.CountryValidator;
import by.moiseenko.ecommerce.domain.validation.Validator;
import by.moiseenko.ecommerce.exception.DomainNotFoundException;
import by.moiseenko.ecommerce.exception.ResourceMappingException;
import by.moiseenko.ecommerce.exception.ValidationException;
import by.moiseenko.ecommerce.repository.CountryRepository;
import by.moiseenko.ecommerce.repository.JdbcCountryRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountryService {

    // FIELD
    private static CountryService instance;
    private static final CountryRepository countryRepository = JdbcCountryRepository.getInstance();
    private static final Validator<CountryRequest> countryValidator = CountryValidator.getInstance();
    private static final CountryMapper countryMapper = CountryMapper.getInstance();

    // CONSTRUCTOR
    private CountryService() {}

    // METHOD
    public static CountryService getInstance() {
        if (instance == null)
            instance = new CountryService();

        return instance;
    }

    public Long save(CountryRequest request) {
        countryValidator.validate(request);
        Long savedCountryId = countryRepository.save(
                countryMapper.toDomain(request)
        );

        if (savedCountryId == 0)
            throw new ResourceMappingException("Error while saving role");

        return savedCountryId;
    }

    public CountryResponse getById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        Country country = countryRepository.findById(id).orElseThrow(
                () -> new DomainNotFoundException(Role.class, Map.of("Country id", id.toString()))
        );

        return countryMapper.toResponse(country);
    }

    public CountryResponse getByName(String name) {
        if (name == null)
            throw new ValidationException("Please, check name");

        Country country = countryRepository.findByName(name).orElseThrow(
                () -> new DomainNotFoundException(Role.class, Map.of("Country name", name))
        );

        return countryMapper.toResponse(country);
    }

    public List<CountryResponse> getAll() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public void removeById(Long id) {
        if (id == null)
            throw new ValidationException("Please, check id");

        countryRepository.removeById(id);
    }

    public void updateById(CountryRequest request, Long id) {
        countryValidator.validate(request);
        countryRepository.update(
                countryMapper.toDomain(request),
                id
        );
    }
}
