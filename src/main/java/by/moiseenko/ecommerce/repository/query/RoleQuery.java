package by.moiseenko.ecommerce.repository.query;

import static by.moiseenko.ecommerce.db.TableName.ROLE;

public class RoleQuery {

    public static final String SAVE =
            """
            INSERT INTO %s (role_name)
            VALUES (?)
            """.formatted(ROLE.getName());

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s role
            WHERE role.role_id = ?
            """.formatted(ROLE.getName());

    public static final String FIND_BY_NAME =
            """
            SELECT *
            FROM %s
            WHERE role_name = ?
            """.formatted(ROLE.getName());

    public static final String FIND_ALL =
            """
            SELECT *
            FROM %s
            """.formatted(ROLE.getName());

    public static final String REMOVE_BY_ID =
            """
            DELETE
            FROM %s
            WHERE role_id = ?
            """.formatted(ROLE.getName());

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET name = ?
            WHERE role_id = ?
            """.formatted(ROLE.getName());
}
