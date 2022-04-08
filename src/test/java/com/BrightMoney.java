package com;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrightMoney {

    private static ThreadLocal<AppiumDriver> driverLocal = new ThreadLocal<>();

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";



    @Test
    public void excecuteBrightMoneyTest() {
        try {

//            DesiredCapabilities caps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            browserstackOptions.put("sessionName", "Testing Action Class");
//            browserstackOptions.put("buildName", "BrightMoney");
//            browserstackOptions.put("appiumVersion", "1.21.0");
//
//            caps.setCapability("bstack:options", browserstackOptions);
//            caps.setCapability("platformName", "android");
//            caps.setCapability("platformVersion", "10.0");
//            caps.setCapability("deviceName", "Vivo Y50");
//            caps.setCapability("app", "bright_android");
//            caps.setCapability("deviceOrientation", "portrait");
//            //  caps.setCapability("browserstack.local", "true");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os_version", "9.0");
            caps.setCapability("device", "Google Pixel 3");
            caps.setCapability("app", "bright_android");



            driverLocal.set(new AndroidDriver<MobileElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps));

            System.out.println(driverLocal.get().getSessionId());

            AndroidElement loginButton = (AndroidElement) new WebDriverWait(driverLocal.get(), 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Login']")));
            loginButton.click();



            Actions actions = new Actions(driverLocal.get());
            actions.sendKeys("7767760048").build().perform();

            //app restart
            Activity activity = new Activity("com.android.settings", "com.android.settings.Settings");
            //activity.setStopApp(true);

            Thread.sleep(3000);
            // driver.get().terminateApp("com.brightcapital.app.dev");

            // you can also use the following to launch the app
            //driver.get().launchApp();

            //starting the activity
            ((StartsActivity) driverLocal.get()).startActivity(activity);

            Thread.sleep(3000);

            driverLocal.get().launchApp();



            Thread.sleep(5000);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driverLocal.get().quit();
        }
    }

    @Test(enabled = false)
    public void executeBrightMoneyIOS() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("sessionName", "Testing Action Class");
        browserstackOptions.put("buildName", "BrightMoney");
        browserstackOptions.put("appiumVersion", "1.21.0");

        caps.setCapability("bstack:options", browserstackOptions);
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "14");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("app", "bright_iOS");
        caps.setCapability("autoGrantPermissions", "true");
        caps.setCapability("autoAcceptAlerts", "true"); //to accept all alerts

        driverLocal.set(new IOSDriver<IOSElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps));

        try {
            IOSElement btn_login = (IOSElement) new WebDriverWait(driverLocal.get(), 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//XCUIElementTypeOther[@name='Login']")));
            btn_login.click();

            IOSElement phone = (IOSElement) new WebDriverWait(driverLocal.get(), 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Phone Number +1")));
            phone.sendKeys("8932657174");

            IOSElement gettingStarted = (IOSElement) new WebDriverWait(driverLocal.get(), 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//XCUIElementTypeStaticText[@name='Get Started']")));
            gettingStarted.click();

            IOSElement resendCodeButton = (IOSElement) new WebDriverWait(driverLocal.get(), 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("(//XCUIElementTypeOther[@name=\"Resend Code\"])[2]\n")));

            if (resendCodeButton.isDisplayed()){
                Actions actions = new Actions(driverLocal.get());
                actions.sendKeys("000000").build().perform();
            }else {
                System.out.println("Control didn't reached the desired screen");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driverLocal.get().quit();
        }

    }
}
