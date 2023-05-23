package tests.mobile;

import org.junit.jupiter.api.Test;
import pages.mobile.MobileCodePage;
import pages.mobile.MobileEnterPage;
import pages.mobile.MobileHomeBankPage;

import java.util.Random;

public class MobileSecondTest extends BaseMobileTest{
    MobileHomeBankPage mobileHomeBankPage = new MobileHomeBankPage();
    MobileEnterPage mobileEnterPage = new MobileEnterPage();
    MobileCodePage mobileCodePage = new MobileCodePage();

    private final static long testPhone1 = 1L;
    private final static long testPhone2 = 1111111111L;

    private final Random random = new Random();
    private final static long truePhone = 9999999999L;

    private final static int maxC = 9999;
    private final static int minC = 1111;
    int code = random.nextInt(maxC - minC) + minC;

    @Test
    public void cardMtsCashBack() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .clickEnter();

        mobileEnterPage.inputPhoneField(testPhone1)
                .checkTruePhoneField1()
                .inputPhoneField(testPhone2)
                .checkTruePhoneField2()
                .inputPhoneField(truePhone);

        mobileCodePage.inputCodeField(code)
                .checkTrueCode();
    }

}
