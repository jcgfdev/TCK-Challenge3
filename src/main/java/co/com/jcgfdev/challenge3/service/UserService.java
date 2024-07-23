package co.com.jcgfdev.challenge3.service;

import co.com.jcgfdev.challenge3.model.User;
import co.com.jcgfdev.challenge3.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }
}
