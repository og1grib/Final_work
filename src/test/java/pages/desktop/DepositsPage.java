package pages.desktop;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class DepositsPage {
    private final static By SUM_DEPOSIT_FIELD = By.xpath("//div[@ label='Сумма вклада']/input");

    private final static By TIME_DEPOSIT_FIELD = By.xpath("//div[@ label='Срок вклада']/input");

    private final static By TIME_NEED_DEPOSIT_FIELD = By.xpath("//span[text()='18']");

    private final static By WANT_FILL = By.xpath("//div[text()= 'Хочу пополнять']");

    private final static By OPEN_ONLINE = By.xpath("//div[text()= 'Открыть онлайн']");

    private final static By BUTTON_OPEN = By.xpath("//a[@ data-testid='button']");

    private final static By FREE_PLACE = By.xpath("//h1[@ data-testid='heading']");

    private final static By PROFIT_VALUE = By.xpath("//div[contains(text(), 'Доход по вкладу')]/following-sibling::div");

    private final static By PROFIT_END_VALUE = By.xpath("//div[contains(text(), 'Сумма в конце срока')]/following-sibling::div");

    private final static By STAVKA_VALUE = By.xpath("//div[contains(text(), 'Ставка')]/following-sibling::div");

    @Step("Вводим в поле \"Сумма вклада\": {0}")
    public DepositsPage inputSumDeposit(String sum) {
        $(SUM_DEPOSIT_FIELD).click();
        $(SUM_DEPOSIT_FIELD).setValue(sum);
        return this;
    }

    @Step("Проверяем, что в поле \"Сумма вклада\" осталось значение: {0}")
    public DepositsPage checkSumDeposit(String valueSum) {
        $(FREE_PLACE).click();
        $(SUM_DEPOSIT_FIELD).shouldHave(Condition.value(valueSum));
        return this;
    }

    @Step("Вводим в поле \"Срок вклада\": {0}")
    public DepositsPage inputTimeDeposit(String time) {
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.CONTROL + "a");
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).setValue(time);
        return this;
    }

    @Step("Проверяем, что в поле \"Срок вклада\" осталось значение: {0}")
    public DepositsPage checkTimeDeposit(String time) {
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value(time));
        return this;
    }

    @Step("Нажимаем на цифру под полем \"18\"")
    public DepositsPage inputTimeDepositTrue() {
        $(TIME_NEED_DEPOSIT_FIELD).click();
        return this;
    }

    @Step("Нажимаем на \"Хочу пополнять\" и \"Открыть онлайн\"")
    public DepositsPage wantFillAndOpenOnline() {
        $(WANT_FILL).parent().parent().parent().click();
        $(OPEN_ONLINE).parent().parent().parent().click();
        return this;
    }

    @Step("Нажимаем на \"Открыть\"")
    public DepositsPage openDeposit() {
        $(BUTTON_OPEN).click();
        return this;
    }

    @Step("Запомнить значение \"Ставка\"")
    public String checkStavka() {
        return $(STAVKA_VALUE).text();
    }

    @Step("Запомнить значение \"Доход по вкладу\"")
    public String checkProfit() {
        return $(PROFIT_VALUE).text();
    }

    @Step("Запомнить значение \"Сумма в конце срока\"")
    public String checkProfitEnd() {
        return $(PROFIT_END_VALUE).text();
    }

}
