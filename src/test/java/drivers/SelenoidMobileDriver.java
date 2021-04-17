package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static tests.selenoid.SelenoidTestBase.SELENOID_CONFIG;

public class SelenoidMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("automationName", SELENOID_CONFIG.automationName());
        capabilities.setCapability("platformName", SELENOID_CONFIG.platformName());
        capabilities.setCapability("deviceName", SELENOID_CONFIG.deviceName());
        capabilities.setCapability("version", SELENOID_CONFIG.version());
        capabilities.setCapability("locale", SELENOID_CONFIG.locale());
        capabilities.setCapability("language", SELENOID_CONFIG.language());
        capabilities.setCapability("appPackage", SELENOID_CONFIG.appPackage());
        capabilities.setCapability("appActivity", SELENOID_CONFIG.appActivity());
        capabilities.setCapability("app", apk());


        return new AndroidDriver(getAppiumServerUrl(), capabilities);
    }

    private URL apk() {
        try {
            return new URL("https://github.com/wikimedia/apps-android-wikipedia/releases/download/untagged-4569c2d6deed0da37be2/app-alpha-universal-release.apk");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(SELENOID_CONFIG.selenoidUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
