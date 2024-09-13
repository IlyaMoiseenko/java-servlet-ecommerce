package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Address;
import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserResultSetMapper implements ResultSetMapper<User> {

    // FIELD
    private static UserResultSetMapper instance;
    private final ResultSetMapper<Address> addressResultSetMapper = AddressResultSetMapper.getInstance();
    private final ResultSetMapper<Role> roleResultSetMapper = RoleResultSetMapper.getInstance();

    // CONSTRUCTOR
    private UserResultSetMapper() {};

    // METHOD
    public static UserResultSetMapper getInstance() {
        if (instance == null)
            instance = new UserResultSetMapper();

        return instance;
    }

    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {

        List<Address> addresses = addressResultSetMapper.mapRows(resultSet);
        resultSet.beforeFirst();

        List<Role> roles = roleResultSetMapper.mapRows(resultSet);
        resultSet.beforeFirst();

        if (resultSet.next()) {
            return User
                    .builder()
                    .id(resultSet.getLong("user_id"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .addresses(addresses)
                    .roles(roles)
                    .build();
        }

        return null;
    }

    @Override
    public List<User> mapRows(ResultSet resultSet) throws SQLException {

        Set<User> users = new HashSet<>();

        List<Address> addresses = addressResultSetMapper.mapRows(resultSet);
        resultSet.beforeFirst();

        List<Role> roles = roleResultSetMapper.mapRows(resultSet);
        resultSet.beforeFirst();

        while (resultSet.next()) {
            User build = User
                    .builder()
                    .id(resultSet.getLong("user_id"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .addresses(addresses)
                    .roles(roles)
                    .build();

            users.add(build);
        }

        return new ArrayList<>(users);
    }

    @Override
    public User mapRow(ResultSet resultSet, int row) throws SQLException {

        if (resultSet.absolute(row)) {
            List<Address> addresses = addressResultSetMapper.mapRows(resultSet);
            resultSet.absolute(row);

            List<Role> roles = roleResultSetMapper.mapRows(resultSet);
            resultSet.absolute(row);

            return User
                    .builder()
                    .id(resultSet.getLong("user_id"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password"))
                    .firstName(resultSet.getString("first_name"))
                    .lastName(resultSet.getString("last_name"))
                    .addresses(addresses)
                    .roles(roles)
                    .build();
        }

        return null;
    }
}
