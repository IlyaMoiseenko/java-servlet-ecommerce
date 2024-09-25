package by.moiseenko.ecommerce.web.servlet.auth;

import by.moiseenko.ecommerce.domain.dto.request.AuthenticationRequest;
import by.moiseenko.ecommerce.domain.dto.response.UserResponse;
import by.moiseenko.ecommerce.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth/authenticate")
public class AuthenticationServlet extends HttpServlet {

    private final AuthenticationService authenticationService = AuthenticationService.getInstance();

    private static final String AUTHENTICATION_PAGE_PATH = "/pages/auth/authentication.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(AUTHENTICATION_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AuthenticationRequest build = AuthenticationRequest
                .builder()
                .email(email)
                .password(password)
                .build();

        UserResponse authenticate = authenticationService.authenticate(build);
        req.getSession().setAttribute("authenticatedUser", authenticate);
        resp.sendRedirect("/");
    }
}
