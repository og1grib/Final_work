package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class ConvenientDepositPage {
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

    public ConvenientDepositPage setupDeposit() {
        $(SUM_DEPOSIT_FIELD).scrollIntoView(true).click();
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).setValue("18");
        $(SUM_DEPOSIT_FIELD).sendKeys(Keys.CONTROL + "a");
        $(SUM_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(SUM_DEPOSIT_FIELD).setValue("50000000");
        $(MONTH_PERCENT).parent().parent().parent().click();
        return this;
    }

    public ConvenientDepositPage checkDepositValues(String stavka,String profit,String profitEnd){
        $(CHECK_STAVKA_VALUE).shouldHave(Condition.text(stavka));
        $(CHECK_PROFIT_VALUE).shouldHave(Condition.text(profit));
        $(CHECK_PROFIT_END_VALUE).shouldHave(Condition.text(profitEnd));
        return this;
    }

    public ConvenientDepositPage clickArrange(){
        $(BUTTON_ARRANGE_ONLINE).parent().parent().parent().click();
        return this;
    }

    public ConvenientDepositPage clickSend(){
        $(BUTTON_SEND).parent().parent().parent().scrollIntoView(false).click();
        return this;
    }

    public ConvenientDepositPage checkCaptions(){
        $(CAPTION_DATA).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Укажите фамилию, имя и отчество контактного лица"));
        $(CAPTION_PHONE).parent().parent().lastChild().shouldHave(Condition.text("Введите верный номер телефона"));
        $(CAPTION_CITY).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Выберите ваш населенный пункт"));
        $(CAPTION_OFFICE).parent().parent().parent().parent().lastChild().shouldHave(Condition.text("Выберите офис"));
        return this;
    }

    public ConvenientDepositPage checkInputFalseData(){
        $(CAPTION_DATA).shouldHave(Condition.text("Используйте только кириллицу"));
        return this;
    }

    public ConvenientDepositPage inputData(String value){
        $(DATA_FIELD).setValue(value);
        return this;
    }

}
