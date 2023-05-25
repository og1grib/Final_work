package tests.desktop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public abstract class BaseTest {

    public static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    @BeforeEach //для работы на виртуальной машине
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1440x900";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = "http://localhost:4444";
    }


    @AfterEach
    public void turnDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
