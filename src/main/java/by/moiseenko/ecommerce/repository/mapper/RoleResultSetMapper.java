package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleResultSetMapper implements ResultSetMapper<Role> {

    // FIELD
    private static RoleResultSetMapper instance;

    // CONSTRUCTOR
    private RoleResultSetMapper() {};

    // METHOD
    public static RoleResultSetMapper getInstance() {
        if (instance == null)
            instance = new RoleResultSetMapper();

        return instance;
    }

    @Override
    public Role mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Role
                    .builder()
                    .id(resultSet.getLong("role_id"))
                    .name(resultSet.getString("role_name"))
                    .build();
        }

        return null;
    }

    @Override
    public List<Role> mapRows(ResultSet resultSet) throws SQLException {

        Set<Role> roles = new HashSet<>();

        while (resultSet.next()) {
            Role build = Role
                    .builder()
                    .id(resultSet.getLong("role_id"))
                    .name(resultSet.getString("role_name"))
                    .build();

            roles.add(build);
        }

        return new ArrayList<>(roles);
    }

    @Override
    public Role mapRow(ResultSet resultSet, int row) throws SQLException {

        if (resultSet.absolute(row)) {
            return Role
                    .builder()
                    .id(resultSet.getLong("role_id"))
                    .name(resultSet.getString("role_name"))
                    .build();
        }

        return null;
    }
}
