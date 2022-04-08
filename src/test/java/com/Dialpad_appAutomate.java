package com;

import com.browserstack.local.Local;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Dialpad_appAutomate {

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
        capabilities.setCapability("app", "DemoApp");
        capabilities.setCapability("browserstack.local", "true");
        capabilities.setCapability("build", "Dialpad");
        capabilities.setCapability("name", generatedString);
        capabilities.setCapability("browserstack.appium_version", "1.21.0");
        capabilities.setCapability("browserstack.idleTimeout", "300");

        // Local Setup
        Local bsLocal = new Local();

        HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
        bsLocalArgs.put("key", "spBCpUJaVTnvxxssFtEJ");
        bsLocalArgs.put("forcelocal", "true");
      //x  bsLocalArgs.put("binarypath", "/Users/mohammed/Downloads/BrowserStackLocal");

        bsLocal.start(bsLocalArgs);
        System.out.println(bsLocal.isRunning());

        try {
            driver = new AndroidDriver<AndroidElement>(new URL(URL), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.HOURS);
            boolean isDeviceLocked = false;
//            while (!isDeviceLocked){
//                 isDeviceLocked = driver.isDeviceLocked();
//                 if (isDeviceLocked){
//                     System.err.println("Device got locked ");
//                     break;
//                 }
//            }

            driver.lockDevice();
            System.out.println("Device is locked :: "+driver.isDeviceLocked());
            driver.unlockDevice();
            System.out.println("Device is locked :: "+driver.isDeviceLocked());


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
            bsLocal.stop();
        }


    }
}
