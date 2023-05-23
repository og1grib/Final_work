package pages.desktop;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static tests.desktop.BaseTest.config;

public class HomeBankPage {
    private final static By PHONE_CAPTION = By.xpath("//div[@ label='Номер телефона']");

    private final static By PHONE_INPUT_FIELD = By.xpath("//input [@ type='tel']");

    private final static By DATE_CAPTION = By.xpath("//div[@ label='Серия и номер паспорта']");

    private final static By DATE_INPUT_FIELD = By.xpath("//input [@ type='text']");

    private final static By BUTTON_CHECK_LIMIT = By.xpath("//button [@ class='Wrapper-sc-48arcs-1 jcQarO styled__FormButton-hl0ql7-1 dzPHqK']");

    private final static By CODE_FIELD = By.xpath("//input[@ inputmode='numeric']");

    private final static By CODE_FIELD_LABEL = By.xpath("//div[@ data-testid='confirmationField']/div[@ data-testid='text']");

    private final static By DEPOSITS_AND_ACCOUNTS = By.xpath("//a[@ href='/chastnim-licam/vkladi/']");

    private final static By CREDIT = By.xpath("//a[@ href='/chastnim-licam/krediti/']");

    private final static By IPOTEKA = By.xpath("//a [@ href='/chastnim-licam/ipoteka/']");

    private final static By BUSINESS_AND_IP = By.xpath("//a [@ href='/malomu-biznesu/']");

    private final static By PHONE_CODE_1 = By.xpath("//input[@ autocomplete='one-time-code'][1]");

    private final static By PHONE_CODE_2 = By.xpath("//input[@ autocomplete='one-time-code'][2]");

    private final static By PHONE_CODE_3 = By.xpath("//input[@ autocomplete='one-time-code'][3]");

    private final static By PHONE_CODE_4 = By.xpath("//input[@ autocomplete='one-time-code'][4]");

    private final static By FALSE_CODE = By.xpath("//div [text() = 'Неправильный код']");

    public HomeBankPage openHomeBankPage() {
        Selenide.open(config.baseUrl());
        return this;
    }

    public HomeBankPage clickButtonCheckLimit() {
        $(BUTTON_CHECK_LIMIT).scrollIntoView(false).shouldBe(Condition.visible).click();
        return this;
    }

    public HomeBankPage checkNecessarilyFields() {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        $(DATE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        return this;
    }

    public HomeBankPage inputPhoneField(int phone) {
        $(PHONE_INPUT_FIELD).click();
        $(PHONE_INPUT_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_INPUT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_INPUT_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_CHECK_LIMIT).click();
        return this;
    }

    public HomeBankPage checkTruePhoneField() {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верные цифры"));
        return this;
    }

    public HomeBankPage inputDataField(int data) {
        $(DATE_INPUT_FIELD).click();
        $(DATE_INPUT_FIELD).sendKeys(Keys.CONTROL + "a");
        $(DATE_INPUT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(DATE_INPUT_FIELD).setValue(String.valueOf(data));
        $(BUTTON_CHECK_LIMIT).click();
        return this;
    }

    public HomeBankPage checkTrueDataField() {
        $(DATE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верные серию и номер паспорта"));
        return this;
    }

    public HomeBankPage checkCodeField() {
        $(CODE_FIELD_LABEL).shouldHave(Condition.text("Код из СМС"));
        $$(CODE_FIELD).shouldBe(CollectionCondition.size(4));
        return this;
    }

    public HomeBankPage inputPhoneCode(int num1, int num2, int num3, int num4) {
        $(PHONE_CODE_1).shouldBe(Condition.visible).setValue(String.valueOf(num1));
        $(PHONE_CODE_2).setValue(String.valueOf(num2));
        $(PHONE_CODE_3).setValue(String.valueOf(num3));
        $(PHONE_CODE_4).setValue(String.valueOf(num4));
        return this;
    }

    public HomeBankPage checkFalseCode() {
        $(FALSE_CODE).shouldHave(Condition.text("Неправильный код"));
        return this;
    }

    public HomeBankPage clickDepositsAccounts() {
        $(DEPOSITS_AND_ACCOUNTS).click();
        return this;
    }

    public HomeBankPage clickCredit() {
        $(CREDIT).click();
        return this;
    }

    public HomeBankPage clickIpoteka() {
        $(IPOTEKA).click();
        return this;
    }

    public HomeBankPage clickBusinessAndIp() {
        $(BUSINESS_AND_IP).click();
        return this;
    }

}
