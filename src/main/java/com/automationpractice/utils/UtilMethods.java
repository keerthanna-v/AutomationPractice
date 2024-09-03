package com.automationpractice.utils;

import com.automationpractice.config.ConfigFactory;
import com.automationpractice.driver.DriverManager;
import com.automationpractice.enums.ExplicitWaitStrategy;
import com.automationpractice.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class UtilMethods {

    public static String getXpath(String menuitem,String value)
    {
        return menuitem.replace("%value%",value);
    }

    public  static void click(By by, ExplicitWaitStrategy wait,String text)
    {
        WebElement element = null;
        if(wait.toString().toLowerCase().contains("clickable")) {
            element = waitUntilElementClickable(by);

        } else if (wait.toString().toLowerCase().contains("presence")) {
             element= waitUntilElementPresence(by);

        } else if (wait.toString().toLowerCase().contains("visibility")) {
         element=waitUntilElementVisbility(by);

        }

        Objects.requireNonNull(element).click();
        ExtentLogger.pass(text+" clicked");

    }
    public static void click(By by)
    {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].click()",DriverManager.getDriver().findElement(by));
    }

    public static void sendKeys(By by,String name)
    {
        waitUntilElementVisbility(by).sendKeys(name);
       // DriverManager.getDriver().findElement(by).sendKeys(name);
    }

    public static void select(By by,String name)
    {
        Select drp = new Select(DriverManager.getDriver().findElement(by));
        drp.selectByValue(name);
    }

    public static WebElement waitUntilElementClickable(By by)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),(Duration.ofSeconds(ConfigFactory.getconfig().timeout())));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static WebElement waitUntilElementPresence(By by)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),(Duration.ofSeconds(ConfigFactory.getconfig().timeout())));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static WebElement waitUntilElementVisbility(By by)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),(Duration.ofSeconds(ConfigFactory.getconfig().timeout())));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
