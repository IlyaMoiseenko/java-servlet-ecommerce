package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountryResultSetMapper implements ResultSetMapper<Country> {

    // FIELD
    private static CountryResultSetMapper instance;

    // CONSTRUCTOR
    private CountryResultSetMapper() {};

    // METHOD
    public static CountryResultSetMapper getInstance() {
        if (instance == null)
            instance = new CountryResultSetMapper();

        return instance;
    }

    @Override
    public Country mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Country
                    .builder()
                    .id(resultSet.getLong("country_id"))
                    .name(resultSet.getString("country_name"))
                    .build();
        }

        return null;
    }

    @Override
    public List<Country> mapRows(ResultSet resultSet) throws SQLException {

        Set<Country> countries = new HashSet<>();

        while (resultSet.next()) {
            Country build = Country
                    .builder()
                    .id(resultSet.getLong("country_id"))
                    .name(resultSet.getString("country_name"))
                    .build();

            countries.add(build);
        }

        return new ArrayList<>(countries);
    }

    @Override
    public Country mapRow(ResultSet resultSet, int row) throws SQLException {

        if (resultSet.absolute(row)) {
            return Country
                    .builder()
                    .id(resultSet.getLong("country_id"))
                    .name(resultSet.getString("country_name"))
                    .build();
        }

        return null;
    }
}
