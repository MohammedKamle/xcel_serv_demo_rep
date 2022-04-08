package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;

public class Dialpad_automate {

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Big Sur");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.use_w3c", "true");
        caps.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        caps.setCapability("name", "actionClassTest "+timestamp); // test name
        caps.setCapability("build", "Dialpad"); // CI/CD job or build name
        //caps.setCapability("browserstack.idleTimeout", "300");


        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        try{
            driver.get("https://makemytrip.com/");
            //Thread.sleep(10000);
//
//            WebElement element= driver.findElement(By.cssSelector(".d-btn.d-btn--outlined"));
//            Actions actions= new Actions(driver);
//            actions.moveToElement(element).perform();
            Thread.sleep(2000);

            Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            try {
                ImageIO.write(screenshot.getImage(),"PNG",new File("src/test/makemytrip.png"));
                markTestStatus("passed", "java.lang.AssertionError: Test case Failed!!!          at org.testng.Assert.fail(Assert.java:99)   at com.sv.tests.LoginTest.Validate_Login(LoginTest.java:39)               at java.base/jdk.internal.reflect.NativeMethodAcc", driver);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                markTestStatus("failed", "Image not taken", driver);
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }

    public static void markTestStatus(String status, String reason, WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + reason + "\"}}");
    }



}
