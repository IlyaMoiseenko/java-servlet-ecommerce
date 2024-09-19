package by.moiseenko.ecommerce.domain.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {

    private String city;
    private int postalCode;
    private String streetName;
    private int apartmentNumber;
}
