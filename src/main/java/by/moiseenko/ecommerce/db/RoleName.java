package by.moiseenko.ecommerce.db;

import lombok.Getter;

@Getter
public enum RoleName {

    ADMIN ("ADMIN"),
    USER ("USER");

    private final String name;

    RoleName(String name) {
        this.name = name;
    }
}
