package by.moiseenko.ecommerce.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariationOption extends BaseDomain {

    private String name;

    private Variation variation;
}
