package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {

    private final SelenideElement

            titleText = $x("/span[@data-test='title']"),
            burgerMenuButton = $x("//div/div/div[@id='menu_button_container']");

    public ProductsPage getTitleText() {
        titleText.getText();
        return this;
    }

    public ProductsPage burgerMenuButtonIsVisible() {
        burgerMenuButton.shouldBe(Condition.visible);
        return this;
    }
}








