package by.moiseenko.ecommerce.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Address extends BaseDomain {

    private String city;
    private int postalCode;
    private String streetName;
    private int apartmentNumber;

    private Country country;
}
