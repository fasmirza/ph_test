package org.example;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class ph {

    public static AppiumDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        // This is the configuration for starting the Test Session
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Redmi note 8");
        options.setPlatformVersion("11.0");
        options.setApp("D:\\EclipsProject\\PH_test\\src\\main\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

    }

    @Test
    public void runTest() {
        try {
            /*initially it will wait for two second for this element incase of Element doesn't appear
             *  and it is true for every element used in this test
             * */

            WebElement accesWE = driver.findElement(new AppiumBy.ByAccessibilityId("Views"));

            createWait(accesWE, 2);

            accesWE.click();

            Thread.sleep(Duration.ofSeconds(2));

            Assert.assertTrue("Accessiblity Clicked", true);
            System.out.println("\"Accessiblity Clicked\"");


            //Scroll to Expandable list
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Expandable Lists\"));")).click();

            Assert.assertTrue("Scroll to Expandable and Clicked", true);
            //Custom Adapter Selection
            WebElement customAdapter = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"1. Custom Adapter\")"));

            createWait(customAdapter, 2);

            customAdapter.click();

            Assert.assertTrue("Custom Adapter Clicked", true);
            System.out.println("Custom Adapter Clicked");

            //inside Custom Adapter
            WebElement firstElement = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"People Names\")"));

            createWait(firstElement, 2);

            //I used Selenium Action method to long press the Element
            Actions actions = new Actions(driver);
            actions.clickAndHold(firstElement).pause(Duration.ofSeconds(2)).release().perform();
            Assert.assertTrue("Long Clicked to First Element", true);
            System.out.println("Long Clicked to First Element");


            /*executing 3 backs to navigate to View Elements*/
            driver.navigate().back();
            Thread.sleep(Duration.ofSeconds(1));
            driver.navigate().back();
            Thread.sleep(Duration.ofSeconds(1));
            driver.navigate().back();

            Thread.sleep(Duration.ofSeconds(1));


            //Scroll to Drag and Drop
            driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Drag and Drop\"));")).click();


            WebElement firstCircle = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_1\")"));
            WebElement secondCircle = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"io.appium.android.apis:id/drag_dot_2\")"));

            createWait(firstCircle, 2);

            /*Used selenium Action Class to Hold Drag and Drop the Circle*/

            Actions ddaction = new Actions(driver);
            ddaction.clickAndHold(firstCircle)
                    .pause(Duration.ofSeconds(2))
                    .moveToElement(secondCircle)
                    .release()
                    .perform();



            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("D:\\EclipsProject\\PH_test\\src\\main\\resources\\screenshot.png"));


            Assert.assertTrue("Automation Success", true);
            System.out.println("Automation Success");





        } catch (NoSuchElementException | InterruptedException e) {
            Assert.fail("One or multiple element not found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void finishTest() {
        driver.quit();
    }


    /*This method is to create Explicit wait */
    private static void createWait(WebElement element, int duration) {
        WebDriverWait waitaccesWE = new WebDriverWait(driver, Duration.ofSeconds(duration));
        waitaccesWE.until(ExpectedConditions.visibilityOf(element));
    }


}
