package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Random;

public class PhilipineCutomer {
    public static final String HUB_URL = "https://hub-cloud.browserstack.com/wd/hub";
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    long build_number;
    @BeforeTest
    public void beforeTest(){
        Random random = new Random();
         build_number = random.nextInt(1000);
        System.out.println(build_number);
    }

    @Test(invocationCount = 100 , threadPoolSize = 100)
    public void test() throws MalformedURLException {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "11");
            caps.setCapability("browser", "Chrome");
         //   caps.setCapability("realMobile",true);
            caps.setCapability("browser_version", "98");
            caps.setCapability("browserstack.selenium_version", "3.141.59");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            caps.setCapability("name", "actionClassTest "+timestamp); // test name

            caps.setCapability("build", "Philipines_Customer"+build_number); // CI/CD job or build name

            driver.set(new RemoteWebDriver(new URL(URL), caps));
            driver.get().get("https://www.gmanetwork.com/news/archives/lifestyle-familyandrelationships/");
            new WebDriverWait(driver.get(), 30).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

           // System.out.println("THREAD ID :: "+Thread.currentThread().getId());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
          //  System.out.println("THREAD ID :: "+Thread.currentThread().getId());
            driver.get().quit();
        }

    }
}
