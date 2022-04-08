package com;

import io.appium.java_client.MobileBy;
import io.appium.java_client.Setting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchToMobileBrowserInAppAutomate {

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Test
    public void switchToBrowserTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S21");
        capabilities.setCapability("app", "demo");
        capabilities.setCapability("browserstack.timezone", "Kolkata");
        AndroidDriver driver = new AndroidDriver(new URL(URL), capabilities);

        // Here we are switching to Google Chrome Browser
        driver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
        Thread.sleep(10000);
        System.out.println("DEVICE TIME :: "+driver.getDeviceTime());

        Set<String> contextNames = driver.getContextHandles();
        for (String s : contextNames){
            System.out.println("This context is "+s);
        }
        if(contextNames.size() > 1) {

            driver.context("WEBVIEW_chrome");
        }
        Thread.sleep(10000);

        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Browserstack");
        driver.findElement(By.name("q")).submit();
        System.out.println("Title is: "+driver.getTitle());

        driver.startActivity(new Activity("org.wikipedia.alpha", "org.wikipedia.main.MainActivity"));
        Thread.sleep(10000);

        driver.context("NATIVE_APP");

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        Assert.assertTrue(allProductsName.size() > 0);

        try {


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
