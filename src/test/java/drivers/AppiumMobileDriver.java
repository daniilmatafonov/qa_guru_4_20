package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static tests.appium.AppiumTestBase.APPIUM_CONFIG;

public class AppiumMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("automationName", APPIUM_CONFIG.automationName());
        capabilities.setCapability("platformName", APPIUM_CONFIG.platformName());
        capabilities.setCapability("deviceName", APPIUM_CONFIG.deviceName());
        capabilities.setCapability("version", APPIUM_CONFIG.version());
        capabilities.setCapability("locale", APPIUM_CONFIG.locale());
        capabilities.setCapability("language", APPIUM_CONFIG.language());
        capabilities.setCapability("appPackage", APPIUM_CONFIG.appPackage());
        capabilities.setCapability("appActivity", APPIUM_CONFIG.appActivity());
        capabilities.setCapability("app", getAbsolutePath(APPIUM_CONFIG.app()));


        return new AndroidDriver(getAppiumServerUrl(), capabilities);
    }

    private String getAbsolutePath(String filePath) {
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
