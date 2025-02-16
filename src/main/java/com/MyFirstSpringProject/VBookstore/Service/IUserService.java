package com.MyFirstSpringProject.VBookstore.Service;

import com.MyFirstSpringProject.VBookstore.Model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends UserDetailsService {
    // User search by username
    Optional<User> findByUsername(String username);

    // Loading the user by username
    UserDetails loadUserByUsername(String username);
}
