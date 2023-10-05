package ru.itis.repository;

import ru.itis.models.Person;

import java.util.List;
import java.util.UUID;

public interface UserRepository<T> {
    void save(String nickname, String email, String password);
    boolean checkUser(String email, String password);
    List<T> findAll();
    void saveCookie(Long id, UUID uuid);
    Long findIdByEmail(String email);
    boolean checkUsersCookie(UUID uuid);
    Person findUserByUUID(UUID uuid);
}
