package by.moiseenko.ecommerce.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseDomain {

    private String city;
    private int postalCode;
    private String streetName;
    private int apartmentNumber;

    private Country country;
}
