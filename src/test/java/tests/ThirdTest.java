package tests;

import org.junit.Test;
import pages.CreditCashPage;
import pages.CreditPage;
import pages.HomeBankPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ThirdTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    CreditPage creditPage = new CreditPage();
    CreditCashPage creditCashPage = new CreditCashPage();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    static LocalDate oldDate = LocalDate.now().minusYears(80);
    static LocalDate youngDate = LocalDate.now().minusYears(2);
    static LocalDate trueDate = LocalDate.now().minusYears(20);
    String oldDateString = oldDate.format(formatter);
    String youngDateString = youngDate.format(formatter);
    String trueDateString = trueDate.format(formatter);

    private final static String testData1 = ".";
    private final static String testData2 = "0";
    private final static String testData3 = "Petr Petrov";
    private final static String testData4 = "Ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа бббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббббб";
    private final static String trueData = "Иван Иванов";

    private final Random random = new Random();
    int maxP = 1999999999;
    int minP = 1000000000;
    int phoneTest=1;
    int phoneTrue = random.nextInt(maxP - minP) + minP;

    private final static String testEmail = "0";
    private final static String trueEmail = "/@м.р";

    private final static String testSum1 = " ";
    private final static String testSum2 = "100000000000";

    private final static String testTime1 = " ";
    private final static String testTime2 = "100";

    int maxC = 9;
    int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;
    @Test
    public void credit() {
        homeBankPage.openHomeBankPage()
                .clickCredit();

        creditPage.clickArrange();

        creditCashPage.clickButtonNext()
                .checkCaptions()
                .goalCredit()
                .inputData(testData1)
                .checkCaptionData1()
                .inputData(testData2)
                .checkCaptionData1()
                .inputData(testData3)
                .checkCaptionData1()
                .inputData(testData4)
                .checkCaptionData2()
                .inputData(trueData)
                .inputBirthday(oldDateString)
                .checkBirthday1()
                .inputBirthday(youngDateString)
                .checkBirthday2()
                .inputBirthday(trueDateString)
                .inputEmail(testEmail)
                .checkEmail()
                .inputEmail(trueEmail)
                .allowConditions()
                .checkAllow()
                .allowConditions()
                .inputSumCredit(testSum1)
                .checkSumCredit1()
                .inputSumCredit(testSum2)
                .checkSumCredit2()
                .inputTimeCredit(testTime1)
                .checkTimeCredit1()
                .inputTimeCredit(testTime2)
                .checkTimeDeposit2()
                .inputPhone(phoneTest)
                .checkPhone()
                .inputPhone(phoneTrue)
                .checkConfirmPhone()
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode();
    }
}
