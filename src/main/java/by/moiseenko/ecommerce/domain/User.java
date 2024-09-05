package by.moiseenko.ecommerce.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseDomain {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private List<Role> roles;
    private List<Address> addresses;
}
