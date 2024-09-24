package by.moiseenko.ecommerce.domain.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
