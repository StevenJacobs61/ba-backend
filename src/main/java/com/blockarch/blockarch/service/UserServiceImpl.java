package com.blockarch.blockarch.service;

import com.blockarch.blockarch.model.Users;
import com.blockarch.blockarch.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }
    @Override
    public Users getUserByEmail(String email) {
        return userRepository.findByEmailAddress(email);
    }
    @Override
    public Users updateUser(Long id, Users updatedFields) {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            Users existingUser = optionalUser.get();

            // Get all fields of the Users class
            Field[] fields = Users.class.getDeclaredFields();

            // Iterate through the fields
            for (Field field : fields) {
                try {
                    // Set the field accessible to allow modification
                    field.setAccessible(true);

                    // Get the value of the corresponding field from updatedFields
                    Object updatedValue = field.get(updatedFields);

                    // Check if the updated value is not null and update the field in existingUser
                    if (updatedValue != null) {
                        field.set(existingUser, updatedValue);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Save the updated Users object
            return userRepository.save(existingUser);
        }
        return null;
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
