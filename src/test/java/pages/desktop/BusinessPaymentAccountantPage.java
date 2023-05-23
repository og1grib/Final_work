package pages.desktop;

import com.codeborne.selenide.Condition;
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

    public BusinessPaymentAccountantPage clickOpenPaymentAccount() {
        $(BUTTON_OPEN_ACCOUNT).shouldBe(Condition.visible).click();
        return this;
    }

    public BusinessPaymentAccountantPage clickSendRequest() {
        $(BUTTON_SEND_REQUEST).shouldBe(Condition.visible).click();
        return this;
    }

    public BusinessPaymentAccountantPage checkCaptions() {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(INN_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(NAME_ORGANIZATION_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(OPF_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Поле обязательно для заполнения"));
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Поле обязательно для заполнения"));
        return this;
    }

    public BusinessPaymentAccountantPage inputPhone(int phone) {
        $(PHONE_FIELD).click();
        $(PHONE_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    public BusinessPaymentAccountantPage checkPhone() {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный номер телефона"));
        return this;
    }

    public BusinessPaymentAccountantPage inputEmail(String email) {
        $(EMAIL_FIELD).click();
        $(EMAIL_FIELD).sendKeys(Keys.CONTROL + "a");
        $(EMAIL_FIELD).sendKeys(Keys.BACK_SPACE);
        $(EMAIL_FIELD).setValue(String.valueOf(email));
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    public BusinessPaymentAccountantPage checkEmail() {
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный эл. адрес"));
        return this;
    }

    public BusinessPaymentAccountantPage inputInn1(String inn) {
        $(INN_FIELD).click();
        $(INN_FIELD).sendKeys(Keys.CONTROL + "a");
        $(INN_FIELD).sendKeys(Keys.BACK_SPACE);
        $(INN_FIELD).setValue(String.valueOf(inn));
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    public BusinessPaymentAccountantPage inputInn2(String inn) {
        $(INN_FIELD).click();
        $(INN_FIELD).sendKeys(Keys.CONTROL + "a");
        $(INN_FIELD).sendKeys(Keys.BACK_SPACE);
        $(INN_FIELD).setValue(String.valueOf(inn));
        $(INN_CHOOSE_FIELD).click();
        return this;
    }

    public BusinessPaymentAccountantPage checkInn() {
        $(INN_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("ИНН некорректный, проверьте правильность написания"));
        return this;
    }

    public BusinessPaymentAccountantPage checkNameOPF(String name, String opf) {
        $(NAME_ORGANIZATION_FIELD).shouldHave(Condition.value(name));
        $(OPF_FIELD).shouldHave(Condition.value(opf));
        return this;
    }

    public BusinessPaymentAccountantPage allowConditions() {
        $(ALLOW_CONDITIONS).lastChild().click();
        return this;
    }

    public BusinessPaymentAccountantPage checkAllow() {
        $(ALLOW_CONDITIONS_CAPTION).shouldHave(Condition.text("Для обработки вашей заявки вы должны согласиться с условиями обработки персональных данных"));
        return this;
    }

    public BusinessPaymentAccountantPage inputData(String data) {
        $(DATA_FIELD).click();
        $(DATA_FIELD).sendKeys(Keys.CONTROL + "a");
        $(DATA_FIELD).sendKeys(Keys.BACK_SPACE);
        $(DATA_FIELD).setValue(data);
        $(BUTTON_SEND_REQUEST).click();
        return this;
    }

    public BusinessPaymentAccountantPage checkCaptionData1() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Используйте только кириллицу"));
        return this;
    }

    public BusinessPaymentAccountantPage checkCaptionData2() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Фамилия и имя обязательны для заполнения"));
        return this;
    }

    public BusinessPaymentAccountantPage checkCaptionData3() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Максимальная длина фамилии 50 символов"));
        return this;
    }

    public BusinessPaymentAccountantPage checkCaptionData4() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Максимальная длина имени 50 символов"));
        return this;
    }

    public BusinessPaymentAccountantPage checkCaptionData5() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Максимальная длина отчества 50 символов"));
        return this;
    }

    public BusinessPaymentAccountantPage checkConfirmPhone() {
        $(CONFIRM_NUMBER).shouldHave(Condition.text("Подтвердите номер телефона"));
        return this;
    }

    public BusinessPaymentAccountantPage inputPhoneCode(int num1, int num2, int num3, int num4) {
        $(PHONE_CODE_1).shouldBe(Condition.visible).setValue(String.valueOf(num1));
        $(PHONE_CODE_2).setValue(String.valueOf(num2));
        $(PHONE_CODE_3).setValue(String.valueOf(num3));
        $(PHONE_CODE_4).setValue(String.valueOf(num4));
        return this;
    }

    public BusinessPaymentAccountantPage checkFalseCode() {
        $(FALSE_CODE).shouldHave(Condition.text("Неправильный код"));
        return this;
    }


}
