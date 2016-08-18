package com.example.android.courtcounter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

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
        capabilities.setCapability("deviceName","Nexus_5X_API_23");
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
    public void ThreePointTest(){
        AndroidElement teamALabel = (AndroidElement)driver.findElementById("com.example.android.courtcounter:id/team_a_score");
        AndroidElement teamBLabel = (AndroidElement)driver.findElementById("com.example.android.courtcounter:id/team_b_score");

        driver.findElement(By.id("com.example.android.courtcounter:id/btnTeamA3Pts")).click();
        driver.findElement(By.id("com.example.android.courtcounter:id/btnTeamB3Pts")).click();

        assertEquals("3",teamALabel.getText());
        assertEquals("3",teamBLabel.getText());
    }

    @Test
    public void TwoPointTest(){
        AndroidElement teamALabel = (AndroidElement)driver.findElement(By.name("Team A Score"));
        AndroidElement teamBLabel = (AndroidElement)driver.findElement(By.name("Team B Score"));

        driver.findElement(By.name("Team A 2 Points")).click();
        driver.findElement(By.name("Team B 2 Points")).click();

        assertEquals("2",teamALabel.getText());
        assertEquals("2",teamBLabel.getText());
    }

    @Test
    public void FreeThrow(){
        AndroidElement teamALabel = (AndroidElement)driver.findElement(By.name("Team A Score"));
        AndroidElement teamBLabel = (AndroidElement)driver.findElement(By.name("Team B Score"));

        driver.findElement(By.name("Team A Free Throw")).click();
        driver.findElement(By.name("Team B Free Throw")).click();

        assertEquals("1",teamALabel.getText());
        assertEquals("1",teamBLabel.getText());
    }

    @After
    public void TearDown(){
        driver.quit();
    }
}