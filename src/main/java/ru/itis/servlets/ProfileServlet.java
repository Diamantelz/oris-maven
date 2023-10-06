package ru.itis.servlets;

import ru.itis.repository.CookieRepository;
import ru.itis.repository.CookieRepositoryJdbcImpl;
import ru.itis.repository.UserRepository;
import ru.itis.repository.UserRepositoryJdbcImpl;
import ru.itis.models.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
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
        Cookie[] cookies = request.getCookies();
//        List<String> cookieValues = cookieRepository.getAllCookies();
//        for (Cookie cookie : cookies) {
//            if (cookieValues.contains(cookie.getValue())) {
//                UUID uuid = UUID.fromString(cookie.getValue());
//                Person personByUUID = cookieRepository.findUserByUUID(uuid);
//                request.setAttribute("personByUUID", personByUUID);
//                request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
//            } else {
//                response.sendRedirect("/login");
//            }
//        }
        request.getRequestDispatcher("jsp/profile.jsp").forward(request, response);
    }
}
