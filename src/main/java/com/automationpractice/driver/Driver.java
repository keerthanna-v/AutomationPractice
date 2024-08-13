package com.automationpractice.driver;

import com.automationpractice.config.ConfigFactory;
import com.automationpractice.config.FrameworkConfig;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private Driver()
    {

    }

    public static void initDriver()
    {
       if(Objects.isNull(DriverManager.getDriver()))
       {
           WebDriver driver = DriverFactory.getDriver(ConfigFactory.getconfig().browser());
           DriverManager.setDriver(driver);
           DriverManager.getDriver().get(ConfigFactory.getconfig().url().trim());
           DriverManager.getDriver().manage().window().maximize();
       }
    }



    public static void quitDriver()
    {
      if(Objects.nonNull(DriverManager.getDriver()))
      {
          DriverManager.getDriver().quit();
          DriverManager.unload();
      }
    }
}
