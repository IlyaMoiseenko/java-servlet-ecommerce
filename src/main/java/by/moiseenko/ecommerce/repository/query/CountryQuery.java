package by.moiseenko.ecommerce.repository.query;

import by.moiseenko.ecommerce.db.TableName;
import lombok.Getter;

import static by.moiseenko.ecommerce.db.TableName.COUNTRY;

@Getter
public class CountryQuery {

    public static final String SAVE =
            """
            INSERT INTO %s (name)
            VALUES (?)
            """.formatted(COUNTRY.getName());

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s country
            WHERE country.id = ?
            """.formatted(COUNTRY.getName());

    public static final String FIND_BY_NAME =
            """
            SELECT *
            FROM %s
            WHERE name = ?
            """.formatted(COUNTRY.getName());

    public static final String FIND_ALL =
            """
            SELECT *
            FROM %s
            """.formatted(COUNTRY.getName());

    public static final String REMOVE_BY_ID =
            """
            DELETE
            FROM %s
            WHERE id = ?
            """.formatted(COUNTRY.getName());

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET name = ?
            WHERE id = ?
            """.formatted(COUNTRY.getName());
}
