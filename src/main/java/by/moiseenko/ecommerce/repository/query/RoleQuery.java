package by.moiseenko.ecommerce.repository.query;

import static by.moiseenko.ecommerce.db.TableName.ROLE;

public class RoleQuery {

    public static final String SAVE =
            """
            INSERT INTO %s (name)
            VALUES (?)
            """.formatted(ROLE.getName());

    public static final String FIND_BY_ID =
            """
            SELECT *
            FROM %s role
            WHERE role.id = ?
            """.formatted(ROLE.getName());

    public static final String FIND_BY_NAME =
            """
            SELECT *
            FROM %s
            WHERE name = ?
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
            WHERE id = ?
            """.formatted(ROLE.getName());

    public static final String UPDATE_BY_ID =
            """
            UPDATE %s
            SET name = ?
            WHERE id = ?
            """.formatted(ROLE.getName());
}
