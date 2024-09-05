package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryResultSetMapper implements ResultSetMapper<Country> {

    @Override
    public Country mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Country
                    .builder()
                    .name(resultSet.getString("name"))
                    .build();
        }

        return null;
    }

    @Override
    public List<Country> mapRows(ResultSet resultSet) throws SQLException {

        List<Country> countries = new ArrayList<>();

        while (resultSet.next()) {
            Country build = Country
                    .builder()
                    .name(resultSet.getString("name"))
                    .build();

            countries.add(build);
        }

        return countries;
    }
}
