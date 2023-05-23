package tests.desktop;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.desktop.HomeBankPage;

import java.util.Random;

public class FirstTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();

    private final static int testPhone = 1;
    private final static int testData = 0;

    private final Random random = new Random();

    int maxD = 1999999999;
    int minD = 1000000000;
    int trueData = random.nextInt(maxD - minD) + minD;

    private final static int maxC = 9;
    private final static int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;

    @ParameterizedTest
    @ValueSource(strings = {"1999999999", "1000000000"})
    public void cardMtsCashback(String phone) {
        homeBankPage.openHomeBankPage()
                .clickButtonCheckLimit()
                .checkNecessarilyFields()
                .inputPhoneField(testPhone)
                .checkTruePhoneField()
                .inputDataField(testData)
                .checkTrueDataField()
                .inputPhoneField(Integer.parseInt(phone))
                .inputDataField(trueData)
                .checkCodeField()
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode();
    }

}
