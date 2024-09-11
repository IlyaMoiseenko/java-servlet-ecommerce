package by.moiseenko.ecommerce.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetMapper<T> {

    T mapRow(ResultSet resultSet) throws SQLException;
    T mapRow(ResultSet resultSet, int row) throws SQLException;
    List<T> mapRows(ResultSet resultSet) throws SQLException;
}
