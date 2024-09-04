package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement

            usernameInput = $(By.name("user-name")),
            passwordInput = $(By.name("password")),
            loginButton = $(By.name("login-button"));


    public LoginPage openLoginPage(String url) {
        Selenide.open(url);
        return this;
    }

    public LoginPage typeUsername(String username) {
        usernameInput.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage();
    }

    public LoginPage clickLoginErrorTextButton() {
        loginButton.click();
        return this;
    }

    public String getErrorH3EmptyText() {
        return Selenide.$("#login_button_container").$(Selectors.withText("Epic sadface: Username is required")).getText();
    }

    public String getErrorH3LockedOutText() {
        return Selenide.$("#login_button_container").$(Selectors.withText("Epic sadface: Sorry, this user has been locked out.")).getText();
    }

}
