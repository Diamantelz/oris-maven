package ru.itis.servlets;

import ru.itis.DB.UserRepository;
import ru.itis.DB.UserRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "RegistrationServlet", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "lvbnhbq1989";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/orismaven";
    private Connection connection;
    private Statement statement;
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
            userRepository = new UserRepositoryJdbcImpl(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = request.getParameter("nick_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password_repeat");

        if (nickname == null
                || email == null
                || password == null
                || password_repeat == null) {
            request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
        }

        if (nickname.isEmpty()
                || email.isEmpty()
                || password.isEmpty()
                || password_repeat.isEmpty()) {
            request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
        }

        if (password.equals(password_repeat)) {
            userRepository.save(nickname, email, password);
        } else {
            request.getRequestDispatcher("jsp/registration.jsp").forward(request, response);
        }
    }
}
