package by.moiseenko.ecommerce.repository.mapper;

import by.moiseenko.ecommerce.domain.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressResultSetMapper implements ResultSetMapper<Address> {

    private final CountryResultSetMapper countryMapper = new CountryResultSetMapper();

    @Override
    public Address mapRow(ResultSet resultSet) throws SQLException {

        if (resultSet.next()) {
            return Address
                    .builder()
                    .city(resultSet.getString("city"))
                    .postalCode(resultSet.getInt("postal_code"))
                    .streetName(resultSet.getString("street_name"))
                    .apartmentNumber(resultSet.getInt("apartment_number"))
                    .country(countryMapper.mapRow(resultSet))
                    .build();
        }

        return null;
    }

    @Override
    public List<Address> mapRows(ResultSet resultSet) throws SQLException {
        List<Address> addresses = new ArrayList<>();

        while (resultSet.next()) {
            Address build = Address
                    .builder()
                    .city(resultSet.getString("city"))
                    .postalCode(resultSet.getInt("postal_code"))
                    .streetName(resultSet.getString("street_name"))
                    .apartmentNumber(resultSet.getInt("apartment_number"))
                    .country(countryMapper.mapRow(resultSet))
                    .build();

            addresses.add(build);
        }

        return addresses;
    }
}
