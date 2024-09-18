package by.moiseenko.ecommerce.domain.validation;

import by.moiseenko.ecommerce.domain.dto.request.CountryRequest;
import by.moiseenko.ecommerce.exception.ValidationException;

public class CountryValidator implements Validator<CountryRequest> {

    private static CountryValidator instance;
    private static final String NAME_EMPTY_MESSAGE = "Name of country can not be empty";

    private CountryValidator() {}

    public static CountryValidator getInstance() {
        if (instance == null)
            instance = new CountryValidator();

        return instance;
    }

    @Override
    public void validate(CountryRequest request) {
        if (request.getName() == null || request.getName().isEmpty())
            throw new ValidationException(NAME_EMPTY_MESSAGE);
    }
}
