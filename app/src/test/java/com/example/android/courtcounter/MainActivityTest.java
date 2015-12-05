package com.example.android.courtcounter;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

import static org.junit.Assert.*;

/**
 * Created by johnl on 12/4/15.
 */
public class MainActivityTest {

    private static final int SHORT_TIMEOUT = 2;

    private AndroidDriver driver;


    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.example.android.courtcounter");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("app", "/Users/johnl/Developer/court-counter/app/build/outputs/apk/app-debug.apk");
        capabilities.setCapability("deviceName","Google Nexus 5 - 5.0.0 - API 21 - 1080x1920 - 5.0");
        URL host = null;
        try {
            host = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver (host, capabilities);

        driver.manage().timeouts().implicitlyWait(SHORT_TIMEOUT, TimeUnit.SECONDS);

    }
    @Test
    public void ClickTest(){
        driver.findElement(By.id("com.example.android.courtcounter:id/btnTeamA3Pts")).click();
        driver.findElement(By.id("com.example.android.courtcounter:id/btnTeamB3Pts")).click();
    }
}