package tests;

import com.codeborne.selenide.Configuration;

public class TestsConfiguration {
    public void configureTests() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
}
