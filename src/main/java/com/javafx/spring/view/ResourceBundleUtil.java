package com.javafx.spring.view;

import com.javafx.spring.MainApp;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceBundleUtil {

    public static ResourceBundle getResourceBundle() {
        return ResourceBundle.getBundle("Bundle", MainApp.getLOCALE());
    }

    public static String getKey(String key) {
        return getResourceBundle().getString(key);
    }

    public static Set<Locale> getSupportedLanguages() {
        return Arrays.stream(Locale.getAvailableLocales())
                .filter(lcl -> {
                    try {
                        return ResourceBundle.getBundle("Bundle", lcl).getLocale() == lcl;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .collect(Collectors.toSet());
    }

}
