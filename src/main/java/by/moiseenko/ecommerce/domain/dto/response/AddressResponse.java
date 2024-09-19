package by.moiseenko.ecommerce.domain.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {

    private String city;
    private String streetName;
    private int apartmentNumber;
}
