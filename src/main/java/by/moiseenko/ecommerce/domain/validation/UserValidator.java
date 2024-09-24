package by.moiseenko.ecommerce.domain.validation;

import by.moiseenko.ecommerce.domain.dto.request.UserRequest;

public class UserValidator implements Validator<UserRequest> {

    private static UserValidator instance;

    private UserValidator() {}

    public static UserValidator getInstance() {
        if (instance == null)
            instance = new UserValidator();

        return instance;
    }

    @Override
    public void validate(UserRequest request) {

    }
}
