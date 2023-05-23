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
        Selenide.clearBrowserCookies();
        System.setProperty("chromeoptions.mobileEmulation", "deviceName=Nexus 5");
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "400x800";
        Configuration.timeout = 100000;
        Configuration.pageLoadTimeout = 100000;

        Configuration.remote = "http://localhost:4444/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        System.setProperty("chromeoptions.args", "\"--no-sandbox\",\"--disable-dev-shm-usage\",\"--remote-debugging-port=9222\"");
    }

    @AfterEach
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
