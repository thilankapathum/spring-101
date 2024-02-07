package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    //-- Service Class
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired  //-- Not essential
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

/*    @Override
    public User updateUser(Long id, String firstName, String lastName, String email) {
        User user = userRepository.findById(id).get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return user;
    }*/


}
