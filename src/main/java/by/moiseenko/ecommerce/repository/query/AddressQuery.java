package by.moiseenko.ecommerce.repository.query;

import static by.moiseenko.ecommerce.db.TableName.ADDRESS;
import static by.moiseenko.ecommerce.db.TableName.COUNTRY;

public class AddressQuery {

    public static final String SAVE =
            """
            INSERT INTO %s (city, postal_code, street_name, apartment_number, country_id)
            VALUES (?, ?, ?, ?, ?)
            """.formatted(ADDRESS.getName());

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s address
            JOIN %s country on address.country_id = country.country_id
            WHERE address.address_id = ?
            """.formatted(ADDRESS.getName(), COUNTRY.getName());

    public static final String FIND_ALL =
            """
            SELECT *
            FROM %s
            """.formatted(ADDRESS.getName());

    public static final String REMOVE_BY_ID =
            """
            DELETE FROM %s
            WHERE address_id = ?
            """.formatted(ADDRESS.getName());

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET city = ?, postal_code = ?, street_name = ?, apartment_number = ?, country_id = ?
            WHERE address_id = ?
            """.formatted(ADDRESS.getName());
}
