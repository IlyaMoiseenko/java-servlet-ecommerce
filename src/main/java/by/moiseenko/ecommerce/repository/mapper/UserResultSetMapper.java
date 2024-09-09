package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Address;
import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultSetMapper implements ResultSetMapper<User> {

    private final ResultSetMapper<Address> addressResultSetMapper = new AddressResultSetMapper();
    private final ResultSetMapper<Role> roleResultSetMapper = new RoleResultSetMapper();

    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return User
                    .builder()
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .addresses(addressResultSetMapper.mapRows(resultSet))
                    .roles(roleResultSetMapper.mapRows(resultSet))
                    .build();
        }

        return null;
    }

    @Override
    public List<User> mapRows(ResultSet resultSet) throws SQLException {

        List<User> users = new ArrayList<>();

        while (resultSet.next()) {
            User build = User
                    .builder()
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .addresses(addressResultSetMapper.mapRows(resultSet))
                    .roles(roleResultSetMapper.mapRows(resultSet))
                    .build();

            users.add(build);
        }

        return users;
    }
}
