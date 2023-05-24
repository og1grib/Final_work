package pages.mobile;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static tests.mobile.BaseMobileTest.configM;

public class MobileHomeBankPage {
    private final static By PHONE_CAPTION = By.xpath("//div[@ label='Номер телефона']");

    private final static By PHONE_INPUT_FIELD = By.xpath("//input [@ type='tel']");

    private final static By DATE_CAPTION = By.xpath("//div[@ label='Серия и номер паспорта']");

    private final static By DATE_INPUT_FIELD = By.xpath("//input [@ type='text']");

    private final static By BUTTON_CHECK_LIMIT = By.xpath("//button [@ class='Wrapper-sc-48arcs-1 eXAjGp styled__FormButton-y5xn20-1 foPebO']");

    private final static By CODE_FIELD = By.xpath("//input[@ inputmode='numeric']");

    private final static By CODE_FIELD_LABEL = By.xpath("//div[@ data-testid='confirmationField']/div[@ data-testid='text']");

    private final static By PHONE_CODE_1 = By.xpath("//input[@ autocomplete='one-time-code'][1]");

    private final static By PHONE_CODE_2 = By.xpath("//input[@ autocomplete='one-time-code'][2]");

    private final static By PHONE_CODE_3 = By.xpath("//input[@ autocomplete='one-time-code'][3]");

    private final static By PHONE_CODE_4 = By.xpath("//input[@ autocomplete='one-time-code'][4]");

    private final static By FALSE_CODE = By.xpath("//div [text() = 'Неправильный код']");

    private final static By APPLY_LOCATION = By.xpath("//button[@ class='Wrapper-sc-48arcs-1 jHfosx']");

    private final static By BUTTON_ENTER = By.xpath("//a [text() = 'Войти']");

    @Step("Открываем главную страницу")
    public MobileHomeBankPage openHomeBankPage() {
        Selenide.open(configM.baseUrl());
        return this;
    }

    @Step("Подтверждаем свой регион")
    public MobileHomeBankPage clickApplyLocation() {
        $(APPLY_LOCATION).click();
        return this;
    }

    @Step("Нажимаем кнопку \"Узнать лимит\"")
    public MobileHomeBankPage clickButtonCheckLimit() {
        $(BUTTON_CHECK_LIMIT).scrollTo().shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Проверяем, что под полями \"Номер телефона\" и \"Серия и номер паспорта\" появилась надпись {0}")
    public MobileHomeBankPage checkNecessarilyFields(String necessarilyCaption) {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        $(DATE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        return this;
    }

    @Step("Вводим в поле номера телефона: {0}")
    public MobileHomeBankPage inputPhoneField(int phone) {
        $(PHONE_INPUT_FIELD).scrollTo().click();
        $(PHONE_INPUT_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_INPUT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_INPUT_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_CHECK_LIMIT).scrollTo().click();
        return this;
    }

    @Step("Проверяем, что под полем \"Номер телефона\" появилась надпись: {0}")
    public MobileHomeBankPage checkTruePhoneField(String phoneCaption) {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(phoneCaption));
        return this;
    }

    @Step("Вводим в поле паспорта: {0}")
    public MobileHomeBankPage inputDataField(int data) {
        $(DATE_INPUT_FIELD).click();
        $(DATE_INPUT_FIELD).clear();
        $(DATE_INPUT_FIELD).setValue(String.valueOf(data));
        $(BUTTON_CHECK_LIMIT).click();
        return this;
    }

    @Step("Проверяем, что под полем \"Серия и номер паспорта\" появилась надпись: {0}")
    public MobileHomeBankPage checkTrueDataField(String dataCaption) {
        $(DATE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(dataCaption));
        return this;
    }

    @Step("Проверяем, что появилась надпись {0} и поле из 4 цифр")
    public MobileHomeBankPage checkCodeField(String codeField) {
        $(CODE_FIELD_LABEL).shouldHave(Condition.text(codeField));
        $$(CODE_FIELD).shouldBe(CollectionCondition.size(4));
        return this;
    }

    @Step("Вводим код рандомный код в \"Код из СМС\"")
    public MobileHomeBankPage inputPhoneCode(int num1, int num2, int num3, int num4) {
        $(PHONE_CODE_1).shouldBe(Condition.visible).setValue(String.valueOf(num1));
        $(PHONE_CODE_2).setValue(String.valueOf(num2));
        $(PHONE_CODE_3).setValue(String.valueOf(num3));
        $(PHONE_CODE_4).setValue(String.valueOf(num4));
        return this;
    }

    @Step("Проверяем надпись {0}")
    public MobileHomeBankPage checkFalseCode(String falseCode) {
        $(FALSE_CODE).shouldHave(Condition.text(falseCode));
        return this;
    }

    @Step("Нажимаем кнопку \"Войти\"")
    public MobileHomeBankPage clickEnter() {
        $(BUTTON_ENTER).shouldBe(Condition.visible).click();
        return this;
    }
}
