package com.javafx.spring.service;

import com.javafx.spring.model.User;

public interface UserService {

    boolean authenticate(String email, String password);

    User findByEmail(String email);

}
