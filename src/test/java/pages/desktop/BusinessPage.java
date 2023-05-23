package pages.desktop;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BusinessPage {
    private final static By BUTTON_PAYMENT_ACCOUNT = By.xpath("//a [@ href='/malomu-biznesu/raschetny-schet/']");

    public BusinessPage clickPaymentAccount() {
        $(BUTTON_PAYMENT_ACCOUNT).shouldBe(Condition.visible).click();
        return this;
    }
}
