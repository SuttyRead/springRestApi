package com.ua.sutty.springRestApi.service;

import com.ua.sutty.springRestApi.domain.Token;
import com.ua.sutty.springRestApi.domain.User;
import com.ua.sutty.springRestApi.form.LoginForm;
import com.ua.sutty.springRestApi.repository.TokenRepository;
import com.ua.sutty.springRestApi.transfer.TokenDTO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public TokenDTO login(LoginForm loginForm) {
        Optional<User> userCandidate = userService.findOneByLogin(loginForm.getLogin());

        if (userCandidate.isPresent()){
            User user = userCandidate.get();

            if (passwordEncoder.matches(loginForm.getLogin(), user.getPassword())){
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokenRepository.save(token);
                return TokenDTO.from(token);
            }
        } throw new IllegalArgumentException("User not found");

    }
}
