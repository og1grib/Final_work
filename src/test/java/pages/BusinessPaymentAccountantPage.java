package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BusinessPaymentAccountantPage {

    private final static By BUTTON_OPEN_ACCOUNT = By.xpath("//div[@ class='styled__Wrapper-sc-44ximf-1 iHeHnU']//button");

    public BusinessPaymentAccountantPage clickOpenPaymentAccount() {
        $(BUTTON_OPEN_ACCOUNT).shouldBe(Condition.visible).click();
        return this;
    }
}
