package tests.desktop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.desktop.BusinessPage;
import pages.desktop.BusinessPaymentAccountantPage;
import pages.desktop.HomeBankPage;

import java.util.Random;

@DisplayName("Поверка сценария: оформление расчётного счета для малого бизнеса")
public class FourTest extends BaseTest {
    HomeBankPage homeBankPage = new HomeBankPage();
    BusinessPage businessPage = new BusinessPage();
    BusinessPaymentAccountantPage businessPaymentAccountantPage = new BusinessPaymentAccountantPage();

    private final Random random = new Random();
    private final static int maxP = 1999999999;
    private final static int minP = 1000000000;
    private final static int phoneTest = 1;
    int truePhone = random.nextInt(maxP - minP) + minP;

    private final static String trueEmail = "ИванИванович@m.r";

    private final static String testInn = " ";
    private final static String trueInn = "окей";

    private final static String nameOrganization = "О`КЕЙ";
    private final static String opf = "ООО";

    private final static String testData2 = "П";
    private final static String testData3 = "Вввввввввввввввввввввввввввввввввввввввввввввввввввввввввввв вввв";
    private final static String testData4 = "Вввввввввввввввввввввввввввввввввввв аааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааавввв";
    private final static String testData5 = "Вввввввввввввввввввввввввввввввввввв ааааа ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааавввв";
    private final static String trueData = "Иван Иванов";

    private final static int maxC = 9;
    private final static int minC = 0;
    int num1 = random.nextInt(maxC - minC) + minC;
    int num2 = random.nextInt(maxC - minC) + minC;
    int num3 = random.nextInt(maxC - minC) + minC;
    int num4 = random.nextInt(maxC - minC) + minC;

    private final static String necessarilyCaption = "Поле обязательно для заполнения";
    private final static String falsePhoneCaption = "Введите верный номер телефона";
    private final static String falseEmailCaption = "Введите верный эл. адрес";
    private final static String falseInnCaption = "ИНН некорректный, проверьте правильность написания";
    private final static String falseAllowConditionsCaption = "Для обработки вашей заявки вы должны согласиться с условиями обработки персональных данных";
    private final static String falseDataCaption = "Используйте только кириллицу";
    private final static String falseDataCaption2 = "Фамилия и имя обязательны для заполнения";
    private final static String falseDataCaption3 = "Максимальная длина фамилии 50 символов";
    private final static String falseDataCaption4 = "Максимальная длина имени 50 символов";
    private final static String falseDataCaption5 = "Максимальная длина отчества 50 символов";
    private final static String confirmPhone = "Подтвердите номер телефона";
    private final static String falseCode = "Неправильный код";

    @DisplayName("Отправка заявки с пустыми полями")
    @Test
    public void businessCreditEmpty() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .clickSendRequest()
                .checkCaptions(necessarilyCaption);
    }

    @DisplayName("Ввод в поле \"Мобильный телефон\" одной цифры")
    @Test
    public void businessCreditOneNumberPhone() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputPhone(phoneTest)
                .checkPhone(falsePhoneCaption);
    }

    @DisplayName("Ввод в поле электронная почта неверных данных")
    @ParameterizedTest
    @ValueSource(strings = {"0", "Иван Иванович@m.r"})
    public void businessCreditFalseEmail(String email) {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputEmail(email)
                .checkEmail(falseEmailCaption);
    }

    @DisplayName("Ввод в поле ИНН пробела")
    @Test
    public void businessCreditInnEmpty() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputInn1(testInn)
                .checkInn(falseInnCaption);
    }

    @DisplayName("Проверка необходимости согласия с условиями обработки персональных данных")
    @Test
    public void businessCreditAllowCondition() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .allowConditions()
                .clickSendRequest()
                .checkAllow(falseAllowConditionsCaption);
    }

    @DisplayName("Ввод в поле \"Контактное лицо\" чисел и английских букв")
    @ParameterizedTest
    @ValueSource(strings = {"0", "Petr Petrov"})
    public void businessCreditFalseFIO(String data) {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputData(data)
                .checkCaptionData(falseDataCaption);
    }

    @DisplayName("Ввод в поле \"Контактное лицо\" одной буквы")
    @Test
    public void businessCreditFalseFI() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputData(testData2)
                .checkCaptionData(falseDataCaption2);
    }

    @DisplayName("Ввод в поле \"Контактное лицо\" длинную фамилию")
    @Test
    public void businessCreditFalseLongF() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputData(testData3)
                .checkCaptionData(falseDataCaption3);
    }

    @DisplayName("Ввод в поле \"Контактное лицо\" длинное имя")
    @Test
    public void businessCreditFalseLongI() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputData(testData4)
                .checkCaptionData(falseDataCaption4);
    }

    @DisplayName("Ввод в поле \"Контактное лицо\" длинную фамилию")
    @Test
    public void businessCreditFalseLongO() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputData(testData5)
                .checkCaptionData(falseDataCaption5);
    }


    @DisplayName("Отправка заявки с корректными данными")
    @Test
    public void businessCreditTrue() {
        homeBankPage.openHomeBankPage()
                .clickBusinessAndIp();

        businessPage.clickPaymentAccount();

        businessPaymentAccountantPage.clickOpenPaymentAccount()
                .inputPhone(truePhone)
                .inputEmail(trueEmail)
                .inputInn2(trueInn)
                .checkNameOPF(nameOrganization, opf)
                .inputDataTrue(trueData)
                .checkConfirmPhone(confirmPhone)
                .inputPhoneCode(num1, num2, num3, num4)
                .checkFalseCode(falseCode);
    }

}
