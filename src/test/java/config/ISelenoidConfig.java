package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${deviceHost}.properties")
public interface ISelenoidConfig extends Config {

    @Key("selenoid_url")
    String selenoidUrl();

    @Key("automationName")
    String automationName();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("locale")
    String locale();

    @Key("language")
    String language();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

}
