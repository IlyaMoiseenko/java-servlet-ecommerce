package by.moiseenko.ecommerce.db;

import lombok.Getter;

@Getter
public enum TableName {

    USER ("tb_user"),
    ROLE ("tb_role"),
    ADDRESS ("tb_address"),
    COUNTRY ("tb_country");

    private final String name;

    TableName(String name) {
        this.name = name;
    }
}
