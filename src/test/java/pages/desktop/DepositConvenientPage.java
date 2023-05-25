package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class DepositConvenientPage {
    private final static By SUM_DEPOSIT_FIELD = By.xpath("//div[@ label='Сумма вклада']/input");

    private final static By TIME_DEPOSIT_FIELD = By.xpath("//div[@ label='Срок вклада']/input");

    private final static By MONTH_PERCENT = By.xpath("//div[text()= 'Хочу ежемесячно капитализировать проценты']");

    private final static By CHECK_PROFIT_END_VALUE = By.xpath("//div[contains(text(), 'Сумма в конце срока')]/following-sibling::h2");

    private final static By CHECK_PROFIT_VALUE = By.xpath("//div[contains(text(), 'Доход по вкладу')]/following-sibling::h3");

    private final static By CHECK_STAVKA_VALUE = By.xpath("//div[contains(text(), 'Ставка')]/following-sibling::h3");

    private final static By BUTTON_ARRANGE_ONLINE = By.xpath("//div[contains(text(), 'Ставка')]/following-sibling::h3");

    private final static By BUTTON_SEND = By.xpath("//div [text() = 'Отправить']");

    private final static By CAPTION_DATA = By.xpath("//div [label='Фамилия, имя и отчество']");

    private final static By CAPTION_PHONE = By.xpath("//div [label='Мобильный телефон']");

    private final static By CAPTION_CITY = By.xpath("//div [label='Город']");

    private final static By CAPTION_OFFICE = By.xpath("//div [label='Офис']");

    private final static By DATA_FIELD = By.xpath("//textarea [@ placeholder='Иванов Иван Иванович']");

    private final static By PHONE_FIELD = By.xpath("//input[@ placeholder='+7 000 000-00-00']");

    private final static By CITY_FIELD = By.xpath("//input[@ placeholder='Выберите город']");

    private final static By CITY_CHOOSE = By.xpath("//div[text()='Амурск']");

    private final static By OFFICE_FIELD = By.xpath("//input[@ placeholder='Выберите офис']");

    private final static By OFFICE_CHOOSE = By.xpath("//div[text()='Дополнительный офис № 25']");

    private final static By APPLY_REQUEST = By.xpath("//div[@ id='depositForm']/h3");

    @Step("Выставить в поля нужны данные по депозиту:{0}")
    public DepositConvenientPage setupDeposit(String time, String sum) {
        $(SUM_DEPOSIT_FIELD).scrollIntoView(true).click();
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).setValue(time);
        $(SUM_DEPOSIT_FIELD).sendKeys(Keys.CONTROL + "a");
        $(SUM_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(SUM_DEPOSIT_FIELD).setValue(sum);
        $(MONTH_PERCENT).parent().parent().parent().click();
        return this;
    }

    @Step("Проверяем \"Ставку\", \"Доход по вкладу\", \"Сумма в конце срока\"")
    public DepositConvenientPage checkDepositValues(String stavka, String profit, String profitEnd) {
        $(CHECK_STAVKA_VALUE).shouldHave(Condition.text(stavka));
        $(CHECK_PROFIT_VALUE).shouldHave(Condition.text(profit));
        $(CHECK_PROFIT_END_VALUE).shouldHave(Condition.text(profitEnd));
        return this;
    }

    @Step("Нажимаем кнопку \"Оформить онлайн\"")
    public DepositConvenientPage clickArrange() {
        $(BUTTON_ARRANGE_ONLINE).parent().parent().parent().click();
        return this;
    }

    @Step("Нажимаем кнопку \"Отправить\"")
    public DepositConvenientPage clickSend() {
        $(BUTTON_SEND).parent().parent().parent().scrollIntoView(false).click();
        return this;
    }

    @Step("Проверяем, что под полями есть надписи \"Укажите фамилию, имя и отчество контактного лица\",\"Введите верный номер телефона\",\"Выберите ваш населенный пункт\", \"Выберите офис\"")
    public DepositConvenientPage checkCaptions(String nameCaption, String phoneCaption, String cityCaption, String officeCaption) {
        $(CAPTION_DATA).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(nameCaption));
        $(CAPTION_PHONE).parent().parent().lastChild().shouldHave(Condition.text(phoneCaption));
        $(CAPTION_CITY).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(cityCaption));
        $(CAPTION_OFFICE).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(officeCaption));
        return this;
    }

    @Step("Вводим в поле \"ФИО\" {0}")
    public DepositConvenientPage inputData(String data) {
        $(DATA_FIELD).click();
        $(DATA_FIELD).sendKeys(Keys.CONTROL + "a");
        $(DATA_FIELD).sendKeys(Keys.BACK_SPACE);
        $(DATA_FIELD).setValue(data);
        $(BUTTON_SEND).scrollTo().click();
        return this;
    }

    @Step("Проверяем надпись под полем \"Используйте только кириллицу\"")
    public DepositConvenientPage checkInputFalseData(String dataCaption) {
        $(CAPTION_DATA).parent().parent().parent().parent().lastChild().shouldHave(Condition.text(dataCaption));
        return this;
    }

    @Step("Вводим в поле \"Мобильный телефон\" {0}")
    public DepositConvenientPage inputPhone(int phone) {
        $(PHONE_FIELD).click();
        $(PHONE_FIELD).sendKeys(Keys.CONTROL + "a");
        $(PHONE_FIELD).sendKeys(Keys.BACK_SPACE);
        $(PHONE_FIELD).setValue(String.valueOf(phone));
        $(BUTTON_SEND).click();
        return this;
    }

    @Step("Проверяем надпись под полем \"Мобильный телефон\"")
    public DepositConvenientPage checkPhone(String phoneCaption) {
        $(CAPTION_PHONE).parent().parent().lastChild().shouldHave(Condition.text(phoneCaption));
        return this;
    }

    @Step("Выбираем город")
    public DepositConvenientPage chooseCity() {
        $(CITY_FIELD).click();
        $(CITY_CHOOSE).click();
        return this;
    }

    @Step("Выбираем офис")
    public DepositConvenientPage chooseOffice() {
        $(OFFICE_FIELD).click();
        $(OFFICE_CHOOSE).click();
        return this;
    }

    @Step("Проверить окошко с заголовком \"Заявка принята\"")
    public DepositConvenientPage checkApply(String applyCaption) {
        $(APPLY_REQUEST).shouldHave(Condition.text(applyCaption));
        return this;
    }
}
