package com.ua.sutty.springRestApi.service;

import com.ua.sutty.springRestApi.domain.Role;
import com.ua.sutty.springRestApi.domain.User;
import com.ua.sutty.springRestApi.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        User user = User.builder()
                .login(userForm.getLogin())
                .password(hashPassword)
                .email(userForm.getEmail())
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .birthday(userForm.getBirthday())
                .role(new Role(2L, "USER"))
                .build();
        userService.save(user);
    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User findOne(Long userId) {
        return userService.findUserById(userId);
    }

}
