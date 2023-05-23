package tests.desktop;

import org.junit.jupiter.api.Test;
import pages.desktop.HomeBankPage;
import pages.desktop.IpotekaAcreditBuilders;
import pages.desktop.IpotekaPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class FourTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    IpotekaPage ipotekaPage = new IpotekaPage();
    IpotekaAcreditBuilders ipotekaAcreditBuilders = new IpotekaAcreditBuilders();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    static LocalDate oldDate = LocalDate.now().minusYears(80);
    static LocalDate youngDate = LocalDate.now().minusYears(2);
    static LocalDate falseDate = LocalDate.now().plusYears(20);
    static LocalDate trueDate = LocalDate.now().minusYears(20);
    String oldDateString = oldDate.format(formatter);
    String youngDateString = youngDate.format(formatter);
    String falseDateString = falseDate.format(formatter);
    String trueDateString = trueDate.format(formatter);

    private final Random random = new Random();
    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    private final static int testPhone = 1;
    int truePhone = random.nextInt(maxP - minP) + minP;

    private final static String testData1 = ".";
    private final static String testData2 = "0";
    private final static String testData3 = "Petr Petrov";
    private final static String testData4 = "П";
    private final static String trueData = "Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван Иванов Иванович Иван";

    private final static String testEmail1 = "0";
    private final static String testEmail2 = "Иван Иванович@m.r";
    private final static String trueEmail = "/@м.р";

    private final static String testSumFlat1 = " ";
    private final static String testSumFlat2 = "10000000000000000";

    private final static String testSumDue1 = " ";
    private final static String testSumDue2 = "10000000000000000";

    private final static String testTime1 = " ";
    private final static String testTime2 = "100";

    private final static String testCity = " ";
    private final static String trueCity = "г Москва";

    int maxC = 9;
    int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;

    @Test
    public void ipoteka() {
        homeBankPage.openHomeBankPage()
                .clickIpoteka();

        ipotekaPage.clickProgram()
                .clickAccreditBuilders();

        ipotekaAcreditBuilders.choseBuilder()
                .clickNext()
                .checkCaptions()
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
                .inputBirthday(falseDateString)
                .checkBirthday2()
                .inputBirthday(youngDateString)
                .checkBirthday3()
                .inputBirthday(trueDateString)
                .inputPhone(testPhone)
                .checkPhone()
                .inputPhone(truePhone)
                .inputEmail(testEmail1)
                .checkEmail()
                .inputEmail(testEmail2)
                .checkEmail()
                .inputEmail(trueEmail)
                .allowConditions()
                .checkAllow()
                .allowConditions()
                .clickFamilyWithChild()
                .inputSumFlat(testSumFlat1)
                .checkSumFlat1()
                .inputSumFlat(testSumFlat2)
                .checkSumFlat2()
                .inputSumDue(testSumDue1)
                .checkSumDue1()
                .inputSumDue(testSumDue2)
                .checkSumDue2()
                .inputTime(testTime1)
                .checkTime1()
                .inputTime(testTime2)
                .checkTime2()
                .inputCity1(testCity)
                .checkCity()
                .inputCity2(trueCity)
                .checkConfirmPhone()
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode();
    }

}
