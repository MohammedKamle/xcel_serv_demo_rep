package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBrokenLinks {
    WebDriver driver;
    public static final String AUTOMATE_USERNAME = "karannagpal_3siwfY";
    public static final String AUTOMATE_ACCESS_KEY = "ZGsyppwKJHaUrCqotJdG";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    HttpURLConnection huc = null;
    String url = "";
    String homePage = "http://www.zlti.com";
    int respCode = 200;


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os", "OS X");
//        caps.setCapability("os_version", "Big Sur");
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "latest");
//        caps.setCapability("browserstack.selenium_version", "3.141.59");
//        caps.setCapability("browserstack.debug", "true");
//        caps.setCapability("browserstack.use_w3c", "true");
//        caps.setCapability("browserstack.local", "true");
//        caps.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
//        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
//
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        caps.setCapability("name", "test "+timestamp); // test name
//        caps.setCapability("build", "Inditex"); // CI/CD job or build name
//        //caps.setCapability("browserstack.idleTimeout", "300");
//
//
//        driver = new RemoteWebDriver(new URL(URL), caps);
//        driver.manage().window().fullscreen();
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test() {
        try {
            // Navigate to Url
            driver.get(homePage);
            List<WebElement> links = driver.findElements(By.tagName("a"));
            Iterator<WebElement> it = links.iterator();
            while (it.hasNext()) {
                url = it.next().getAttribute("href");
                if (url == null || url.isEmpty()) {
                    System.out.println("URL is either not configured for anchor tag or it is empty");
                    continue;
                }
                if (!url.startsWith("https://www.zlti")) {
                    System.out.println("URL belongs to another domain, skipping it.");
                    continue;
                }

                    huc = (HttpURLConnection) (new URL(url).openConnection());
                    huc.setRequestMethod("GET");
                    huc.connect();
                    respCode = huc.getResponseCode();
                    if (respCode >= 400) {
                        System.out.println(url + " is a broken link");
                    } else {
                        System.out.println(url + " is a valid link");
                    }

            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
    }
}
