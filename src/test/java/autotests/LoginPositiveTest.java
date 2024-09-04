package autotests;

import com.codeborne.selenide.Selenide;
import config.ListenerTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverConditions.url;

@Slf4j
@Listeners(ListenerTest.class)
public class LoginPositiveTest extends BaseTest {

    private final String URL_LOGIN = "https://www.saucedemo.com/";
    private final String URL_CATALOG = "https://www.saucedemo.com/inventory.html";
    private final String USERNAME_STANDARD = "standard_user";
    private final String PASSWORD = "secret_sauce";

    LoginPage loginPage = new LoginPage();

    @Test(description = "Авторизация со стандартным пользователем")
    public void loginStandardUserTest() {
           loginPage.openLoginPage(URL_LOGIN)
                   .typeUsername(USERNAME_STANDARD)
                   .typePassword(PASSWORD)
                   .clickLoginButton();
        Selenide.webdriver().shouldHave(url(URL_CATALOG));
    }

}

