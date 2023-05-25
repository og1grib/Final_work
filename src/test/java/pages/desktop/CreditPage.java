package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private final static By BUTTON_ARRANGE_ONLINE = By.xpath("//h2");

    @Step("Нажимаем на кнопку \"Оформить онлайн\"")
    public CreditPage clickArrange() {
        $(BUTTON_ARRANGE_ONLINE).shouldBe(Condition.visible).click();
        return this;
    }

}
