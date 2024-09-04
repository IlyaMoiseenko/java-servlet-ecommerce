package by.moiseenko.ecommerce.listener;

import by.moiseenko.ecommerce.config.JdbcConnection;
import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FlywayInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Flyway flyway = Flyway.configure()
                .dataSource(JdbcConnection.getFlywayDataSource())
                .load();

        flyway.migrate();
    }
}
