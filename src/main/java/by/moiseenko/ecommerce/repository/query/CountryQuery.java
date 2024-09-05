package by.moiseenko.ecommerce.repository.query;

import lombok.Getter;

@Getter
public class CountryQuery {

    private static final String TABLE_NAME = "tb_country";

    public static final String SAVE =
            """
            INSERT INTO %s (name)
            VALUES (?)
            """.formatted(TABLE_NAME);

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s country
            WHERE country.id = ?
            """.formatted(TABLE_NAME);

    public static final String FIND_BY_NAME =
            """
            SELECT *
            FROM %s
            WHERE name = ?
            """.formatted(TABLE_NAME);

    public static final String FIND_ALL =
            """
            SELECT *
            FROM %s
            """.formatted(TABLE_NAME);

    public static final String REMOVE_BY_ID =
            """
            DELETE
            FROM %s
            WHERE id = ?
            """.formatted(TABLE_NAME);

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET (name)
            WHERE id = ?
            """.formatted(TABLE_NAME);
}
