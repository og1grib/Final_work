package tests.mobile;

import org.junit.jupiter.api.Test;
import pages.mobile.MobileHomeBankPage;

import java.util.Random;

public class MobileFirstTest extends BaseMobileTest {
    MobileHomeBankPage mobileHomeBankPage = new MobileHomeBankPage();

    private final static int testPhone = 1;
    private final static int testData = 0;

    private final Random random = new Random();
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

    @Test
    public void cardMtsCashBack() {
        mobileHomeBankPage.openHomeBankPage()
                .clickApplyLocation()
                .clickButtonCheckLimit()
                .checkNecessarilyFields()
                .inputPhoneField(testPhone)
                .checkTruePhoneField()
                .inputDataField(testData)
                .checkTrueDataField()
                .inputPhoneField(truePhone)
                .inputDataField(trueData)
                .checkCodeField()
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode();
    }

}
