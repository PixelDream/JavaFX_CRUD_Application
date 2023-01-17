package com.javafx.spring;

import com.javafx.spring.view.StageManager;
import com.javafx.spring.view.login.LoginPane;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Locale;

@SpringBootApplication
public class MainApp implements ApplicationListener<StageReadyEvent> {
    private static StageManager STAGE_MANAGER;

    private static Locale LOCALE = Locale.FRANCE;

    final
    ConfigurableApplicationContext springAppContext;

    public MainApp(ConfigurableApplicationContext springAppContext) {
        this.springAppContext = springAppContext;
    }

    public static void main(String[] args) {
        Application.launch(SpringbootJavaFxApplication.class, args);
    }

    public static StageManager getStageManager() {
        return STAGE_MANAGER;
    }

    public static Locale getLOCALE() {
        return LOCALE;
    }

    public static void setLOCALE(Locale locale) {
        MainApp.LOCALE = locale;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        STAGE_MANAGER = springAppContext.getBean(StageManager.class, event.stage);
        STAGE_MANAGER.rebuildStage(LoginPane.class);
    }
}
