package com.example.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties",
        "classpath:remote.properties"})

public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserName")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("resolution")
    String getResolution();

    @Key("remote")
    String getRemoteUrl();
}
