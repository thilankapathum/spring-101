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

    @Override
    public User updateUser(User user) {

        User existingUser = userRepository.findById(user.getId()).get();

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    @Override
    public User deleteUser(Long id) {
        User deletingUser = userRepository.findById(id).get();  //-- Hold an Object of the User just to display the deleted information
        userRepository.deleteById(id);
        return deletingUser;    //-- Return UserObject to REST API to display deleted user's information
    }

/*    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }*/


}
