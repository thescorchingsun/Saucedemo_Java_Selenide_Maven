package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

public class BrowserSettings {

    public void browserSettingsConfig(String browser) {

        switch (browser) {
            case ("chrome"):
                Configuration.baseUrl = "https://www.saucedemo.com/";
                Configuration.browser = "chrome";
                Configuration.browserSize = "1920x1080";
                Configuration.headless = false; //true без запуска браузера
                System.out.println("Название браузера: " + browser);
                break;
            case ("firefox"):
                Configuration.baseUrl = "https://www.saucedemo.com/";
                Configuration.browser = "firefox";
                Configuration.browserSize = "1920x1080";
                Configuration.headless = false; //true без запуска браузера
                System.out.println("Название браузера: " + browser);
                break;
        }

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        Configuration.browserCapabilities.setCapability("goog:loggingPrefs", logPrefs);
    }
}
