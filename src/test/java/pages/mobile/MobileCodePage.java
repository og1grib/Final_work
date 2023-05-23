package pages.mobile;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MobileCodePage {

    private final static By CODE_FIELD = By.xpath("//input [@type='tel']");

    private final static By CODE_FIELD_CAPTION = By.xpath("//p [@ data-testid='form-error']");

    public MobileCodePage inputCodeField(int code) {
        $(CODE_FIELD).shouldBe(Condition.visible).click();
        $(CODE_FIELD).setValue(String.valueOf(code));
        return this;
    }

    public MobileCodePage checkTrueCode() {
        $(CODE_FIELD_CAPTION).shouldHave(Condition.text("Неверный код."));
        return this;
    }
}
