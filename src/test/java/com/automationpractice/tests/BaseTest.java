package com.automationpractice.tests;
import com.automationpractice.driver.Driver;
import com.automationpractice.driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class BaseTest {


@BeforeTest
    protected void setup()
{

    Driver.initDriver();
    String actual = DriverManager.getDriver().getTitle();
    String expected = "Automation Exercise";
    Assertions.assertThat(actual).isEqualTo(expected);
}

@AfterTest
    protected void tearDown()
{
    Driver.quitDriver();
}
}
