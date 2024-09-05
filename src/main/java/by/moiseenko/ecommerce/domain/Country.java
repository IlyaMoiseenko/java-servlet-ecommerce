package by.moiseenko.ecommerce.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country extends BaseDomain {

    private String name;
}
