package com.ua.sutty.springRestApi.service;

import com.ua.sutty.springRestApi.domain.User;
import com.ua.sutty.springRestApi.form.UserForm;

import java.util.List;

public interface UsersService {

    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);
}
