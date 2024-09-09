package by.moiseenko.ecommerce.repository.query;

import static by.moiseenko.ecommerce.db.TableName.*;

public class UserQuery {

    public static final String FIND_BY_EMAIL =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.id = user_address.user_id
            JOIN %s address on user_address.address.id = address.id
            JOIN %s country on address.country_id = country.id
            JOIN %s user_role on user.id = user_role.user_id
            JOIN %s role on user_role.role_id = role.id
            WHERE user.email = ?
            """.formatted(USER, USER_ADDRESS, ADDRESS, COUNTRY, USER_ROLE, ROLE);

    public static final String FIND_BY_FIRST_NAME =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.id = user_address.user_id
            JOIN %s address on user_address.address.id = address.id
            JOIN %s country on address.country_id = country.id
            JOIN %s user_role on user.id = user_role.user_id
            JOIN %s role on user_role.role_id = role.id
            WHERE user.first_name = ?
            """.formatted(USER, USER_ADDRESS, ADDRESS, COUNTRY, USER_ROLE, ROLE);

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.id = user_address.user_id
            JOIN %s address on user_address.address.id = address.id
            JOIN %s country on address.country_id = country.id
            JOIN %s user_role on user.id = user_role.user_id
            JOIN %s role on user_role.role_id = role.id
            WHERE user.id = ?
            """.formatted(USER, USER_ADDRESS, ADDRESS, COUNTRY, USER_ROLE, ROLE);

    public static final String FIND_ALL =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.id = user_address.user_id
            JOIN %s address on user_address.address.id = address.id
            JOIN %s country on address.country_id = country.id
            JOIN %s user_role on user.id = user_role.user_id
            JOIN %s role on user_role.role_id = role.id
            """.formatted(USER, USER_ADDRESS, ADDRESS, COUNTRY, USER_ROLE, ROLE);

    public static final String SAVE =
            """
            INSERT INTO %s (email, password, first_name, last_name)
            VALUES (?, ?, ?, ?)
            """.formatted(USER);

    public static final String REMOVE_BY_ID =
            """
            DELETE FROM %s
            WHERE id = ?
            """.formatted(USER);

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET (email, password, first_name, last_name)
            WHERE id = ?
            """.formatted(USER);

    public static final String ADD_ROLE =
            """
            INSERT INTO %s (user_id, role_id)
            VALUES (?, ?)
            """.formatted(USER_ROLE);
}
