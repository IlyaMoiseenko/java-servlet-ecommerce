package by.moiseenko.ecommerce.domain.mapper;

import by.moiseenko.ecommerce.domain.Country;
import by.moiseenko.ecommerce.domain.dto.request.CountryRequest;
import by.moiseenko.ecommerce.domain.dto.response.CountryResponse;

public class CountryMapper {

    private static CountryMapper instance;

    private CountryMapper() {}

    public static CountryMapper getInstance() {
        if (instance == null)
            instance = new CountryMapper();

        return instance;
    }

    public Country toDomain(CountryRequest from) {
        return Country
                .builder()
                .name(from.getName())
                .build();
    }

    public CountryResponse toResponse(Country from) {
        return CountryResponse
                .builder()
                .name(from.getName())
                .build();
    }
}
