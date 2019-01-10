package com.ua.sutty.springRestApi.controller;

import com.ua.sutty.springRestApi.form.LoginForm;
import com.ua.sutty.springRestApi.service.LoginService;
import com.ua.sutty.springRestApi.transfer.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginForm loginForm){
        System.out.println(loginForm);
        return ResponseEntity.ok(loginService.login(loginForm));
    }

}
