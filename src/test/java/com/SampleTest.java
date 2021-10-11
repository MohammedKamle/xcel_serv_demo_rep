package com;// Sample test in Java to run Automate session.

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SampleTest {
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
        new SampleTest().executeLillPulitzerTest();

        //  DesiredCapabilities caps = new DesiredCapabilities();

//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "latest");
//        caps.setCapability("browserstack.local", "false");
//        caps.setCapability("browserstack.selenium_version", "3.141.59");
//        caps.setCapability("browserstack.debug", "true");
//        caps.setCapability("browserstack.use_w3c", "true");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        caps.setCapability("name", "actionClassTest "+timestamp); // test name
//        caps.setCapability("build", "Dialpad"); // CI/CD job or build name
//         caps.setCapability("browserstack.idleTimeout", "300");

//         WebDriver driver = new RemoteWebDriver(new URL(URL), caps);


//       AppiumDriver driver = new AndroidDriver<AndroidElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps);
        // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        try {
//             /BrightMoney Stuff
//            AndroidElement loginButton = (AndroidElement) new WebDriverWait(driver, 30).until(
//                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Login']")));
//            loginButton.click();
//            Actions actions = new Actions(driver);
//            actions.sendKeys("7767760048").build().perform();


//            AndroidElement continueButton = (AndroidElement) new WebDriverWait(driver, 30).until(
//                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[@content-desc='btn_Continue_Login']")));
//            continueButton.click();
//            Thread.sleep(10000);
//            new Actions(driver).sendKeys("000000").build().perform();


            // Dialpad stuff
//
//            driver.get("https://www.browserstack.com/");
//            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
//            Actions ac = new Actions(driver);
//            WebElement live = driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='Live']"));
//            ac.moveToElement(live).build().perform();
//            Thread.sleep(3000);
//            WebElement automate = driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
//            automate.click();
//
//            Thread.sleep(2000);


        } catch (Exception e) {
            //markTestStatus("failed", "Actions class didn't worked", driver);
            System.out.println(e);

        } finally {
            //  driver.quit();
        }


    }


    public void excecuteBrightMoneyTest() {
        try {

            DesiredCapabilities caps = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
            browserstackOptions.put("sessionName", "Testing Action Class");
            browserstackOptions.put("buildName", "BrightMoney");
            browserstackOptions.put("appiumVersion", "1.21.0");

            caps.setCapability("bstack:options", browserstackOptions);
            caps.setCapability("platformName", "android");
            caps.setCapability("platformVersion", "9.0");
            caps.setCapability("deviceName", "Google Pixel 3");
            caps.setCapability("app", "BrightMoneyApp");
            caps.setCapability("deviceOrientation", "portrait");
            driver.set(new AndroidDriver<MobileElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps));


            AndroidElement loginButton = (AndroidElement) new WebDriverWait(driver.get(), 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text='Login']")));
            loginButton.click();

            Actions actions = new Actions(driver.get());
            actions.sendKeys("7767760048").build().perform();

            //app restart
            Activity activity = new Activity("com.brightcapital.app.dev", "com.brightcapital.app.MainActivity");
            //activity.setStopApp(true);

            Thread.sleep(3000);
            driver.get().terminateApp("com.brightcapital.app.dev");

            // you can also use the following to launch the app
            //driver.get().launchApp();

            //starting the activity
            ((StartsActivity) driver.get()).startActivity(activity);

            Thread.sleep(3000);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.get().quit();
        }
    }

    public void executeLillPulitzerTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.console", "verbose");
        // caps.setCapability("browserstack.use_w3c", "true");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        caps.setCapability("name", "testLogsTest " + timestamp); // test name
        caps.setCapability("build", "LillyPulotzer"); // CI/CD job or build name
        caps.setCapability("browserstack.idleTimeout", "300");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        try {
            driver.get("https://www.browserstack.com/");
            //  WebElement element = driver.findElement(By.name("q"));
            // element.sendKeys("BrowserStack");
            Assert.assertTrue(true, "TITTLE SHOULD BE DISPLAYED");


            SoftAssert softAssert = new SoftAssert();

            boolean a = true;
            boolean b = true;
            boolean c = true;

            // Soft assertion at BrowserStack
            if (a) {
                softAssertOnBrowserStack("Page 1 displayed", driver);
            }else {
               softAssertOnBrowserStack("Page 1 failed to display", driver);
            }
            if (b) {
                softAssertOnBrowserStack("Page 2 displayed", driver);
            }else {
                softAssertOnBrowserStack("Page 2 failed to display", driver);
            }

            if (c) {
                softAssertOnBrowserStack("Page 3 displayed", driver);
            }else {
                softAssertOnBrowserStack("Page 3 failed to display", driver);
            }

            // Soft assertions locally
            softAssert.assertTrue(a,"Page 1 displayed");
            softAssert.assertTrue(b, "Page 2 displayed");
            softAssert.assertTrue(c, "Page 3 displayed");
            softAssert.assertAll();

            // Marking overall test status
            markTestStatus("passed","Pages displayed as expected", driver);

        } catch (AssertionError e) {
            markTestStatus("failed","Pages didn't displayed as expected", driver);
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }


    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}}");
    }

    public static void softAssertOnBrowserStack(String validationMessage, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("console.log(\"" + validationMessage + "\")");
    }
}