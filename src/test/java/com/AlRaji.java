package com;

import com.browserstack.local.Local;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AlRaji {

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_ACCESS_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    static AndroidDriver<AndroidElement> driver;

    public static void main(String[] args) throws Exception {

        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os_version", "11.0");
        capabilities.setCapability("device", "Samsung Galaxy S21");
        capabilities.setCapability("app", "demo");
        capabilities.setCapability("build", "AlRaji");
        capabilities.setCapability("name", generatedString);
        capabilities.setCapability("browserstack.appium_version", "1.21.0");
        capabilities.setCapability("browserstack.idleTimeout", "300");
        AndroidDriver driver = new AndroidDriver(new URL(URL), capabilities);
        try {

            AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
            searchElement.click();
            AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
            insertTextElement.sendKeys("BrowserStack");
            Thread.sleep(5000);

            List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
            assert(allProductsName.size() > 0);



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();

        }


    }
}
