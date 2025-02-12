package com.MyFirstSpringProject.VBookstore.Service;

import com.MyFirstSpringProject.VBookstore.Model.IUserRepository;
import com.MyFirstSpringProject.VBookstore.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final com.MyFirstSpringProject.VBookstore.Model.IUserRepository IUserRepository;

    @Autowired
    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    @Override
    public List<User> findByUsername(String username) {
        return IUserRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Отримуємо список користувачів
        List<User> users = IUserRepository.findByUsername(username);

        // Перевіряємо, чи список не порожній
        if (!users.isEmpty()) {
            // Беремо першого користувача (або обробляємо за своїм бажанням)
            User userObj = users.get(0);
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        } else {
            // Якщо користувачів не знайдено, кидаємо виняток
            throw new UsernameNotFoundException(username);
        }
    }
}
