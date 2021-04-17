package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${deviceHost}.properties")
public interface ISelenoidConfig extends Config {


}
