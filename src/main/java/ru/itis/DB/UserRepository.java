package ru.itis.DB;

import java.util.List;

public interface UserRepository<T> {
    void save(String nickname, String email, String password);
    boolean checkUser(String email, String password);
    List<T> findAll();
}
