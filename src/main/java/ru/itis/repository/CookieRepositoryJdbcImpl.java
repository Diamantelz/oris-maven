package ru.itis.repository;

import ru.itis.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class CookieRepositoryJdbcImpl implements CookieRepository<Person> {
    private Connection connection;
    private Statement statement;

    public CookieRepositoryJdbcImpl() {
    }

    public CookieRepositoryJdbcImpl(Connection connection, Statement statement) {
        this.connection = connection;
        this.statement = statement;
    }
    @Override
    public boolean checkUsersCookie(UUID uuid) {
        if (uuid == null) {
            return false;
        }
        try {
            ResultSet resultSet = statement.executeQuery("select p.id from person p " +
                    "inner join cookie c on p.id = c.user_id and uuid = '"+uuid+"';");
            while (resultSet.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Person findUserByUUID(UUID uuid) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select p.id, p.nick_name, p.email, p.password " +
                    "from person p " +
                    "inner join cookie c " +
                    "on p.id = c.user_id " +
                    "and c.uuid = '"+uuid+"';");
            while (resultSet.next()) {
                return Person.builder()
                        .id(resultSet.getLong("id"))
                        .nickname(resultSet.getString("nick_name"))
                        .email(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveCookie(Long id, UUID uuid) {
        if (id == null || uuid == null) {
            return;
        }
        try {
            statement.execute("insert into cookie(user_id, uuid) " +
                    "values ('"+id+"', '"+uuid+"');");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getAllCookies() {
        List<String> cookies = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select c.uuid from cookie c;");
            while (resultSet.next()) {
                cookies.add(resultSet.getString("uuid"));
            }
            return cookies;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
