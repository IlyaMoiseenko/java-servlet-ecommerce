package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Address;
import by.moiseenko.ecommerce.domain.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressResultSetMapper implements ResultSetMapper<Address> {

    // FIELD
    private static AddressResultSetMapper instance;
    private final ResultSetMapper<Country> countryMapper = CountryResultSetMapper.getInstance();

    // CONSTRUCTOR
    private AddressResultSetMapper() {};

    // METHOD
    public static AddressResultSetMapper getInstance() {
        if (instance == null)
            instance = new AddressResultSetMapper();

        return instance;
    }

    @Override
    public Address mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Address
                    .builder()
                    .id(resultSet.getLong("address_id"))
                    .city(resultSet.getString("city"))
                    .postalCode(resultSet.getInt("postal_code"))
                    .streetName(resultSet.getString("street_name"))
                    .apartmentNumber(resultSet.getInt("apartment_number"))
                    .country(countryMapper.mapRow(resultSet, resultSet.getRow()))
                    .build();
        }

        return null;
    }

    @Override
    public List<Address> mapRows(ResultSet resultSet) throws SQLException {

        Set<Address> addresses = new HashSet<>();

        while (resultSet.next()) {
            Address build = Address
                    .builder()
                    .id(resultSet.getLong("address_id"))
                    .city(resultSet.getString("city"))
                    .postalCode(resultSet.getInt("postal_code"))
                    .streetName(resultSet.getString("street_name"))
                    .apartmentNumber(resultSet.getInt("apartment_number"))
                    .country(countryMapper.mapRow(resultSet, resultSet.getRow()))
                    .build();

            addresses.add(build);
        }

        return new ArrayList<>(addresses);
    }

    @Override
    public Address mapRow(ResultSet resultSet, int row) throws SQLException {

        if (resultSet.absolute(row)) {
            return Address
                    .builder()
                    .id(resultSet.getLong("address_id"))
                    .city(resultSet.getString("city"))
                    .postalCode(resultSet.getInt("postal_code"))
                    .streetName(resultSet.getString("street_name"))
                    .apartmentNumber(resultSet.getInt("apartment_number"))
                    .country(countryMapper.mapRow(resultSet, row))
                    .build();
        }

        return null;
    }
}
