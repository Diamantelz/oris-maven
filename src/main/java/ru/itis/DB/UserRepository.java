package ru.itis.DB;

public interface UserRepository {
    void save(String nickname, String email, String password);
    boolean checkUser(String email, String password);
}
