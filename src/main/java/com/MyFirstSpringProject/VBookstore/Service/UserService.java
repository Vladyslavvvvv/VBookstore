package com.MyFirstSpringProject.VBookstore.Service;

import com.MyFirstSpringProject.VBookstore.Model.IUserRepository;
import com.MyFirstSpringProject.VBookstore.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final com.MyFirstSpringProject.VBookstore.Model.IUserRepository IUserRepository;

    @Autowired
    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    // User search by username
    @Override
    public Optional<User> findByUsername(String username) {
        return IUserRepository.findByUsername(username);
    }

    // Loading the user by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Search for a user by username
        Optional<User> optionalUser = IUserRepository.findByUsername(username);

        // If the user is not found, we throw an exception
        User userObj = optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(userObj.getUsername())
                .password(userObj.getPassword())
                .build();
    }
}
