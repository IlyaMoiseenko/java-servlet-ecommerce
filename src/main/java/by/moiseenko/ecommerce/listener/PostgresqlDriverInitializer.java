package by.moiseenko.ecommerce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PostgresqlDriverInitializer implements ServletContextListener {

    private static final String DRIVER_NAME = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
