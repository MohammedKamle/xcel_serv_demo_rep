package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;

public class JenkinsSample {
    public static final String AUTOMATE_USERNAME = System.getenv("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static final String BUILD = System.getenv("BROWSERSTACK_BUILD_NAME");
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    @Test
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
       // caps.setCapability("name", "testLogsTest " + timestamp); // test name
        caps.setCapability("build", BUILD); // CI/CD job or build name
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



    public static void softAssertOnBrowserStack(String validationMessage, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("console.log(\"" + validationMessage + "\")");
    }

    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}}");
    }
}


