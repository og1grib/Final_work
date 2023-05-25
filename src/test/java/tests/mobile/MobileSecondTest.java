package tests.mobile;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.mobile.MobileCodePage;
import pages.mobile.MobileEnterPage;
import pages.mobile.MobileHomeBankPage;

import java.util.Random;

@DisplayName("Поверка мобильного сценария: вход в личный кабинет")
public class MobileSecondTest extends BaseMobileTest {
    MobileHomeBankPage mobileHomeBankPage = new MobileHomeBankPage();
    MobileEnterPage mobileEnterPage = new MobileEnterPage();
    MobileCodePage mobileCodePage = new MobileCodePage();
    private final Random random = new Random();

    private final static long testPhone1 = 1L;
    private final static long testPhone2 = 1111111111L;

    private final static long truePhone = 9999999998L;

    private final static int maxCode = 9999;
    private final static int minCode = 1111;
    int code = random.nextInt(maxCode - minCode) + minCode;

    private final static String phoneCaption1 = "Номер телефона должен содержать 10 цифр, например, +7 912 345-67-89";
    private final static String phoneCaption2 = "Неправильный номер телефона";
    private final static String codeFalse = "Неверный код.";

    @DisplayName("Ввод одной цифры в поле телефона")
    @Test
    public void cardInputOneNumberPhone() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .clickEnter();

        mobileEnterPage.inputPhoneField(testPhone1)
                .checkTruePhoneField(phoneCaption1);
    }

    @DisplayName("Ввод в поле телефона неправильного номера - все единицы")
    @Test
    public void cardInputFalsePhone() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .clickEnter();

        mobileEnterPage.inputPhoneField(testPhone2)
                .checkTruePhoneField(phoneCaption2);
    }

    @DisplayName("Ввод кода, Отправка заявки с вводом правильного телефона - все девятки")
    @Test
    public void cardInput() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .clickEnter();

        mobileEnterPage.inputPhoneField(truePhone);

        mobileCodePage.inputCodeField(code)
                .checkTrueCode(codeFalse);
    }
}
