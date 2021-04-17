package tests.selenoid;

import com.codeborne.selenide.Configuration;
import config.IAppiumConfig;
import config.ISelenoidConfig;
import drivers.AppiumMobileDriver;
import drivers.SelenoidMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.attachPageSource;
import static helpers.AttachmentsHelper.attachScreenshot;
import static io.qameta.allure.Allure.step;

public class SelenoidTestBase {

    public static ISelenoidConfig SELENOID_CONFIG = ConfigFactory.create(ISelenoidConfig.class, System.getProperties());

    @BeforeAll
    public static void beforeAll() {
        addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = SelenoidMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void startDriver() {
        step("Open application", () -> open());
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        closeWebDriver();
    }

}
