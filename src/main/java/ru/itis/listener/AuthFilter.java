package ru.itis.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();

        Boolean isAuthenticated = false;
        boolean sessionExists = session != null;
        boolean isLoginPage = ((HttpServletRequest) servletRequest).getRequestURI().equals("/login");

        if (sessionExists) {
            isAuthenticated = (Boolean) session.getAttribute("authenticated");
            if (isAuthenticated == null) {
                isAuthenticated = false;
            }
        }

        if (isAuthenticated && !isLoginPage || !isAuthenticated && isLoginPage) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (isAuthenticated && isLoginPage) {
            httpServletResponse.sendRedirect("/profile");
        } else {
            httpServletResponse.sendRedirect("/login");
        }
    }

    @Override
    public void destroy() {

    }
}
