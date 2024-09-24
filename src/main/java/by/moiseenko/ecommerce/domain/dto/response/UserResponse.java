package by.moiseenko.ecommerce.domain.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private String email;
    private String firstName;
    private String lastName;
    private List<AddressResponse> addresses;
    private List<RoleResponse> roles;
}
