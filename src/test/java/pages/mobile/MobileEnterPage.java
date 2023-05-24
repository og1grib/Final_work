package pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class MobileEnterPage {

    private final static By PHONE_FIELD = By.xpath("//input[@ placeholder='+7']");

    private final static By BUTTON_NEXT = By.xpath("//button[@ type='submit']");

    private final static By PHONE_FIELD_CAPTION = By.xpath("//div[@ data-testid='error']");

    @Step("Вводим в поле номера телефона: {0}")
    public MobileEnterPage inputPhoneField(long phone) {
        $(PHONE_FIELD).shouldBe(Condition.visible).click();
        $(PHONE_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_NEXT).click();
        return this;
    }

    @Step("Проверяем, что под полем телефона появилась надпись: {0}")
    public MobileEnterPage checkTruePhoneField(String phoneCaption) {
        $(PHONE_FIELD_CAPTION).shouldHave(Condition.text(phoneCaption));
        return this;
    }
}
