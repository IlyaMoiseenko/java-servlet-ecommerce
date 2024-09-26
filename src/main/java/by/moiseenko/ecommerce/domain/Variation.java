package by.moiseenko.ecommerce.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Variation extends BaseDomain {

    private String name;

    private ProductCategory category;
    private List<VariationOption> variationOptions;
}
