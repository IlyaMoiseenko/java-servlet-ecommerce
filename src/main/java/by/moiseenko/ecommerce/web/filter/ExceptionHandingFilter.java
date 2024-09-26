package by.moiseenko.ecommerce.web.filter;

import by.moiseenko.ecommerce.exception.DomainNotFoundException;
import by.moiseenko.ecommerce.exception.ResourceMappingException;
import by.moiseenko.ecommerce.exception.ValidationException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionHandingFilter implements Filter {

    private static final String ERROR_PAGE_PATH = "/pages/error/error.jsp";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        try {
            filterChain.doFilter(request, response);
        } catch (DomainNotFoundException e) {
            handleException(request, response, HttpServletResponse.SC_NOT_FOUND, e);
        } catch (ValidationException | ResourceMappingException e) {
            handleException(request, response, HttpServletResponse.SC_BAD_REQUEST, e);
        }
    }

    private void handleException(ServletRequest request, ServletResponse response, int statusCode, Exception e)
            throws ServletException, IOException {

        request.setAttribute("errorMessage", e.getMessage());
        request.setAttribute("errorCode", statusCode);

        RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR_PAGE_PATH);
        dispatcher.forward(request, response);
    }
}
