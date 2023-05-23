package pages.desktop;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class IpotekaAcreditBuilders {
    private final static By BUILDER_FIELD = By.xpath("//input[@ placeholder='Выберите из списка']");
    private final static By BUILDER_PIK = By.xpath("//li [@ id='react-autowhatever-1--item-2']");
    private final static By BUTTON_NEXT = By.xpath("//div[text() = 'Продолжить']");
    private final static By DATA_CAPTION = By.xpath("//div[@ label='Фамилия, имя и отчество']");
    private final static By BIRTHDAY_CAPTION = By.xpath("//div[@ label='Дата рождения']");
    private final static By PHONE_CAPTION = By.xpath("//div[@ label='Мобильный телефон']");
    private final static By EMAIL_CAPTION = By.xpath("//div[@ label='Электронная почта']");
    private final static By CITY_CAPTION = By.xpath("//div[@ label='Город приобретаемой недвижимости']");
    private final static By DATA_FIELD = By.xpath("//textarea[@ placeholder='Иванов Иван Иванович']");
    private final static By BIRTHDAY_FIELD = By.xpath("//input[@ placeholder='дд.мм.гггг']");
    private final static By PHONE_FIELD = By.xpath("//input[@ placeholder='+7 000 000-00-00']");
    private final static By EMAIL_FIELD = By.xpath("//input[@ placeholder='mail@example.ru']");
    private final static By CITY_FIELD = By.xpath("//input[@ placeholder='Введите город / регион']");
    private final static By ALLOW_CONDITIONS = By.xpath("//div[@ class='CheckItem-sc-cb89gg-3 cboCgp']|//div[@ class='CheckItem-sc-cb89gg-3 fJkfwj']");
    private final static By FAMILY_WITH_CHILD = By.xpath("//div[text()='Для семей с детьми']");
    private final static By SUM_FLAT_FIELD = By.xpath("//div[@ label='Стоимость недвижимости']/input");
    private final static By SUM_DUE_FIELD = By.xpath("//div[@ label='Первоначальный взнос']/input");
    private final static By TIME_FIELD = By.xpath("//div[@ label='Срок кредита']/input");
    private final static By FREE_PLACE = By.xpath("//h4[text()='Параметры кредита']");
    private final static By CHOOSE_CITY = By.xpath("//li [@ id='react-autowhatever-1--item-0']");
    private final static By CONFIRM_NUMBER = By.xpath("//h3[@ class='Wrapper-sc-6nwvzq-0 eoxkCl']");
    private final static By PHONE_CODE_1 = By.xpath("//input[@ autocomplete='one-time-code'][1]");
    private final static By PHONE_CODE_2 = By.xpath("//input[@ autocomplete='one-time-code'][2]");
    private final static By PHONE_CODE_3 = By.xpath("//input[@ autocomplete='one-time-code'][3]");
    private final static By PHONE_CODE_4 = By.xpath("//input[@ autocomplete='one-time-code'][4]");
    private final static By FALSE_CODE = By.xpath("//div [text() = 'Неправильный код']");


    public IpotekaAcreditBuilders choseBuilder() {
        $(BUILDER_FIELD).click();
        $(BUILDER_PIK).shouldBe(Condition.visible).click();
        return this;
    }

    public IpotekaAcreditBuilders clickNext() {
        $(BUTTON_NEXT).scrollIntoView(false).click();
        return this;
    }

    public IpotekaAcreditBuilders checkCaptions(){
        $(DATA_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Пожалуйста, укажите дату рождения"));
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный номер телефона"));
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        $(CITY_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        return this;
    }

    public IpotekaAcreditBuilders inputData(String data) {
        $(DATA_FIELD).clear();
        $(DATA_FIELD).setValue(data);
        $(BUTTON_NEXT).click();
        return this;
    }

    public IpotekaAcreditBuilders checkCaptionData1() {
        $(DATA_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Используйте только кириллицу"));
        return this;
    }

    public IpotekaAcreditBuilders checkCaptionData2() {
        $(DATA_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Пожалуйста, укажите ФИО целиком"));
        return this;
    }

    public IpotekaAcreditBuilders inputBirthday(String birthday) {
        $(BIRTHDAY_FIELD).sendKeys(Keys.CONTROL + "a");
        $(BIRTHDAY_FIELD).sendKeys(Keys.BACK_SPACE);
        $(BIRTHDAY_FIELD).setValue(birthday);
        $(BUTTON_NEXT).click();
        return this;
    }

    public IpotekaAcreditBuilders checkBirthday1() {
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Возраст клиента должен быть не более 65 лет на дату окончания ипотечного кредитования"));
        return this;
    }

    public IpotekaAcreditBuilders checkBirthday2() {
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Введите корректную дату"));
        return this;
    }

    public IpotekaAcreditBuilders checkBirthday3() {
        $(BIRTHDAY_CAPTION).parent().parent().parent().lastChild().shouldHave(Condition.text("Возраст клиента должен быть не менее 18 лет"));
        return this;
    }

    public IpotekaAcreditBuilders inputPhone(int phone) {
        $(PHONE_FIELD).click();
        $(PHONE_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_NEXT).click();
        return this;
    }

    public IpotekaAcreditBuilders checkPhone() {
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный номер телефона"));
        return this;
    }

    public IpotekaAcreditBuilders inputEmail(String email) {
        $(EMAIL_FIELD).click();
        $(EMAIL_FIELD).sendKeys(Keys.CONTROL + "a");
        $(EMAIL_FIELD).sendKeys(Keys.BACK_SPACE);
        $(EMAIL_FIELD).setValue(String.valueOf(email));
        $(BUTTON_NEXT).click();
        return this;
    }

    public IpotekaAcreditBuilders checkEmail() {
        $(EMAIL_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите верный электронный адрес"));
        return this;
    }

    public IpotekaAcreditBuilders inputCity1(String city) {
        $(CITY_FIELD).click();
        $(CITY_FIELD).setValue(city);
        $(BUTTON_NEXT).click();
        return this;
    }
    public IpotekaAcreditBuilders inputCity2(String city) {
        $(CITY_FIELD).click();
        $(CITY_FIELD).sendKeys(Keys.CONTROL + "a");
        $(CITY_FIELD).sendKeys(Keys.BACK_SPACE);
        $(CITY_FIELD).setValue(city);
        $(CHOOSE_CITY).click();
        $(BUTTON_NEXT).click();
        return this;
    }

    public IpotekaAcreditBuilders checkCity() {
        $(CITY_CAPTION).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Выберите из списка"));
        return this;
    }

    public IpotekaAcreditBuilders allowConditions() {
        $(ALLOW_CONDITIONS).lastChild().click();
        return this;
    }

    public IpotekaAcreditBuilders checkAllow() {
        $(ALLOW_CONDITIONS).parent().parent().parent().lastChild().shouldHave(Condition.text("Для подачи заявки необходимо ознакомиться с условиями и дать согласие"));
        return this;
    }

    public IpotekaAcreditBuilders clickFamilyWithChild() {
        $(FAMILY_WITH_CHILD).click();
        return this;
    }

    public IpotekaAcreditBuilders inputSumFlat(String sum) {
        $(SUM_FLAT_FIELD).click();
        $(SUM_FLAT_FIELD).setValue(sum);
        return this;
    }

    public IpotekaAcreditBuilders checkSumFlat1() {
        $(FREE_PLACE).click();
        $(SUM_FLAT_FIELD).shouldHave(Condition.value("1 200 000 ₽"));
        return this;
    }

    public IpotekaAcreditBuilders checkSumFlat2() {
        $(FREE_PLACE).click();
        $(SUM_FLAT_FIELD).shouldHave(Condition.value("100 000 000 ₽"));
        return this;
    }

    public IpotekaAcreditBuilders inputSumDue(String sum) {
        $(SUM_DUE_FIELD).click();
        $(SUM_DUE_FIELD).setValue(sum);
        return this;
    }

    public IpotekaAcreditBuilders checkSumDue1() {
        $(FREE_PLACE).click();
        $(SUM_DUE_FIELD).shouldHave(Condition.value("88 000 000 ₽"));
        return this;
    }

    public IpotekaAcreditBuilders checkSumDue2() {
        $(FREE_PLACE).click();
        $(SUM_DUE_FIELD).shouldHave(Condition.value("99 000 000 ₽"));
        return this;
    }

    public IpotekaAcreditBuilders inputTime(String time) {
        $(TIME_FIELD).click();
        $(TIME_FIELD).setValue(time);
        return this;
    }

    public IpotekaAcreditBuilders checkTime1() {
        $(FREE_PLACE).click();
        $(TIME_FIELD).shouldHave(Condition.value("3 года"));
        return this;
    }

    public IpotekaAcreditBuilders checkTime2() {
        $(FREE_PLACE).click();
        $(TIME_FIELD).shouldHave(Condition.value("30 лет"));
        return this;
    }

    public IpotekaAcreditBuilders checkConfirmPhone() {
        $(CONFIRM_NUMBER).shouldHave(Condition.text("Подтвердите номер телефона"));
        return this;
    }

    public IpotekaAcreditBuilders inputPhoneCode(int num1, int num2, int num3, int num4) {
        $(PHONE_CODE_1).shouldBe(Condition.visible).setValue(String.valueOf(num1));
        $(PHONE_CODE_2).setValue(String.valueOf(num2));
        $(PHONE_CODE_3).setValue(String.valueOf(num3));
        $(PHONE_CODE_4).setValue(String.valueOf(num4));
        return this;
    }

    public IpotekaAcreditBuilders checkFalseCode() {
        $(FALSE_CODE).shouldHave(Condition.text("Неправильный код"));
        return this;
    }

}
