package pages.desktop;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreditPage {
    private final static By BUTTON_ARRANGE_ONLINE = By.xpath("//h2");

    public CreditPage clickArrange() {
        $(BUTTON_ARRANGE_ONLINE).shouldBe(Condition.visible).click();
        return this;
    }

}
