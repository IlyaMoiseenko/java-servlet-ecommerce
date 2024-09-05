package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleResultSetMapper implements ResultSetMapper<Role> {

    @Override
    public Role mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Role
                    .builder()
                    .name(resultSet.getString("name"))
                    .build();
        }

        return null;
    }

    @Override
    public List<Role> mapRows(ResultSet resultSet) throws SQLException {

        List<Role> roles = new ArrayList<>();

        while (resultSet.next()) {
            Role build = Role
                    .builder()
                    .name(resultSet.getString("name"))
                    .build();

            roles.add(build);
        }

        return roles;
    }
}
