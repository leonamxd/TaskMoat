package com.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Album;
import com.project.models.Role;
import com.project.models.User;
import com.project.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
    	user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setUsername(updatedUser.getUsername());

        return userRepository.save(existingUser);
    }

	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}
}