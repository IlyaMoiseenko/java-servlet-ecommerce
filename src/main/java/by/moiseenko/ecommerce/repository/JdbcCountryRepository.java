package by.moiseenko.ecommerce.repository;

import by.moiseenko.ecommerce.config.JdbcConnection;
import by.moiseenko.ecommerce.domain.Country;
import by.moiseenko.ecommerce.repository.mapper.CountryResultSetMapper;
import by.moiseenko.ecommerce.repository.mapper.ResultSetMapper;
import by.moiseenko.ecommerce.repository.query.CountryQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcCountryRepository implements CountryRepository {

    private final ResultSetMapper<Country> resultSetMapper = CountryResultSetMapper.getInstance();

    @Override
    public Long save(Country domain) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CountryQuery.SAVE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domain.getName());
            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next())
                    return generatedKeys.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    @Override
    public Optional<Country> findById(Long id) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CountryQuery.FIND_BY_ID);
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return Optional.ofNullable(resultSetMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Country> findByName(String name) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CountryQuery.FIND_BY_NAME);
            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return Optional.ofNullable(resultSetMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Country> findAll() {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CountryQuery.FIND_ALL);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSetMapper.mapRows(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public void removeById(Long id) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CountryQuery.REMOVE_BY_ID);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Country newDomain, Long updatedDomainId) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CountryQuery.UPDATE_BY_ID);
            preparedStatement.setString(1, newDomain.getName());
            preparedStatement.setLong(2, updatedDomainId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
