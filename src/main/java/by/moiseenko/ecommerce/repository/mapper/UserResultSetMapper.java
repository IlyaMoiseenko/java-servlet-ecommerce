package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserResultSetMapper implements ResultSetMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public List<User> mapRows(ResultSet resultSet) throws SQLException {
        return List.of();
    }
}
