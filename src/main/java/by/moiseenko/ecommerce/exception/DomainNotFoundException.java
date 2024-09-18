package by.moiseenko.ecommerce.exception;

import java.util.Map;

public class DomainNotFoundException extends RuntimeException {

    public DomainNotFoundException(Class clazz, Map<String, String> searchParams) {
        super(DomainNotFoundException.generateMessage(clazz.getSimpleName(), searchParams));
    }

    private static String generateMessage(String domain, Map<String, String> params) {
        return domain +
                " was not found for parameters " +
                params;
    }
}
