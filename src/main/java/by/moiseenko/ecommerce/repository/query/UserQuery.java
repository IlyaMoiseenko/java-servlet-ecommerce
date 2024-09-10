package by.moiseenko.ecommerce.repository.query;

import static by.moiseenko.ecommerce.db.TableName.*;

public class UserQuery {

    public static final String FIND_BY_EMAIL =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.user_id = user_address.user_id
            JOIN %s address on user_address.address_id = address.address_id
            JOIN %s country on address.country_id = country.country_id
            JOIN %s user_role on user.user_id = user_role.user_id
            JOIN %s role on user_role.role_id = role.role_id
            WHERE user.email = ?
            """.formatted(
                    USER.getName(),
                    USER_ADDRESS.getName(),
                    ADDRESS.getName(),
                    COUNTRY.getName(),
                    USER_ROLE.getName(),
                    ROLE.getName()
            );

    public static final String FIND_BY_FIRST_NAME =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.user_id = user_address.user_id
            JOIN %s address on user_address.address_id = address.address_id
            JOIN %s country on address.country_id = country.country_id
            JOIN %s user_role on user.user_id = user_role.user_id
            JOIN %s role on user_role.role_id = role.role_id
            WHERE user.first_name = ?
            """.formatted(
                    USER.getName(),
                    USER_ADDRESS.getName(),
                    ADDRESS.getName(),
                    COUNTRY.getName(),
                    USER_ROLE.getName(),
                    ROLE.getName()
            );

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.user_id = user_address.user_id
            JOIN %s address on user_address.address_id = address.address_id
            JOIN %s country on address.country_id = country.country_id
            JOIN %s user_role on user.user_id = user_role.user_id
            JOIN %s role on user_role.role_id = role.role_id
            WHERE user.user_id = ?
            """.formatted(
                    USER.getName(),
                    USER_ADDRESS.getName(),
                    ADDRESS.getName(),
                    COUNTRY.getName(),
                    USER_ROLE.getName(),
                    ROLE.getName()
            );

    public static final String FIND_ALL =
            """
            SELECT *
            FROM %s user
            JOIN %s user_address on user.user_id = user_address.user_id
            JOIN %s address on user_address.address_id = address.address_id
            JOIN %s country on address.country_id = country.country_id
            JOIN %s user_role on user.user_id = user_role.user_id
            JOIN %s role on user_role.role_id = role.role_id
            """.formatted(
                    USER.getName(),
                    USER_ADDRESS.getName(),
                    ADDRESS.getName(),
                    COUNTRY.getName(),
                    USER_ROLE.getName(),
                    ROLE.getName()
            );

    public static final String SAVE =
            """
            INSERT INTO %s (email, password, first_name, last_name)
            VALUES (?, ?, ?, ?)
            """.formatted(USER.getName());

    public static final String REMOVE_BY_ID =
            """
            DELETE FROM %s
            WHERE user_id = ?
            """.formatted(USER.getName());

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET email = ?, password = ?, first_name = ?, last_name = ?
            WHERE user_id = ?
            """.formatted(USER.getName());

    public static final String ADD_ROLE =
            """
            INSERT INTO %s (user_id, role_id)
            VALUES (?, ?)
            """.formatted(USER_ROLE.getName());
}
