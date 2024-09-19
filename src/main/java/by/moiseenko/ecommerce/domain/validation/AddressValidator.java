package by.moiseenko.ecommerce.domain.validation;

import by.moiseenko.ecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.ecommerce.exception.ValidationException;

public class AddressValidator implements Validator<AddressRequest> {

    private static AddressValidator instance;
    private static final String CITY_EMPTY_MESSAGE = "City can not be empty";
    private static final String POSTAL_CODE_POSITIVE_MESSAGE = "Postal code must be positive";
    private static final String STREET_NAME_EMPTY_MESSAGE = "Street name can not be empty";
    private static final String APARTMENT_NUMBER_MESSAGE = "Apartment number must be positive";

    private AddressValidator() {}

    public static AddressValidator getInstance() {
        if (instance == null)
            instance = new AddressValidator();

        return instance;
    }

    @Override
    public void validate(AddressRequest request) {
        if (request.getCity() == null || request.getCity().isEmpty())
            throw new ValidationException(CITY_EMPTY_MESSAGE);

        if (request.getPostalCode() < 0)
            throw new ValidationException(POSTAL_CODE_POSITIVE_MESSAGE);

        if (request.getStreetName() == null || request.getStreetName().isEmpty())
            throw new ValidationException(STREET_NAME_EMPTY_MESSAGE);

        if (request.getApartmentNumber() < 0)
            throw new ValidationException(APARTMENT_NUMBER_MESSAGE);
    }
}
