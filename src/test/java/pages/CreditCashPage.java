package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

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

    public CreditCashPage clickButtonNext() {
        $(BUTTON_NEXT).click();
        return this;
    }

    public CreditCashPage checkCaptions(){
        $(GOAL_CAPTION).parent().lastChild().shouldHave(Condition.text("Это поле обязательно для заполнения"));
        $(DATA_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Введите ФИО полностью"));
        $(BIRTHDAY_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        $(PHONE_CAPTION).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        return this;
    }

    public CreditCashPage goalCredit(){
        $(GOAL_DROPDOWN).click();
        $(GOAL_CAR).click();
        return this;
    }

//    public CreditCashPage inputData(String data){
//
//    }

//    public CreditCashPage inputRandomValuesSumTime() {
//        $(BUTTON_ARRANGE_ONLINE).click();
//        return this;
//    }


}
