package pages.desktop;

import com.codeborne.selenide.Condition;
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

    public DepositsPage inputSumDeposit(String sum) {
        $(SUM_DEPOSIT_FIELD).click();
        $(SUM_DEPOSIT_FIELD).setValue(sum);
        return this;
    }

    public DepositsPage checkSumDeposit1() {
        $(FREE_PLACE).click();
        $(SUM_DEPOSIT_FIELD).shouldHave(Condition.value("1 000 ₽"));
        return this;
    }

    public DepositsPage checkSumDeposit2() {
        $(FREE_PLACE).click();
        $(SUM_DEPOSIT_FIELD).shouldHave(Condition.value("50 000 000 ₽"));
        return this;
    }

    public DepositsPage inputTimeDeposit(String time) {
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).setValue(time);
        return this;
    }

    public DepositsPage checkTimeDeposit1() {
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("36 месяцев"));
        return this;
    }

    public DepositsPage checkTimeDeposit2() {
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("3 месяца"));
        return this;
    }

    public DepositsPage checkTimeDeposit3() {
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("24 месяца"));
        return this;
    }

    public DepositsPage inputTimeDepositTrue() {
        $(TIME_NEED_DEPOSIT_FIELD).click();
        return this;
    }

    public DepositsPage checkTimeDeposit4() {
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("18 месяцев"));
        return this;
    }

    public DepositsPage wantFillAndOpenOnline() {
        $(WANT_FILL).parent().parent().parent().click();
        $(OPEN_ONLINE).parent().parent().parent().click();
        return this;
    }

    public DepositsPage openDeposit() {
        $(BUTTON_OPEN).click();
        return this;
    }

    public String checkStavka() {
        return $(STAVKA_VALUE).text();
    }

    public String checkProfit() {
        return $(PROFIT_VALUE).text();
    }

    public String checkProfitEnd() {
        return $(PROFIT_END_VALUE).text();
    }

}
