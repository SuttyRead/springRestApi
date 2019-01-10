package com.ua.sutty.springRestApi.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {

    private String login;
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private Date birthday;

}
