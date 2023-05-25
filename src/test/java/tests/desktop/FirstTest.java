package tests.desktop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.desktop.HomeBankPage;

import java.util.Random;

@DisplayName("Поверка сценария: оформление MTS CASHBACK на главной странице")
public class FirstTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    private final Random random = new Random();

    private final static String emptyField = "Обязательное поле";
    private final static String falsePhoneField = "Введите верные цифры";
    private final static String falseDataField = "Введите верные серию и номер паспорта";
    private final static String codeField = "Код из СМС";
    private final static String falseCodeField = "Неправильный код";

    private final static int testPhone = 1;
    private final static int testData = 0;

    int maxD = 1999999999;
    int minD = 1000000000;
    int trueData = random.nextInt(maxD - minD) + minD;

    private final static int maxC = 9;
    private final static int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;

    @DisplayName("Отправка заявки с пустыми полями")
    @Test
    public void cardMtsCashbackEmpty() {
        homeBankPage.openHomeBankPage()
                .clickButtonCheckLimit()
                .checkNecessarilyFields(emptyField);
    }

    @DisplayName("Отправка заявки с вводом в поля по одной цифре")
    @Test
    public void cardMtsCashbackOneNumber() {
        homeBankPage.openHomeBankPage()
                .inputPhoneField(testPhone)
                .checkTruePhoneField(falsePhoneField)
                .inputDataField(testData)
                .clickButtonCheckLimit()
                .checkTrueDataField(falseDataField);
    }

    @DisplayName("Ввод кода, Отправка заявки с вводом в поля рандомных цифр в поле дата и ввода в поле телефон")
    @ParameterizedTest
    @ValueSource(strings = {"1999999999", "1000000000"})
    public void cardMtsCashbackRandom(String phone) {
        homeBankPage.openHomeBankPage()
                .inputPhoneField(Integer.parseInt(phone))
                .inputDataField(trueData)
                .clickButtonCheckLimit()
                .checkCodeField(codeField)
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode(falseCodeField);
    }
}
