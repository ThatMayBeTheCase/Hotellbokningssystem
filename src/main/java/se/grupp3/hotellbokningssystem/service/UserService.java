package se.grupp3.hotellbokningssystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.grupp3.hotellbokningssystem.model.User;
import se.grupp3.hotellbokningssystem.repository.UserRepository;
import se.grupp3.hotellbokningssystem.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return jwtUtil.generateToken(username);
        }

        return null;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
