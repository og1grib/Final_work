package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ProjectConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
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
//        Configuration.baseUrl = "http://localhost:8080";
    }

    @AfterEach
    public void turnDown() {
        Selenide.closeWebDriver();
    }
}
