package pages.mobile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MobileCodePage {

    private final static By CODE_FIELD = By.xpath("//input [@type='tel']");

    private final static By CODE_FIELD_CAPTION = By.xpath("//p [@ data-testid='form-error']");

    @Step("Вводим код рандомный код в \"Код из СМС\" {0}")
    public MobileCodePage inputCodeField(int code) {
        $(CODE_FIELD).shouldBe(Condition.visible).click();
        $(CODE_FIELD).setValue(String.valueOf(code));
        return this;
    }

    @Step("Проверяем неправильно введенный код")
    public MobileCodePage checkTrueCode(String codeFalse) {
        $(CODE_FIELD_CAPTION).shouldHave(Condition.text(codeFalse));
        return this;
    }
}
