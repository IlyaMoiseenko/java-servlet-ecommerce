package by.moiseenko.ecommerce.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory extends BaseDomain {

    private String name;

    private List<Promotion> promotions;
}
