package by.moiseenko.ecommerce.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Promotion extends BaseDomain {

    private String name;
    private String description;
    private int discountRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
