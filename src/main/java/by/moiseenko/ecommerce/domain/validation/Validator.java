package by.moiseenko.ecommerce.domain.validation;

public interface Validator<T> {
    void validate(T request);
}
