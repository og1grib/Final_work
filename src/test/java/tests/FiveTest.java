package tests;

import org.junit.Test;
import pages.BusinessPage;
import pages.BusinessPaymentAccountantPage;
import pages.HomeBankPage;

import java.util.Random;

public class FiveTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    BusinessPage businessPage = new BusinessPage();
    BusinessPaymentAccountantPage businessPaymentAccountantPage = new BusinessPaymentAccountantPage();

    private final Random random = new Random();
    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    private final static int phoneTest = 1;
    int truePhone = random.nextInt(maxP - minP) + minP;

    private final static String testEmail1 = "0";
    private final static String testEmail2 = "Иван Иванович@m.r";
    private final static String trueEmail = "ИванИванович@m.r";

    private final static String testInn = " ";
    private final static String trueInn = "окей";

    private final static String nameOrganization = "О`КЕЙ";
    private final static String opf = "ООО";

    private final static String testData1 = "0";
    private final static String testData2 = "Petr Petrov";
    private final static String testData3 = "П";
    private final static String testData4 = "Вввввввввввввввввввввввввввввввввввввввввввввввввввввввввввв вввв";
    private final static String testData5 = "Вввввввввввввввввввввввввввввввввввв аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааавввв";
    private final static String testData6 = "Вввввввввввввввввввввввввввввввввввв ааааа ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааавввв";
    private final static String trueData = "Иван Иванов";

    private final static int maxC = 9;
    private final static int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;


    @Test
    public void businessCredit() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .clickSendRequest()
                .checkCaptions()
                .inputPhone(phoneTest)
                .checkPhone()
                .inputPhone(truePhone)
                .inputEmail(testEmail1)
                .checkEmail()
                .inputEmail(testEmail2)
                .inputEmail(trueEmail)
                .inputInn1(testInn)
                .checkInn()
                .inputInn2(trueInn)
                .checkNameOPF(nameOrganization, opf)
                .allowConditions()
                .checkAllow()
                .allowConditions()
                .inputData(testData1)
                .checkCaptionData1()
                .inputData(testData2)
                .checkCaptionData1()
                .inputData(testData3)
                .checkCaptionData2()
                .inputData(testData4)
                .checkCaptionData3()
                .inputData(testData5)
                .checkCaptionData4()
                .inputData(testData6)
                .checkCaptionData5()
                .inputData(trueData)
                .checkConfirmPhone()
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode();
    }
}
