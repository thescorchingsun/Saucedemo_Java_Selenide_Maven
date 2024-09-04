package autotests;

import com.codeborne.selenide.Selenide;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.*;
import config.BrowserSettings;

@Slf4j
abstract public class BaseTest {

    @BeforeMethod
    public static void setUp() {
    new BrowserSettings().browserSettingsConfig("chrome");
}

    @AfterMethod
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

}

