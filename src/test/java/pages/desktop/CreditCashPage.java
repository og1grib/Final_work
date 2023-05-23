package pages.desktop;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CreditCashPage {
    private final static By SUMMA_FIELD = By.xpath("//div[@ label='Сумма']/input");
    private final static By TIME_FIELD = By.xpath("//div[@ label='Срок']/input");
    private final static By BUTTON_NEXT = By.xpath("//div[text()='Далее']");
    private final static By GOAL_DROPDOWN = By.xpath("//textarea[@ placeholder='Выберите значение из списка']");
    private final static By GOAL_CAR = By.xpath("//div[text()= 'Автомобиль']");
    private final static By GOAL_CAPTION = By.xpath("//div[@ name='loanPurpose']");
    private final static By DATA_CAPTION = By.xpath("//div[@ role='combobox']");
    private final static By BIRTHDAY_CAPTION = By.xpath("//div[@ label='Дата рождения']");
    private final static By PHONE_CAPTION = By.xpath("//div[@ label='Мобильный телефон']");
    private final static By EMAIL_CAPTION = By.xpath("//div[@ label='Электронная почта']");
    private final static By DATA_FIELD = By.xpath("//textarea[@ placeholder='Иванов Иван Иванович']");
    private final static By BIRTHDAY_FIELD = By.xpath("//input[@ placeholder='дд.мм.гггг']");
    private final static By PHONE_FIELD = By.xpath("//input[@ placeholder='+7 000 000-00-00']");
    private final static By EMAIL_FIELD = By.xpath("//input[@ placeholder='mail@example.ru']");
    private final static By ALLOW_CONDITIONS = By.xpath("//div[@ class='CheckItem-sc-cb89gg-3 cboCgp']|//div[@ class='CheckItem-sc-cb89gg-3 fJkfwj']");
    private final static By SUM_CREDIT_FIELD = By.xpath("//div[@ label='Сумма']/input");
    private final static By TIME_CREDIT_FIELD = By.xpath("//div[@ label='Срок']/input");
    private final static By FREE_PLACE = By.xpath("//div[@ data-testid='headerInProgressBar']");
    private final static By CONFIRM_NUMBER = By.xpath("//h4 [@ class='Wrapper-sc-6nwvzq-0 kRJvZg styled__Subheading-sc-zm4dzw-0 hbJSLI']");
    private final static By PHONE_CODE_1 = By.xpath("//input[@ autocomplete='one-time-code'][1]");
    private final static By PHONE_CODE_2 = By.xpath("//input[@ autocomplete='one-time-code'][2]");
    private final static By PHONE_CODE_3 = By.xpath("//input[@ autocomplete='one-time-code'][3]");
    private final static By PHONE_CODE_4 = By.xpath("//input[@ autocomplete='one-time-code'][4]");
    private final static By FALSE_CODE = By.xpath("//div [text() = 'Неправильный код']");

    public CreditCashPage clickButtonNext() {
        $(BUTTON_NEXT).scrollIntoView(false).click();
        return this;
    }

    public CreditCashPage checkCaptions() {
        $(GOAL_CAPTION).parent().lastChild().shouldHave(Condition.text("Это поле обязательно для заполнения"));
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите ФИО полностью"));
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        return this;
    }

    public CreditCashPage goalCredit() {
        $(GOAL_DROPDOWN).click();
        $(GOAL_CAR).click();
        return this;
    }

    public CreditCashPage inputData(String data) {
        $(DATA_FIELD).clear();
        $(DATA_FIELD).setValue(data);
        $(BUTTON_NEXT).click();
        return this;
    }

    public CreditCashPage checkCaptionData1() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Используйте только кириллицу"));
        return this;
    }

    public CreditCashPage checkCaptionData2() {
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Не более 255 символов"));
        return this;
    }

    public CreditCashPage inputBirthday(String birthday) {
        $(BIRTHDAY_FIELD).sendKeys(Keys.CONTROL + "a");
        $(BIRTHDAY_FIELD).sendKeys(Keys.BACK_SPACE);
        $(BIRTHDAY_FIELD).setValue(birthday);
        $(BUTTON_NEXT).click();
        return this;
    }

    public CreditCashPage checkBirthday1() {
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Возраст клиента должен быть не более 70 лет"));
        return this;
    }

    public CreditCashPage checkBirthday2() {
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Возраст клиента должен быть не менее 20 лет"));
        return this;
    }

    public CreditCashPage inputPhone(int phone) {
        $(PHONE_FIELD).click();
        $(PHONE_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_NEXT).click();
        return this;
    }

    public CreditCashPage checkPhone() {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный номер телефона"));
        return this;
    }

    public CreditCashPage inputEmail(String email) {
        $(EMAIL_FIELD).click();
        $(EMAIL_FIELD).sendKeys(Keys.CONTROL + "a");
        $(EMAIL_FIELD).sendKeys(Keys.BACK_SPACE);
        $(EMAIL_FIELD).setValue(String.valueOf(email));
        $(BUTTON_NEXT).click();
        return this;
    }

    public CreditCashPage checkEmail() {
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный электронный адрес"));
        return this;
    }

    public CreditCashPage allowConditions() {
        $(ALLOW_CONDITIONS).lastChild().click();
        return this;
    }

    public CreditCashPage checkAllow() {
        $(ALLOW_CONDITIONS).parent().parent().parent().lastChild().shouldHave(Condition.text("Для подачи заявки необходимо дать согласие на этот пункт"));
        return this;
    }

    public CreditCashPage inputSumCredit(String sum) {
        $(SUM_CREDIT_FIELD).click();
        $(SUM_CREDIT_FIELD).setValue(sum);
        return this;
    }

    public CreditCashPage checkSumCredit1() {
        $(FREE_PLACE).click();
        $(SUM_CREDIT_FIELD).shouldHave(Condition.value("20 000 ₽"));
        return this;
    }

    public CreditCashPage checkSumCredit2() {
        $(FREE_PLACE).click();
        $(SUM_CREDIT_FIELD).shouldHave(Condition.value("5 000 000 ₽"));
        return this;
    }

    public CreditCashPage inputTimeCredit(String time) {
        $(TIME_CREDIT_FIELD).click();
        $(TIME_CREDIT_FIELD).setValue(time);
        return this;
    }

    public CreditCashPage checkTimeCredit1() {
        $(FREE_PLACE).click();
        $(TIME_CREDIT_FIELD).shouldHave(Condition.value("12 месяцев"));
        return this;
    }

    public CreditCashPage checkTimeDeposit2() {
        $(FREE_PLACE).click();
        $(TIME_CREDIT_FIELD).shouldHave(Condition.value("60 месяцев"));
        return this;
    }

    public CreditCashPage checkConfirmPhone() {
        $(CONFIRM_NUMBER).shouldHave(Condition.text("Подтвердите номер телефона"));
        return this;
    }

    public CreditCashPage inputPhoneCode(int num1, int num2, int num3, int num4) {
        $(PHONE_CODE_1).shouldBe(Condition.visible).setValue(String.valueOf(num1));
        $(PHONE_CODE_2).setValue(String.valueOf(num2));
        $(PHONE_CODE_3).setValue(String.valueOf(num3));
        $(PHONE_CODE_4).setValue(String.valueOf(num4));
        return this;
    }

    public CreditCashPage checkFalseCode() {
        $(FALSE_CODE).shouldHave(Condition.text("Неправильный код"));
        return this;
    }
}
