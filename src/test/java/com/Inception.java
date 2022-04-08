package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.browserstack.local.Local;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Inception {
    WebDriver driver;
    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    Local bsLocal;


    @BeforeTest
    public void beforeTest() throws Exception {
//        bsLocal = new Local();
//        HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
//        bsLocalArgs.put("key", AUTOMATE_ACCESS_KEY);
//        bsLocalArgs.put("forcelocal", "true");
//       // bsLocalArgs.put("binarypath", "/Users/mohammed/Downloads/BrowserStackLocal");
//        bsLocal.start(bsLocalArgs);

//        System.out.println(bsLocal.isRunning());

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "OS X");
        caps.setCapability("os_version", "Big Sur");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("browserstack.selenium_version", "3.141.59");
        caps.setCapability("browserstack.debug", "true");
        caps.setCapability("browserstack.use_w3c", "true");
       // caps.setCapability("browserstack.local", "true");
        caps.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        caps.setCapability("name", "test "+timestamp); // test name
        caps.setCapability("build", "Inditex"); // CI/CD job or build name
        //caps.setCapability("browserstack.idleTimeout", "300");


        driver = new RemoteWebDriver(new URL(URL), caps);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        try{
            driver.get("https://www.saucedemo.com/inventory.html");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);
            List<WebElement> elements = driver.findElements(By.className("inventory_item_price"));
            float highest = 0;
            int productIndex = 0;
            for (int i=0; i< elements.size(); i++){
                System.out.println(Float.parseFloat(elements.get(i).getText().substring(1)));
                float price = Float.parseFloat(elements.get(i).getText().substring(1));
                if (price > highest) {
                    productIndex = i+1;
                    highest = price;
                }
            }
            System.out.println("HIGHEST PRICE :: "+highest);
            Thread.sleep(3000);
            // Clicking on add to cart for highest priced product
            driver.findElement(By.xpath("(//*[text()='Add to cart'])["+productIndex+"]")).click();
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
