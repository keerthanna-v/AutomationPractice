package com.automationpractice.pages;

import com.automationpractice.driver.Driver;
import com.automationpractice.driver.DriverManager;
import com.automationpractice.enums.ExplicitWaitStrategy;
import com.automationpractice.utils.UtilMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class Headerbuttons {

    private static final By lnk_Home=By.xpath("//a[text()=' Home']");
    private static final By lnk_Products=By.xpath("//a[text()=' Products']");
    private static final By lnk_Cart=By.xpath("//a[text()=' Cart']");
    private static final By lnk_SignupOrLogin=By.xpath("//a[text()=' Signup / Login']");
    private static final By lnk_TestCases=By.xpath("//a[text()=' Test Cases']");
    private static final By lnk_ApiTesting=By.xpath("//a[text()=' API Testing']");
    private static final By lnk_VideoTutorials=By.xpath("//a[text()=' Video Tutorials']");
    private static final By lnk_ContactUs=By.xpath("//a[text()=' Contact us']");
    private static final By lnk_DeleteAccount=By.xpath("//a[text()=' Delete Account']");

    public Headerbuttons clickHome()
    {
        UtilMethods.click(lnk_Home, ExplicitWaitStrategy.CLICKABLE,"Home link");
        return this;
    }
    public Headerbuttons clickProducts()
    {
        UtilMethods.click(lnk_Products,ExplicitWaitStrategy.CLICKABLE,"Products link");
        return this;
    }
    public Headerbuttons clickcart()
    {
        UtilMethods.click(lnk_Cart,ExplicitWaitStrategy.CLICKABLE,"Cart link");
        return this;
    }
    public Headerbuttons clickSignupOrLogin()
    {
        UtilMethods.click(lnk_SignupOrLogin,ExplicitWaitStrategy.CLICKABLE,"SignUp button");
        return this;
    }
    public Headerbuttons clickTestCases()
    {
        UtilMethods.click(lnk_TestCases,ExplicitWaitStrategy.CLICKABLE,"TestCase button");
        return this;
    }

    public Headerbuttons clickVideoTutorials()
    {
        UtilMethods.click(lnk_VideoTutorials,ExplicitWaitStrategy.CLICKABLE,"Video tutorial");
        return this;
    }
    public Headerbuttons clickContactUs()
    {
        UtilMethods.click(lnk_ContactUs,ExplicitWaitStrategy.CLICKABLE,"Contact us link");
        return this;
    }
    public Headerbuttons clickDeleteAccount()
    {
        UtilMethods.click(lnk_DeleteAccount,ExplicitWaitStrategy.CLICKABLE," Delete account link");
        return this;
    }


}
