package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseMobileTest {
    public static final ProjectConfig configM = ConfigFactory.create(ProjectConfig.class);

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.headless = true;
        Configuration.browserSize = "600x900";
        Configuration.pageLoadStrategy = "eager";
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void turnDownAndCleanConfiguration() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        System.clearProperty("chromeoptions.mobileEmulation");
        Selenide.closeWebDriver();
    }
}
