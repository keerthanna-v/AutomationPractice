package com.automationpractice.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class DriverFactory {
    
    private DriverFactory()
    {
        
    }
    
    public static WebDriver getDriver(String browser)
    {
        WebDriver driver;
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();
        }
        else {
            driver=new FirefoxDriver();
        }
        return driver;
    }
}
