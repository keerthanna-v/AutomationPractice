package com.automationpractice.pages;

import com.automationpractice.enums.ExplicitWaitStrategy;
import com.automationpractice.utils.UtilMethods;
import org.openqa.selenium.By;

public final class SignUpPage {


    private static final By TXT_NAME= By.name("name");
    private static final By TXT_SIGNUPEMAIL = By.xpath("//input[@name='email' and @data-qa='signup-email']");
    private static final By BTN_SIGNUP = By.xpath("//button[contains(text(),'Signup')]");


    public SignUpPage setName(String name)
    {
        UtilMethods.sendKeys(TXT_NAME,name);
        return this;
    }
    public SignUpPage setSignUpEmail(String email)
    {
        UtilMethods.sendKeys(TXT_SIGNUPEMAIL,email);
        return this;
    }
    public void clickSignUp()
    {
        UtilMethods.click(BTN_SIGNUP, ExplicitWaitStrategy.CLICKABLE,"signup link");
    }


}
