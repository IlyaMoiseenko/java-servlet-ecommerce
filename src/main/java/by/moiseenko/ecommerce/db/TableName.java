package by.moiseenko.ecommerce.db;

import lombok.Getter;

@Getter
public enum TableName {

    USER ("tb_user"),
    ROLE ("tb_role"),
    ADDRESS ("tb_address"),
    COUNTRY ("tb_country"),
    USER_ROLE ("tb_user_role"),
    USER_ADDRESS ("tb_user_address");

    private final String name;

    TableName(String name) {
        this.name = name;
    }
}
