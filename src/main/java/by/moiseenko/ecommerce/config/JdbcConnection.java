package by.moiseenko.ecommerce.config;

import org.flywaydb.core.api.configuration.FluentConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/servlet-ecommerce";
    private static final String POSTGRES_USERNAME = "postgres";
    private static final String POSTGRES_PASSWORD = "root";

    private JdbcConnection() {}

    public static DataSource getFlywayDataSource() {
        FluentConfiguration fluentConfiguration = new FluentConfiguration();
        fluentConfiguration.dataSource(POSTGRES_URL, POSTGRES_USERNAME, POSTGRES_PASSWORD);

        return fluentConfiguration.getDataSource();
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(POSTGRES_URL, POSTGRES_USERNAME, POSTGRES_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
