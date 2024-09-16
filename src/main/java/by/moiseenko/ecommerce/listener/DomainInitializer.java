package by.moiseenko.ecommerce.listener;

import by.moiseenko.ecommerce.domain.Role;
import by.moiseenko.ecommerce.repository.JdbcRoleRepository;
import by.moiseenko.ecommerce.repository.RoleRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;
import java.util.List;

import static by.moiseenko.ecommerce.db.RoleName.ADMIN;
import static by.moiseenko.ecommerce.db.RoleName.USER;

@WebListener
public class DomainInitializer implements ServletContextListener {

    private final RoleRepository roleRepository = JdbcRoleRepository.getInstance();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        initializeRole();
    }

    private void initializeRole() {
        List<String> roles = Arrays.asList(
                ADMIN.getName(),
                USER.getName()
        );

        for (String roleName : roles) {

            if (!isRoleInitialized(roleName)) {
                roleRepository.save(Role.builder().name(roleName).build());
            }
        }
    }

    private boolean isRoleInitialized(String roleName) {
        return roleRepository.findByName(roleName).isPresent();
    }
}
