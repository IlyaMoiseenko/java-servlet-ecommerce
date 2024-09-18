package by.moiseenko.ecommerce.domain.validation;

import by.moiseenko.ecommerce.domain.dto.request.RoleRequest;
import by.moiseenko.ecommerce.exception.ValidationException;

public class RoleValidator implements Validator<RoleRequest> {

    private static RoleValidator instance;
    private static final String NAME_EMPTY_MESSAGE = "Name of role can not be empty";

    private RoleValidator() {}

    public static RoleValidator getInstance() {
        if (instance == null)
            instance = new RoleValidator();

        return instance;
    }

    @Override
    public void validate(RoleRequest request) {
        if (request.getName() == null || request.getName().isEmpty())
            throw new ValidationException(NAME_EMPTY_MESSAGE);
    }
}
