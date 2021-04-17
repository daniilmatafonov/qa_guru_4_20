package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${deviceHost}.properties")
public interface IBrowserStackConfig extends Config {

    @Key("browserstack_user")
    String browserstackUser();

    @Key("browserstack_key")
    String browserstackKey();

    @Key("app_url")
    String appUrl();

    @Key("app_package")
    String appPackage();

    @Key("app_activity")
    String appActivity();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

}
