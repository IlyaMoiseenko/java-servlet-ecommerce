package by.moiseenko.ecommerce.listener;

import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextInitializer implements ServletContextListener {

    private static final String URL = "jdbc:postgresql://localhost:5432/servlet-ecommerce";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Flyway flyway = Flyway.configure()
                .dataSource(URL, USERNAME, PASSWORD)
                .load();

        flyway.migrate();
    }
}
