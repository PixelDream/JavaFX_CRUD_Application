package com.javafx.spring;

import com.javafx.spring.view.StageManager;
import javafx.stage.Stage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
    @Bean
    @Lazy() //Stage only created after Spring context bootstap
    public StageManager stageManager(Stage stage) {
        return new StageManager(stage);
    }

}
