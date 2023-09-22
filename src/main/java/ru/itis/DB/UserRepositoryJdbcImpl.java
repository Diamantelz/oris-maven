package ru.itis.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepositoryJdbcImpl implements UserRepository {
    private Connection connection;
    private Statement statement;

    public UserRepositoryJdbcImpl() {
    }

    public UserRepositoryJdbcImpl(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }

    @Override
    public void save(String nickname, String email, String password) {
        if (nickname == null || email == null || password == null) {
            return;
        }

        if (nickname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return;
        }
        try {
            statement.execute("insert into person(nick_name, email, password) " +
                    "values ('"+nickname+"', '"+email+"', '"+password+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUser(String email, String password) {
        if (email == null || password == null) {
            return false;
        }

        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * from person where email = '"+email+"' " +
                    "and password = '"+password+"';");
            while (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
