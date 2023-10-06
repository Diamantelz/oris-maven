package ru.itis.servlets;

import ru.itis.repository.CookieRepository;
import ru.itis.repository.CookieRepositoryJdbcImpl;
import ru.itis.repository.UserRepository;
import ru.itis.repository.UserRepositoryJdbcImpl;
import ru.itis.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "lvbnhbq1989";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/orismaven";
    private UserRepository<Person> userRepository;
    private CookieRepository<Person> cookieRepository;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement statement = connection.createStatement();
            userRepository = new UserRepositoryJdbcImpl(connection, statement);
            cookieRepository = new CookieRepositoryJdbcImpl(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        List<String> cookieValues = cookieRepository.getAllCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            if (cookieValues.contains(cookies[i].getValue())) {
//                response.sendRedirect("/profile");
//                return;
//            } else {
//                request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
//            }
//        }
        request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null) {
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }

        if (email.isEmpty() || password.isEmpty()) {
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }

        if (userRepository.checkUser(email, password)) {
            System.out.println("successfully signed in");

            HttpSession httpSession = request.getSession(true);
            httpSession.setAttribute("authenticated", true);

//            UUID uuid = UUID.randomUUID();
//            Cookie cookie = new Cookie("personCookie", uuid.toString());
//            response.addCookie(cookie);
//
//            Long personId = userRepository.findIdByEmail(email);
//            cookieRepository.saveCookie(personId, uuid);

            response.sendRedirect("/profile");
        } else {
            System.out.println("sign in denied. try again");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}
