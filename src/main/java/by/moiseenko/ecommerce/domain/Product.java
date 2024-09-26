package by.moiseenko.ecommerce.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseDomain {

    private String name;
    private String description;
    private String photo;
    private BigDecimal price;
    private int qtyInStock;

    private ProductCategory category;
    private List<VariationOption> variationOptions;
}
