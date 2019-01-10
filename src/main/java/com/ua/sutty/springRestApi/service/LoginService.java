package com.ua.sutty.springRestApi.service;

import com.ua.sutty.springRestApi.form.LoginForm;
import com.ua.sutty.springRestApi.transfer.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginForm loginForm);

}
