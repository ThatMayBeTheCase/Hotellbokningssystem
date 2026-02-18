package se.grupp3.hotellbokningssystem.repository;

import org.springframework.stereotype.Repository;
import se.grupp3.hotellbokningssystem.model.User;
import se.grupp3.hotellbokningssystem.model.UserRole;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<String, User> users = new HashMap<>();
    private Long nextId = 1L;

    public UserRepository() {
        // Skapa test-användare
        addUser(new User("user", "user@example.com", "password", UserRole.USER));
        addUser(new User("admin", "admin@example.com", "password", UserRole.ADMIN));
    }

    public void addUser(User user) {
        user.setId(nextId++);
        users.put(user.getUsername(), user);
    }

    public User findByUsername(String username) {
        return users.get(username);
    }

    public boolean existsByUsername(String username) {
        return users.containsKey(username);
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }
}
