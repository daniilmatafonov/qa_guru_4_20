package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static tests.browserstack.BrowserstackTestBase.BROWSER_STACK_CONFIG;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("browserstack.user", BROWSER_STACK_CONFIG.browserstackUser());
        capabilities.setCapability("browserstack.key", BROWSER_STACK_CONFIG.browserstackKey());
        capabilities.setCapability("app_url", BROWSER_STACK_CONFIG.appUrl());
        capabilities.setCapability("appPackage", BROWSER_STACK_CONFIG.appPackage());
        capabilities.setCapability("appActivity", BROWSER_STACK_CONFIG.appActivity());
        capabilities.setCapability("device", BROWSER_STACK_CONFIG.device());
        capabilities.setCapability("os_version", BROWSER_STACK_CONFIG.osVersion());
        capabilities.setCapability("project", BROWSER_STACK_CONFIG.project());
        capabilities.setCapability("build", BROWSER_STACK_CONFIG.build());
        capabilities.setCapability("name", BROWSER_STACK_CONFIG.name());

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
