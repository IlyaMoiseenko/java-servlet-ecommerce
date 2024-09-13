package by.moiseenko.ecommerce.repository;

import by.moiseenko.ecommerce.config.JdbcConnection;
import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.domain.User;
import by.moiseenko.ecommerce.repository.mapper.ResultSetMapper;
import by.moiseenko.ecommerce.repository.mapper.UserResultSetMapper;
import by.moiseenko.ecommerce.repository.query.UserQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcUserRepository implements UserRepository {

    private final ResultSetMapper<User> resultSetMapper = UserResultSetMapper.getInstance();

    @Override
    public Optional<User> findByEmail(String email) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    UserQuery.FIND_BY_EMAIL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return Optional.ofNullable(resultSetMapper.mapRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> findByFirstName(String name) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    UserQuery.FIND_BY_FIRST_NAME,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
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
    public Long save(User domain) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.SAVE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domain.getEmail());
            preparedStatement.setString(2, domain.getPassword());
            preparedStatement.setString(3, domain.getFirstName());
            preparedStatement.setString(4, domain.getLastName());
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
    public Optional<User> findById(Long id) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    UserQuery.FIND_BY_ID,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
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
    public List<User> findAll() {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    UserQuery.FIND_ALL,
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

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
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.REMOVE_BY_ID);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User newDomain, Long updatedDomainId) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.UPDATE_BY_ID);
            preparedStatement.setString(1, newDomain.getEmail());
            preparedStatement.setString(2, newDomain.getPassword());
            preparedStatement.setString(3, newDomain.getFirstName());
            preparedStatement.setString(4, newDomain.getLastName());
            preparedStatement.setLong(5, updatedDomainId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long addRole(User to, Role role) {

        try (Connection connection = JdbcConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UserQuery.ADD_ROLE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, to.getId());
            preparedStatement.setLong(2, role.getId());
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
}
