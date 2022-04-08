package com;// Sample test in Java to run Automate session.

import io.appium.java_client.*;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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
    private static ThreadLocal<AppiumDriver> driverLocal = new ThreadLocal<>();
    WebDriver driver;
    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static void main(String[] args) throws Exception {
      //  new SampleTest().executeNewsCastleTest();
//        new SampleTest().excecuteBrightMoneyTest();
//        new SampleTest().executeBrightMoneyIOS();
//        new SampleTest().executeFADVTest();
//         new SampleTest().executeLillPulitzerTest();
//
//          new SampleTest().executeLogiNextTest();

          DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "true");
        caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.use_w3c", "true");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        caps.setCapability("name", "actionClassTest "+timestamp); // test name
        caps.setCapability("build", "Dialpad"); // CI/CD job or build name
         caps.setCapability("browserstack.idleTimeout", "300");

         WebDriver driver = new RemoteWebDriver(new URL(URL), caps);


//       AppiumDriver driver = new AndroidDriver<AndroidElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps);
        // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //   try {

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


         //Dialpad stuff

            driver.get("https://localhost:9000");
            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
            Actions ac = new Actions(driver);
            WebElement live = driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='Live']"));
            ac.moveToElement(live).build().perform();
            Thread.sleep(3000);
            WebElement automate = driver.findElement(By.cssSelector("div.product-cards-wrapper--click a[title='App Automate']"));
            automate.click();

            Thread.sleep(2000);


//        } catch (Exception e) {
//            //markTestStatus("failed", "Actions class didn't worked", driver);
//            System.out.println(e);
//
//        } finally {
//            //  driver.quit();
//        }


    }

    public void executeFADVTest() throws MalformedURLException {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "latest");
            caps.setCapability("browserstack.local", "false");
            // caps.setCapability("browserstack.selenium_version", "3.141.59");
            caps.setCapability("browserstack.debug", "true");
            caps.setCapability("browserstack.console", "verbose");
            // caps.setCapability("browserstack.use_w3c", "true");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            caps.setCapability("name", "testLogsTest " + timestamp); // test name
            caps.setCapability("build", "FADV"); // CI/CD job or build name
            caps.setCapability("browserstack.idleTimeout", "300");

//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("os_version", "14");
//            caps.setCapability("device", "iPhone 12");
//            caps.setCapability("real_mobile", "true");
//            caps.setCapability("browserstack.appium_version", "1.21.0");
//            caps.setCapability("browserstack.local", "false");

            driver = new RemoteWebDriver(new URL(URL), caps);
