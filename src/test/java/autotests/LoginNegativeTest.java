package autotests;

import com.codeborne.selenide.Selenide;
import config.ListenerTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Slf4j
@Listeners(ListenerTest.class)
public class LoginNegativeTest {

    private final String URL_LOGIN = "https://www.saucedemo.com/";
    private final String USERNAME_LOCKED_OUT = "locked_out_user";
    private final String PASSWORD = "secret_sauce";
    private final String EXPECTED_RESULT_ERROR_EMPTY_TEXT = "Epic sadface: Username is required";
    private final String EXPECTED_RESULT_LOCKED_OUT_TEXT = "Epic sadface: Sorry, this user has been locked out.";

    LoginPage loginPage = new LoginPage();

    @Test(description = "Авторизация с заблокированным пользователем")
    public void loginLockedOutUserTest() {
        loginPage.openLoginPage(URL_LOGIN)
                .typeUsername(USERNAME_LOCKED_OUT)
                .typePassword(PASSWORD)
                .clickLoginButton();
        Assert.assertEquals(loginPage.getErrorH3LockedOutText(), EXPECTED_RESULT_LOCKED_OUT_TEXT);
    }

    @Test(description = "Текст ошибки при авторизации с пустым username и password")
    public void errorTextAuthWithoutUsernameAndPasswordTest() {
        loginPage.openLoginPage(URL_LOGIN)
                .clickLoginErrorTextButton();
        Assert.assertEquals(loginPage.getErrorH3EmptyText(), EXPECTED_RESULT_ERROR_EMPTY_TEXT);
    }

}
