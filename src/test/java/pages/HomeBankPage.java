package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static tests.BaseTest.config;
public class HomeBankPage {
    private final static By PHONE_FIELD = By.xpath("//div[@ label='Номер телефона']");

    private final static By PHONE_INPUT_FIELD = By.xpath("//input [@ type='tel']");

    private final static By DATE_FIELD = By.xpath("//div[@ label='Серия и номер паспорта']");

    private final static By DATE_INPUT_FIELD = By.xpath("//input [@ type='text']");

    private final static By BUTTON_CHECK_LIMIT = By.xpath("//button [@ class='Wrapper-sc-48arcs-1 jcQarO styled__FormButton-hl0ql7-1 dzPHqK']");

    private final static By CODE_FIELD = By.xpath("//input[@ inputmode='numeric']");

    private final static By CODE_FIELD_LABEL = By.xpath("//div[@ data-testid='confirmationField']/div[@ data-testid='text']");

    private final static By FALSE_CODE = By.xpath("//div [@ class='Wrapper-sc-1vydk7-0 OlnRe']");

    private final static By DEPOSITS_AND_ACCOUNTS = By.xpath("//a[@ href='/chastnim-licam/vkladi/']");

    private final static By CREDIT = By.xpath("//a[@ href='/chastnim-licam/krediti/']");

    private final Random random = new Random();
    public HomeBankPage openHomeBankPage(){
        Selenide.open(config.baseUrl());
        return this;
    }
    public HomeBankPage clickButtonCheckLimit(){
        $(BUTTON_CHECK_LIMIT).scrollIntoView(false).shouldBe(Condition.visible).click();
        return this;
    }

    public HomeBankPage checkNecessarilyFields(){
        $(PHONE_FIELD).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        $(DATE_FIELD).parent().parent().lastChild().shouldHave(Condition.text("Обязательное поле"));
        return this;
    }

    public HomeBankPage inputPhoneField(){
        $(PHONE_INPUT_FIELD).click();
        $(PHONE_INPUT_FIELD).sendKeys(" ");
        return this;
    }

    public HomeBankPage checkTruePhoneField(){
        $(PHONE_FIELD).parent().parent().lastChild().shouldHave(Condition.text("Введите верные цифры"));
        return this;
    }

    public HomeBankPage inputDataField(){
        $(DATE_INPUT_FIELD).click();
        $(DATE_INPUT_FIELD).sendKeys("0");
        return this;
    }

    public HomeBankPage checkTrueDataField(){
        $(DATE_FIELD).parent().parent().lastChild().shouldHave(Condition.text("Введите верные серию и номер паспорта"));
        return this;
    }

    public HomeBankPage inputRandomPhoneData() {
        $(PHONE_INPUT_FIELD).sendKeys(Keys.BACK_SPACE);
        $(DATE_INPUT_FIELD).sendKeys(Keys.BACK_SPACE);
        int maxP = 1999999999;
        int minP = 1000000000;
        int phone = random.nextInt(maxP - minP) + minP;
        $(PHONE_INPUT_FIELD).sendKeys(String.valueOf(phone));
        int maxD = 1999999999;
        int minD = 1000000000;
        int data = random.nextInt(maxD - minD) + minD;
        $(DATE_INPUT_FIELD).sendKeys(String.valueOf(data));
        return this;
    }

    public HomeBankPage checkCodeField(){
        $(CODE_FIELD_LABEL).shouldHave(Condition.text("Код из СМС"));
        $$(CODE_FIELD).shouldBe(CollectionCondition.size(4));
        return this;
    }

//    public HomeBankPage inputCode(){
//        int max = 0;
//        int min = 9;
//        int code = random.nextInt(max - min) + min;
//        $(CODE_FIELD).click();
//        $(CODE_FIELD).sendKeys(String.valueOf(code));
//        return this;
//    }
//
//    public HomeBankPage checkTrueCode(){
//        $(FALSE_CODE).shouldHave(Condition.text("Неправильный код"));
//        return this;
//    }
    public HomeBankPage clickDepositsAccounts(){
        $(DEPOSITS_AND_ACCOUNTS).click();
        return this;
    }

    public HomeBankPage clickCredit(){
        $(CREDIT).click();
        return this;
    }



}
