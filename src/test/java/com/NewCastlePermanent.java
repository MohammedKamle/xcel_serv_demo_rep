package com;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class NewCastlePermanent {
    private static ThreadLocal<AppiumDriver> driverLocal = new ThreadLocal<>();

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Test
    public void executeNewsCastleTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName", "NewCastle");
        browserstackOptions.put("appiumVersion", "1.22.0");
       // browserstackOptions.put("local", "true");

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", "Google Pixel 3");
        // capabilities.setCapability("browserstack.local", "true");
        capabilities.setCapability("app", "DemoApp");
        capabilities.setCapability("bstack:options", browserstackOptions);

//        caps.setCapability("autoGrantPermissions", "true");
//        caps.setCapability("autoAcceptAlerts", "true"); //to accept all alerts

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 5000);

        try {
//            AndroidElement loginButton = (AndroidElement) new WebDriverWait(driver, 30).until(
//                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@content-desc=\"LetsGetStartedButton\"]\n")));
//            loginButton.click();

            new TouchAction(driver).press(PointOption.point(550, 640)).waitAction().moveTo(PointOption.point(550, 60)).release().perform();
//            TouchActions action = new TouchActions(driver);
//            action.scroll(loginButton, 10, 100);
//            action.perform();

//            Actions action = new Actions(driver);
//            action.sendKeys(Keys.PAGE_DOWN).build().perform();
//            Thread.sleep(5000);
//            action.sendKeys(Keys.PAGE_UP).build().perform();







//            AndroidElement cust_id = (AndroidElement) new WebDriverWait(driver, 30).until(
//                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@content-desc=\"CustomerIDEntry\"]\n")));
//            cust_id.sendKeys("3473476");

            // Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
