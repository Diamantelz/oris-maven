package ru.itis.repository;

import ru.itis.models.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepositoryJdbcImpl implements UserRepository<Person> {
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

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        try(ResultSet resultSet = statement.executeQuery("select * from person;");) {
            while (resultSet.next()) {
                Person person = Person.builder().build();

                person.setId(resultSet.getLong("id"));
                person.setNickname(resultSet.getString("nick_name"));
                person.setEmail(resultSet.getString("email"));

                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Long findIdByEmail(String email) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select p.id from person p where email = '" + email + "';");

            while (resultSet.next()) {
                return resultSet.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1L;
    }
}
