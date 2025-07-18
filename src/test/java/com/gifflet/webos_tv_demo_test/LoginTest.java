package com.gifflet.webos_tv_demo_test;

import com.gifflet.webos_tv_demo_test.pages.LoginPage;
import com.gifflet.webos_tv_demo_test.pages.UserPage;
import io.appium.java_client.remote.options.BaseOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.cdimascio.dotenv.Dotenv;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

class LoginTest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() throws MalformedURLException {
        Dotenv dotenv = Dotenv.load();
        
        String appiumUrl = dotenv.get("APPIUM_URL");
        String deviceHost = dotenv.get("WEBOS_DEVICE_HOST");
        String chromedriverPath = dotenv.get("WEBOS_CHROMEDRIVER_PATH");
        
        if (appiumUrl == null || deviceHost == null || chromedriverPath == null) {
            throw new IllegalStateException("Missing required environment variables. " +
                    "Please ensure APPIUM_URL, WEBOS_DEVICE_HOST, and WEBOS_CHROMEDRIVER_PATH are set in .env file");
        }
        
        Capabilities capabilities = new BaseOptions<>(Map.of(
                "platformName", "lgtv",
                "appium:automationName", "webos",
                "appium:deviceName", "TVLG",
                "appium:deviceHost", deviceHost,
                "appium:chromedriverExecutable", chromedriverPath,
                "appium:appId", "demo.app"
        ));
        driver = new RemoteWebDriver(new URL(appiumUrl), capabilities);
    }

    @Test
    void successfulLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        UserPage userPage = new UserPage(driver);

        loginPage.insertEmail("user@demo.com");
        loginPage.insertPassword("demo1234");
        loginPage.clickLoginButton();

        assert(userPage.isUserInWelcomePage());
    }

    @Test
    void failedLoginTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.insertEmail("user@demo.com");
        loginPage.insertPassword("demo12345");
        loginPage.clickLoginButton();

        assert(loginPage.isLoginErrorVisible());
    }

    @AfterEach
    void tearDown(){
        if (Objects.nonNull(driver)){
            driver.quit();
        }
    }
}
