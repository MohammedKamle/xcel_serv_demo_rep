package com;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class WebRTCSample {
    public static final String HUB_URL = "https://hub-cloud.browserstack.com/wd/hub";
    private WebDriver  driver;

    public static final String AUTOMATE_USERNAME = "mohammedk1";
    public static final String AUTOMATE_KEY = "spBCpUJaVTnvxxssFtEJ";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

//    public static void main(String[] args) throws Exception {
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        ChromeOptions options = new ChromeOptions();
//        //options.addArguments("--use-file-for-fake-video-capture=C:\\Users\\hello\\Downloads\\sample_960x400_ocean_with_audio.mjpeg");
////        options.addArguments("--use-file-for-fake-video-capture=C:\\Users\\hello\\Downloads\\sample_mjpeg.mjpeg");
////        options.addArguments("--use-fake-device-for-media-stream");
////        options.addArguments("--use-fake-ui-for-media-stream");
////        options.addArguments("--allow-file-access-from-files");
////        options.addArguments("--disable-gesture-requirement-for-media-playback");
//        options.addArguments(
//                "--use-file-for-fake-video-capture=C:\\Users\\hello\\Documents\\video\\sample_mjpeg.mjpeg",
//                "--use-fake-device-for-media-stream",
//                "--use-fake-ui-for-media-stream",
//                "--allow-file-access-from-files",
//                "--disable-gesture-requirement-for-media-playback"
//
//
//        );
//       // options.addArguments("--use-file-for-fake-video-capture=C:\\Users/test1/Documents/video/sample_mjpeg.mjpeg");
//        caps.setCapability(ChromeOptions.CAPABILITY, options);
//        caps.setCapability("browser", "chrome");
//        caps.setCapability("os", "windows");
//        caps.setCapability("browser_version", "latest");
//        caps.setCapability("browserstack.local", "true");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("name", "Bstack-[Java] Sample Test");
//        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
//
//        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
//        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
////        driver.get("http://www.fileconvoy.com/");
////        driver.findElement(By.id("upfile_0")).sendKeys("/Users/mohammed/Downloads/sample_960x400_ocean_with_audio.mjpeg");
////        driver.findElement(By.id("readTermsOfUse")).click();
////        driver.findElement(By.name("upload_button")).submit();
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        try {
////            WebDriverWait wait = new WebDriverWait(driver, 5);
////            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TopMessage")));
////            if(driver.findElement(By.id("TopMessage")).getText().contains("successfully uploaded")) {
////                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"File uploaded successfully\"}}");
////            } else {
////                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"File upload failed\"}}");
////            }
////            Thread.sleep(20000);
//            driver.get("https://webrtc.github.io/samples/src/content/devices/input-output/");
//            Thread.sleep(3000);
//            //driver.findElement(By.id("start")).click();
//            Thread.sleep(10000);
//        }
//        catch(Exception e) {
//            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"File could not be uploaded in 5 seconds\"}}");
//        }
//        driver.quit();
//    }

    //        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("media.navigator.streams.fake", true);
////        profile.setPreference("browser.download.dir", "C:\\Users\\hello\\Downloads\\sample_960x400_ocean_with_audio.mjpeg");  // folder
////        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "video/mp4");  // MIME type
////        profile.setPreference("pdfjs.disabled", true);  // disable the built-in viewer
////        profile.setPreference("browser.download.folderList", 2);
////        profile.setPreference("browser.download.panel.shown", false);
////        profile.setPreference("browser.download.manager.showAlertOnComplete", "false");
//
//        profile.setPreference("browser.download.panel.shown", "false");
//        profile.setPreference("browser.helperApps.neverAsk.openFile","text/csv,application/vnd.ms-excel, sample_960x400_ocean_with_audio.mjpeg");
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/vnd.ms-excel, sample_960x400_ocean_with_audio.mjpeg");
//        profile.setPreference("browser.download.folderList", 2);
//        profile.setPreference("browser.download.dir", "c:\\firefox_downloads\\");
//
//        FirefoxOptions options1 = new FirefoxOptions();
//        options1.setProfile(profile);
//        options1.addPreference("permissions.default.microphone", 1);
//        options1.addPreference("permissions.default.camera", 1);
//        options1.setCapability("media.navigator.streams.fake", true);
//        options1.setCapability("browser", "Firefox");
//        options1.setCapability("browser_version", "latest");
//        options1.setCapability("os", "Windows");
//        options1.setCapability("os_version", "10");
//        options1.setCapability("build", "WebRTC Dummy Video Call Build - Chrome-FireFox");
//        options1.setCapability("name", "WebRTC Room Joining - FireFox Browser");
//        options1.setCapability("browserstack.idleTimeout", 300);
//        options1.setCapability("browserstack.user", "mohammedk1");
//         options1.setCapability("browserstack.key", "spBCpUJaVTnvxxssFtEJ");
//        options1.setCapability("browserstack.local", "true");
//        options1.setCapability("acceptSslCerts" , "true");


    @Test
    public void testWebRTC() throws MalformedURLException, InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--use-fake-device-for-media-stream"
                , "--use-fake-ui-for-media-stream"
                //, "--use-file-for-fake-video-capture=/Users/samiran/Downloads/sample_960x400_ocean_with_audio.mjpeg"
               // , "--use-file-for-fake-video-capture=C:\\Users\\hello\\Documents\\video\\sample_mjpeg.mjpeg"
                , "--use-file-for-fake-video-capture=C:\\Users\\hello\\Downloads\\sample_960x400_ocean_with_audio.mjpeg"
                ,"--use-file-for-fake-audio-capture=C:\\Users\\hello\\Documents\\audio\\250Hz_44100Hz_16bit_05sec.wav"
                //,"--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0"
                //, "--use-file-for-fake-video-capture=/sdcard/sample_960x400_ocean_with_audio.mjpeg"
                //, "--use-file-for-fake-audio-capture=C:\\Users\\hello\\Documents\\video\\saper.avi"
        );
        options.setCapability("browser", "Chrome");
        options.setCapability("browser_version", "latest");
        options.setCapability("os", "Windows");
        options.setCapability("os_version", "10");
        options.setCapability("build", "WebRTC Dummy Video Call Build - Chrome");
        options.setCapability("name", "test on "+options.getBrowserName());
        options.setCapability("browserstack.idleTimeout", 300);
        options.setCapability("browserstack.user", "mohammedk1");
        options.setCapability("browserstack.key", "spBCpUJaVTnvxxssFtEJ");
        options.setCapability("browserstack.local", "true");
        options.setCapability("acceptSslCerts" , "true");

         //For edge
        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments(
                "--use-fake-device-for-media-stream", "--use-fake-ui-for-media-stream",
                "--use-file-for-fake-video-capture=C:\\Users\\hello\\Downloads\\sample_960x400_ocean_with_audio.mjpeg",
                "--use-file-for-fake-audio-capture=C:\\Users\\hello\\Documents\\audio\\250Hz_44100Hz_16bit_05sec.wav");
        options1.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        options1.setCapability("browser", "Edge");
        options1.setCapability("browser_version", "latest");
        options1.setCapability("os", "Windows");
        options1.setCapability("os_version", "10");
        options1.setCapability("browserstack.idleTimeout", 300);
         options1.setCapability("browserstack.local", "true");
        options1.setCapability("browserstack.user", "mohammedk1");
        options1.setCapability("browserstack.key", "spBCpUJaVTnvxxssFtEJ");
        options1.setCapability("build", "WebRTC Dummy Video Call Build - Chrome-Edge");
        options1.setCapability("name", "test on edge");
        options1.setCapability("acceptSslCerts", "true");
    try {

        driver = new RemoteWebDriver(new URL(HUB_URL), options);
        driver.get("http://mdk_eibj521ukqr.browserstack.com/sample_960x400_ocean_with_audio.mjpeg");
        Thread.sleep(20000);
        driver.get("https://webrtc.github.io/samples/src/content/devices/input-output/");


        Thread.sleep(3000);







//        TakesScreenshot sc = ((TakesScreenshot)driver);
//        File srcFile = sc.getScreenshotAs(OutputType.FILE);
//        File destFile = new File("/path/to/store/the/sc.png");
//        FileUtils.copyFile(srcFile, destFile);








        //driver.findElement(By.id("start")).click();
        Thread.sleep(10000);
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        driver.quit();
    }



    }


}
