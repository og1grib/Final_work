package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.mobile.MobileHomeBankPage;

import java.util.Random;

@DisplayName("Поверка мобильного сценария: оформление карты MTS CASHBACK")
public class MobileFirstTest extends BaseMobileTest {
    MobileHomeBankPage mobileHomeBankPage = new MobileHomeBankPage();
    private final Random random = new Random();

    private final static int testPhone = 1;
    private final static int testData = 0;
    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    int truePhone = random.nextInt(maxP - minP) + minP;

    int maxD = 1999999999;
    int minD = 1000000000;
    int trueData = random.nextInt(maxD - minD) + minD;

    private final static int maxC = 9;
    private final static int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;

    private final static String necessarilyCaption = "Обязательное поле";
    private final static String phoneCaption = "Введите верные цифры";
    private final static String dataCaption = "Введите верные серию и номер паспорта";
    private final static String codeFalse = "Неправильный код";

    @DisplayName("Отправка заявки с пустыми полями")
    @Test
    public void cardMtsCashBackEmpty() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .clickButtonCheckLimit()
                .checkNecessarilyFields(necessarilyCaption);
    }

    @DisplayName("Отправка заявки с вводом в поля по одной цифре")
    @Test
    public void cardMtsCashBackFalseData() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .inputPhoneField(testPhone)
                .checkTruePhoneField(phoneCaption)
                .inputDataField(testData)
                .checkTrueDataField(dataCaption);
    }

    @DisplayName("Ввод кода, Отправка заявки с вводом в поля рандомных цифр в поле дата и телефон")
    @Test
    public void cardMtsCashBackTrue() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .inputPhoneField(truePhone)
                .inputDataField(trueData)
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode(codeFalse);
    }
}
