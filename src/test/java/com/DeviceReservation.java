package com;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Random;

public class DeviceReservation {

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    static AndroidDriver<AndroidElement> driver;


    @BeforeMethod
    public void beforeTest() throws MalformedURLException {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "11.0");
        capabilities.setCapability("device", "Samsung Galaxy S21");
        capabilities.setCapability("app", "login-app");
        capabilities.setCapability("build", "Device Reservation");
        capabilities.setCapability("name", generatedString);
        capabilities.setCapability("browserstack.reserveDevice", "true");
        capabilities.setCapability("noReset", "true");
        driver = new AndroidDriver<AndroidElement>(new URL(URL), capabilities);
    }

    @Test
    public void test1(){
        AndroidElement e1 = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.loginmodule.learning:id/textInputEditTextEmail")));
        e1.sendKeys("abc@gmail.com");
        MobileElement el2 = (MobileElement) driver.findElementById("com.loginmodule.learning:id/textInputEditTextPassword");
        el2.sendKeys("password");
        MobileElement el3 = (MobileElement) driver.findElementById("com.loginmodule.learning:id/appCompatButtonLogin");
        el3.click();
    }

    @Test
    public void test2(){
        AndroidElement e1 = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("com.loginmodule.learning:id/textInputEditTextEmail")));
        e1.sendKeys("xyz@gmail.com");
        MobileElement el2 = (MobileElement) driver.findElementById("com.loginmodule.learning:id/textInputEditTextPassword");
        el2.sendKeys("prossap");
        MobileElement el3 = (MobileElement) driver.findElementById("com.loginmodule.learning:id/appCompatButtonLogin");
        el3.click();
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
