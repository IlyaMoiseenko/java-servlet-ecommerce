package by.moiseenko.ecommerce.repository;

import by.moiseenko.ecommerce.config.JdbcConnection;
import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.repository.mapper.ResultSetMapper;
import by.moiseenko.ecommerce.repository.mapper.RoleResultSetMapper;
import by.moiseenko.ecommerce.repository.query.RoleQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcRoleRepository implements RoleRepository {

    private final ResultSetMapper<Role> resultSetMapper = new RoleResultSetMapper();

    @Override
    public Optional<Role> findByName(String name) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(RoleQuery.FIND_BY_NAME);
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
    public Long save(Role domain) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(RoleQuery.SAVE, Statement.RETURN_GENERATED_KEYS);
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
    public Optional<Role> findById(Long id) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(RoleQuery.FIND_BY_ID);
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
    public List<Role> findAll() {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(RoleQuery.FIND_ALL);

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
            PreparedStatement preparedStatement = connection.prepareStatement(RoleQuery.REMOVE_BY_ID);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Role newDomain, Long updatedDomainId) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(RoleQuery.UPDATE_BY_ID);
            preparedStatement.setString(1, newDomain.getName());
            preparedStatement.setLong(2, updatedDomainId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
