package by.moiseenko.ecommerce.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class Role {

    private Long id;
    private String name;
}
