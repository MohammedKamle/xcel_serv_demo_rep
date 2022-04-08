package com;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class CameraInjection {

    public static String userName = "mohammedk1";
    public static String accessKey = "spBCpUJaVTnvxxssFtEJ";
    private IOSDriver<IOSElement> driver;

    @Test
    public void testCameraInjection() throws MalformedURLException {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("device", "iPhone 11");
            caps.setCapability("os_version", "13");
            caps.setCapability("project", "My First Project");
            caps.setCapability("build", "Camera Injection Sample");
            caps.setCapability("name", "test");
            caps.setCapability("app", "ios_camera_injection");
            caps.setCapability("browserstack.enableCameraImageInjection", "true");

            driver = new IOSDriver<IOSElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

            driver.executeScript("browserstack_executor:{\"action\":\"cameraImageInjection\",\"arguments\":{\"imageUrl\":\"media://634cc8280fe9a3adc101b6467721d774cc5d34e4\"}}");

            IOSElement takePhotoButton = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.name("Take Photo")));
            takePhotoButton.click();

            IOSElement allowCamera = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("OK")));
            allowCamera.click();

            IOSElement shutter = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.name("PhotoCapture")));
            shutter.click();

            IOSElement usePhoto = (IOSElement) new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(MobileBy.name("Use Photo")));
            usePhoto.click();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }



    }
}
