package ru.itis.servlets;

import ru.itis.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class UsersServlets extends HttpServlet {
    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new ArrayList<>();
        User user1 = User.builder()
                .id(1L)
                .firstname("Dmitry")
                .lastname("Miheenko")
                .age(20)
                .build();

        User user2 = User.builder()
                .id(2L)
                .firstname("Artem")
                .lastname("Maynor")
                .age(28)
                .build();

        User user3 = User.builder()
                .id(3L)
                .firstname("Anastasiya")
                .lastname("Lashevich")
                .age(20)
                .build();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usersForJsp", users);
        request.getRequestDispatcher("jsp/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
