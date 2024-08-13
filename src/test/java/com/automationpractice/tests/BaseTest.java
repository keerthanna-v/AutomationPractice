package com.automationpractice.tests;


import com.automationpractice.driver.Driver;
import com.automationpractice.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {



@BeforeTest
    protected void setup()
{
    Driver.initDriver();
}

@AfterTest
    protected void tearDown()
{
    Driver.quitDriver();
}
}
