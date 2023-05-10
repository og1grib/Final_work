package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class DepositsPage {
    private final static By SUM_DEPOSIT_FIELD = By.xpath("//div[@ label='Сумма вклада']/input");

    private final static By TIME_DEPOSIT_FIELD = By.xpath("//div[@ label='Срок вклада']/input");

    private final static By TIME_NEED_DEPOSIT_FIELD = By.xpath("//span[text()='18']");

    private final static By SLIDER = By.xpath("//div [@ aria-valuemin='3']");

    private final static By FREE_PLACE = By.xpath("//h1[@ data-testid='heading']");

    public DepositsPage inputSumDeposit1(){
        $(SUM_DEPOSIT_FIELD).click();
        $(SUM_DEPOSIT_FIELD).setValue(" ");
        return this;
    }

    public DepositsPage checkSumDeposit1(){
        $(FREE_PLACE).click();
        $(SUM_DEPOSIT_FIELD).shouldHave(Condition.value("1 000 ₽"));
        return this;
    }

    public DepositsPage inputSumDeposit2(){
        $(SUM_DEPOSIT_FIELD).click();
        $(SUM_DEPOSIT_FIELD).setValue("1000000000000000");
        return this;
    }

    public DepositsPage checkSumDeposit2(){
        $(FREE_PLACE).click();
        $(SUM_DEPOSIT_FIELD).shouldHave(Condition.value("50 000 000 ₽"));
        return this;
    }

    public DepositsPage inputTimeDeposit1(){
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).setValue("1000");
        return this;
    }

    public DepositsPage checkTimeDeposit1(){
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("36 месяцев"));
        return this;
    }

    public DepositsPage inputTimeDeposit2(){
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).setValue(" ");
        return this;
    }

    public DepositsPage checkTimeDeposit2(){
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("3 месяца"));
        return this;
    }

    public DepositsPage inputTimeDeposit3(){
        $(TIME_DEPOSIT_FIELD).click();
        $(TIME_DEPOSIT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(TIME_DEPOSIT_FIELD).setValue("22");
        return this;
    }

    public DepositsPage checkTimeDeposit3(){
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("24 месяца"));
        return this;
    }

    public DepositsPage inputTimeDeposit4(){
        $(SLIDER)
                dragAndDropTo($(TIME_NEED_DEPOSIT_FIELD));
        return this;
    }

    public DepositsPage checkTimeDeposit4(){
        $(FREE_PLACE).click();
        $(TIME_DEPOSIT_FIELD).shouldHave(Condition.value("20 месяцев"));
        return this;
    }
}
