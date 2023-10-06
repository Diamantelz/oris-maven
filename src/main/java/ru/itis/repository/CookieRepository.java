package ru.itis.repository;

import java.util.List;
import java.util.UUID;

public interface CookieRepository<T> {
    boolean checkUsersCookie(UUID uuid);
    T findUserByUUID(UUID uuid);
    void saveCookie(Long id, UUID uuid);
    List<String> getAllCookies();
}
