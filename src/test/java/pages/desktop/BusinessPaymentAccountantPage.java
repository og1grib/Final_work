package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class BusinessPaymentAccountantPage {
    private final static By BUTTON_OPEN_ACCOUNT = By.xpath("//div[@ class='styled__Wrapper-sc-44ximf-1 iHeHnU']//button");

    private final static By BUTTON_SEND_REQUEST = By.xpath("//div[@ class='styled__BottomContainer-w5xpkp-0 ejWUgm']//button");

    private final static By PHONE_CAPTION = By.xpath("//div[@ label='Мобильный телефон']");

    private final static By EMAIL_CAPTION = By.xpath("//div[@ label='Электронная почта']");

    private final static By INN_CAPTION = By.xpath("//div[@ label='ИНН']");

    private final static By NAME_ORGANIZATION_CAPTION = By.xpath("//div[@ label='Название организации']");

    private final static By OPF_CAPTION = By.xpath("//div[@ label='Организационно-правовая форма']");

    private final static By DATA_CAPTION = By.xpath("//div[@ label='Контактное лицо']");

    private final static By PHONE_FIELD = By.xpath("//input[@ placeholder='+7 (900) 000-00-00']");

    private final static By EMAIL_FIELD = By.xpath("//input[@ placeholder='email@domain.ru']");

    private final static By INN_FIELD = By.xpath("//input[@ placeholder='ИНН или название организации']");

    private final static By INN_CHOOSE_FIELD = By.xpath("//li [@ id='react-autowhatever-1--item-0']");

    private final static By NAME_ORGANIZATION_FIELD = By.xpath("//input[@ placeholder='Введите название организации']");

    private final static By OPF_FIELD = By.xpath("//input[@ placeholder='Выберите ОПФ']");

    private final static By DATA_FIELD = By.xpath("//input[@ placeholder='ФИО']");

    private final static By ALLOW_CONDITIONS = By.xpath("//div[@ class='CheckItem-sc-cb89gg-3 cboCgp']|//div[@ class='CheckItem-sc-cb89gg-3 fJkfwj']");

    private final static By ALLOW_CONDITIONS_CAPTION = By.xpath("//div[text()='Для обработки вашей заявки вы должны согласиться с условиями обработки персональных данных']");

    private final static By CONFIRM_NUMBER = By.xpath("//h4 [@ class='Wrapper-sc-6nwvzq-0 iExIpy']");

    private final static By PHONE_CODE_1 = By.xpath("//input[@ autocomplete='one-time-code'][1]");

    private final static By PHONE_CODE_2 = By.xpath("//input[@ autocomplete='one-time-code'][2]");

    private final static By PHONE_CODE_3 = By.xpath("//input[@ autocomplete='one-time-code'][3]");

    private final static By PHONE_CODE_4 = By.xpath("//input[@ autocomplete='one-time-code'][4]");

    private final static By FALSE_CODE = By.xpath("//div [text() = 'Неправильный код']");

    private final static By SELF_INPUT = By.xpath("//div[@ class='CheckIconWrapper-sc-cb89gg-2 laHSjE']");

    @Step("Переходим в раздел \"Расчётный счёт\"")
    public BusinessPaymentAccountantPage clickOpenPaymentAccount() {
        $(BUTTON_OPEN_ACCOUNT).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Нажимаем на кнопку \"Отправить заявку\"")
    public BusinessPaymentAccountantPage clickSendRequest() {
        $(BUTTON_SEND_REQUEST).shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Проверяем надписи обязательности заполнения полей")
    public BusinessPaymentAccountantPage checkCaptions(String necessarilyCaption) {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        $(INN_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        $(NAME_ORGANIZATION_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        $(OPF_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(necessarilyCaption));
        return this;
    }

    @Step("Вводим в поле номера телефона: {0}")
    public BusinessPaymentAccountantPage inputPhone(int phone) {
        $(PHONE_FIELD).click();
        $(PHONE_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    @Step("Проверяем, что под полем телефона появилась надпись: {0}")
    public BusinessPaymentAccountantPage checkPhone(String falsePhone) {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(falsePhone));
        return this;
    }

    @Step("Вводим в поле электронная почта: {0}")
    public BusinessPaymentAccountantPage inputEmail(String email) {
        $(EMAIL_FIELD).click();
        $(EMAIL_FIELD).sendKeys(Keys.CONTROL + "a");
        $(EMAIL_FIELD).sendKeys(Keys.BACK_SPACE);
        $(EMAIL_FIELD).setValue(String.valueOf(email));
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    @Step("Проверяем, что под полем электронная почта появилась надпись: {0}")
    public BusinessPaymentAccountantPage checkEmail(String emailCaption) {
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(emailCaption));
        return this;
    }

    @Step("Вводим в поле ИНН: {0}")
    public BusinessPaymentAccountantPage inputInn1(String inn) {
        $(INN_FIELD).click();
        $(INN_FIELD).sendKeys(Keys.CONTROL + "a");
        $(INN_FIELD).sendKeys(Keys.BACK_SPACE);
        $(INN_FIELD).setValue(String.valueOf(inn));
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    @Step("Вводим в поле ИНН: {0}")
    public BusinessPaymentAccountantPage inputInn2(String inn) {
        $(INN_FIELD).click();
        $(INN_FIELD).sendKeys(Keys.CONTROL + "a");
        $(INN_FIELD).sendKeys(Keys.BACK_SPACE);
        $(INN_FIELD).setValue(String.valueOf(inn));
        $(INN_CHOOSE_FIELD).click();
        return this;
    }

    @Step("Проверяем, что под полем ИНН появилась надпись: {0}")
    public BusinessPaymentAccountantPage checkInn(String innCaption) {
        $(INN_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(innCaption));
        return this;
    }

    @Step("Проверяем данные в поле \"Название организации\" заполнилось \"О`КЕЙ\", поле \"Организационно-правовая форма\" - \"ООО\"")
    public BusinessPaymentAccountantPage checkNameOPF(String name, String opf) {
        $(NAME_ORGANIZATION_FIELD).shouldHave(Condition.value(name));
        $(OPF_FIELD).shouldHave(Condition.value(opf));
        return this;
    }

    @Step("Нажимаем на поле \"Я ознакомлен и согласен с условиями обработки персональных данных\"")
    public BusinessPaymentAccountantPage allowConditions() {
        $(ALLOW_CONDITIONS).lastChild().click();
        return this;
    }

    @Step("Проверяем надпись обязательности приема условий рассмотрения заявки {0}")
    public BusinessPaymentAccountantPage checkAllow(String allowCaption) {
        $(ALLOW_CONDITIONS_CAPTION).shouldHave(Condition.text(allowCaption));
        return this;
    }

    @Step("Вводим в поле Контактное лицо: {0}")
    public BusinessPaymentAccountantPage inputData(String data) {
        $(SELF_INPUT).click();
        $(DATA_FIELD).click();
        $(DATA_FIELD).sendKeys(Keys.CONTROL + "a");
        $(DATA_FIELD).sendKeys(Keys.BACK_SPACE);
        $(DATA_FIELD).setValue(data);
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    @Step("Вводим в поле Контактное лицо: {0}")
    public BusinessPaymentAccountantPage inputDataTrue(String data) {
        $(DATA_FIELD).click();
        $(DATA_FIELD).sendKeys(Keys.CONTROL + "a");
        $(DATA_FIELD).sendKeys(Keys.BACK_SPACE);
        $(DATA_FIELD).setValue(data);
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    @Step("Проверяем, что под полем Контактное лицо появилась надпись: {0}")
    public BusinessPaymentAccountantPage checkCaptionData(String dataCaption) {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text(dataCaption));
        return this;
    }

    @Step("Проверяем, что появилась надпись {0}")
    public BusinessPaymentAccountantPage checkConfirmPhone(String confirmPhone) {
        $(CONFIRM_NUMBER).shouldHave(Condition.text(confirmPhone));
        return this;
    }

    @Step("Вводим код рандомный код в \"Код из СМС\"")
    public BusinessPaymentAccountantPage inputPhoneCode(int num1, int num2, int num3, int num4) {
        $(PHONE_CODE_1).shouldBe(Condition.visible).setValue(String.valueOf(num1));
        $(PHONE_CODE_2).setValue(String.valueOf(num2));
        $(PHONE_CODE_3).setValue(String.valueOf(num3));
        $(PHONE_CODE_4).setValue(String.valueOf(num4));
        return this;
    }

    @Step("Проверяем надпись {0}")
    public BusinessPaymentAccountantPage checkFalseCode(String codeFalse) {
        $(FALSE_CODE).shouldHave(Condition.text(codeFalse));
        return this;
    }


}
