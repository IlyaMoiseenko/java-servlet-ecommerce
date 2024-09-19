package by.moiseenko.ecommerce.domain.mapper;

import by.moiseenko.ecommerce.domain.Address;
import by.moiseenko.ecommerce.domain.dto.request.AddressRequest;
import by.moiseenko.ecommerce.domain.dto.response.AddressResponse;

public class AddressMapper {

    private static AddressMapper instance;

    private AddressMapper() {}

    public static AddressMapper getInstance() {
        if (instance == null)
            instance = new AddressMapper();

        return instance;
    }

    public Address toDomain(AddressRequest from) {
        return Address
                .builder()
                .city(from.getCity())
                .postalCode(from.getPostalCode())
                .streetName(from.getStreetName())
                .apartmentNumber(from.getApartmentNumber())
                .build();
    }

    public AddressResponse toResponse(Address from) {
        return AddressResponse
                .builder()
                .city(from.getCity())
                .streetName(from.getStreetName())
                .apartmentNumber(from.getApartmentNumber())
                .build();
    }
}