//            driver.get("https://ua.enterprisetest.fadv.com/");
//            driver.findElement(By.cssSelector("input[name='accountnumber']")).sendKeys("123456sri");
//            driver.findElement(By.cssSelector("input[name='username']")).sendKeys("autotest");
//            driver.findElement(By.cssSelector("input[name='password']")).sendKeys("test@500");
//            driver.findElement(By.cssSelector("#signOn")).click();

            driver.get("https://pa-intl.fadv.com/#/home/my-data");
            Thread.sleep(6000);
            driver.findElement(By.xpath("//input[@id='loginInputEmail']")).sendKeys("Browserstack101902@test.com");
            driver.findElement(By.xpath("//input[@id='loginInputPwd']")).sendKeys("mxtuv86@azim");
            driver.findElement(By.xpath("//button[normalize-space()='NEXT']")).click();
            Thread.sleep(6000);

            WebDriverWait wait = new WebDriverWait(driver, 50);

            //  WebElement iUnderstand = driver.findElement(By.xpath("//button[normalize-space()='I UNDERSTAND']"));
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[normalize-space()='I UNDERSTAND']")))).click();

            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='paNameNext']")))).click();
            //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("#aliasNoName")))).click();
            Thread.sleep(6000);
            driver.findElement(By.cssSelector("#aliasNoName")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='paGenderNext']")))).click();


            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='dobdp-widget']")))).sendKeys("07/10/2007");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
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
            caps.setCapability("platformVersion", "10.0");
            caps.setCapability("deviceName", "Vivo Y50");
            caps.setCapability("app", "bright_android");
            caps.setCapability("deviceOrientation", "portrait");
          //  caps.setCapability("browserstack.local", "true");


            driverLocal.set(new AndroidDriver<MobileElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), caps));


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

    public void executeLillPulitzerTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.local", "false");
        // caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.console", "verbose");
        // caps.setCapability("browserstack.use_w3c", "true");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        caps.setCapability("name", "testLogsTest " + timestamp); // test name
        caps.setCapability("build", "LillyPulotzer"); // CI/CD job or build name
        //caps.setCapability("browserstack.idleTimeout", "1800");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

        driver.get("https://ua.enterprisetest.fadv.com/");


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
            } else {
                softAssertOnBrowserStack("Page 1 failed to display", driver);
            }
            if (b) {
                softAssertOnBrowserStack("Page 2 displayed", driver);
            } else {
                softAssertOnBrowserStack("Page 2 failed to display", driver);
            }

            if (c) {
                softAssertOnBrowserStack("Page 3 displayed", driver);
            } else {
                softAssertOnBrowserStack("Page 3 failed to display", driver);
            }

            // Soft assertions locally
            softAssert.assertTrue(a, "Page 1 displayed");
            softAssert.assertTrue(b, "Page 2 displayed");
            softAssert.assertTrue(c, "Page 3 displayed");
            softAssert.assertAll();

            // Marking overall test status
            markTestStatus("passed", "Pages displayed as expected", driver);

        } catch (AssertionError e) {
            markTestStatus("failed", "Pages didn't displayed as expected", driver);
            e.printStackTrace();
        } finally {
            // driver.quit();
        }
    }

    public void executeLogiNextTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S8 Plus");
        caps.setCapability("os_version", "7.0");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build SET");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability("app", "DemoApp");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(URL), caps);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);



        // The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
        driver.quit();
    }

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

    private    WebElement checkElementOnScreen(By elementBy) {
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(elementBy)
        );
        new WebDriverWait(driver, 5).until(
                ExpectedConditions.elementToBeClickable(elementBy));
        return driver.findElement(elementBy);
    }

    public void executeNewsCastleTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("buildName", "NewCastle");
        browserstackOptions.put("appiumVersion", "1.22.0");
        browserstackOptions.put("local", "true");

        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", "Google Pixel 3");
       // capabilities.setCapability("browserstack.local", "true");
        capabilities.setCapability("app", "DemoApp");
        capabilities.setCapability("bstack:options", browserstackOptions);

//        caps.setCapability("autoGrantPermissions", "true");
//        caps.setCapability("autoAcceptAlerts", "true"); //to accept all alerts

        AndroidDriver<AndroidElement>  driver = new AndroidDriver<AndroidElement>(new URL("https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 5000);

        try {
//            AndroidElement loginButton = (AndroidElement) new WebDriverWait(driver, 30).until(
//                    ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@content-desc=\"LetsGetStartedButton\"]\n")));
//            loginButton.click();

            //new TouchAction(driver).press(PointOption.point(550, 640)).waitAction().moveTo(PointOption.point(550, 60)).release().perform();
//            TouchActions action = new TouchActions(driver);
//            action.scroll(loginButton, 10, 100);
//            action.perform();

            Actions action = new Actions(driver);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(5000);
            action.sendKeys(Keys.PAGE_UP).build().perform();







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





    // This method accepts the status, reason and WebDriver instance and marks the test on BrowserStack
    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}}");
    }

    public static void softAssertOnBrowserStack(String validationMessage, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("console.log(\"" + validationMessage + "\")");
    }

    public static boolean retryingFindClick(WebDriver driver, By by) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return result;
    }
}