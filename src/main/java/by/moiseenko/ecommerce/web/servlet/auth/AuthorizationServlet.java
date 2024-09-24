package by.moiseenko.ecommerce.web.servlet.auth;

import by.moiseenko.ecommerce.domain.dto.request.UserRequest;
import by.moiseenko.ecommerce.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/auth/register")
public class AuthorizationServlet extends HttpServlet {

    private final AuthenticationService authenticationService = AuthenticationService.getInstance();

    private static final String AUTHORIZATION_PAGE_PATH = "/pages/auth/authorization.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(AUTHORIZATION_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> credentials = getDataFromRequest(req);

        UserRequest build = UserRequest
                .builder()
                .firstName(credentials.get("firstname"))
                .lastName(credentials.get("lastname"))
                .email(credentials.get("email"))
                .password(credentials.get("password"))
                .build();

        boolean authorization = authenticationService.authorization(build);
        if (!authorization)
            // TODO: implement "error.jsp"
            resp.sendRedirect("/auth/authentication");

        resp.sendRedirect("/auth/authentication");
    }

    private Map<String, String> getDataFromRequest(HttpServletRequest request) {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        return Map.of(
                "firstname", firstname,
                "lastname", lastname,
                "email", email,
                "password", password
        );
    }
}
