package com.javafx.spring.view.login;

import com.javafx.spring.service.UserService;
import com.javafx.spring.view.StageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LoginPaneManager {
    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    public void login(LoginPane loginPane) {
        String username = loginPane.getUsername();
        String password = loginPane.getPassword();

        if (userService.authenticate(username, password)) {
//            stageManager.rebuildStage(MainPane.class);
        } else {
            loginPane.getLblLogin().setText("Invalid username or password");
        }
    }
}
