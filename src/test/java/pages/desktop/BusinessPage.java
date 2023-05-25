package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BusinessPage {
    private final static By BUTTON_PAYMENT_ACCOUNT = By.xpath("//a [@ href='/malomu-biznesu/raschetny-schet/']");

    @Step("Переходим в раздел \"Расчётный счёт\"")
    public BusinessPage clickPaymentAccount() {
        $(BUTTON_PAYMENT_ACCOUNT).shouldBe(Condition.visible).click();
        return this;
    }
}
