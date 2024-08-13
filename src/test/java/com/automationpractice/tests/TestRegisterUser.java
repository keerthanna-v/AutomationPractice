package com.automationpractice.tests;
import com.automationpractice.driver.DriverManager;
import com.automationpractice.pages.Headerbuttons;

import com.automationpractice.pages.RegisterPage;
import com.automationpractice.pages.SignUpPage;

import com.automationpractice.utils.DataProviderUtils;
import com.automationpractice.enums.ExcelColumns;
import org.assertj.core.api.Assertions;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Map;

public final class TestRegisterUser extends BaseTest {

    private TestRegisterUser() {}

    RegisterPage reg = new RegisterPage();
    @Test(description = "verifying the home page visible", priority = 1)
    private void verifyHomePageVisible() {
        String actual = DriverManager.getDriver().getTitle();
        String expected = "Automation Exercise";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test(description = "verifying the new user signup page visible", priority = 2)
    private void verifyNewUserSignupVisible() {
        new Headerbuttons().clickSignupOrLogin();
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("New User Signup!");
    }


    @Test(description = "verifying the enter account",priority = 3,dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    private void verifyEnterAccountinformationvisible(Map<String,String> map)
    {
        new SignUpPage().setName(map.get(ExcelColumns.NAME.toString())).setSignUpEmail(map.get(ExcelColumns.EMAIL.toString())).clickSignUp();
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("Enter Account Information");
    }

    @Test(priority = 4,dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    private void verifyAccountCreation(Map<String,String> map) {
       reg.fillAccountDetails(map);
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("Account Created!");
    }

    @Test(priority = 5,dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
    private void verifyLoggedInName(Map<String,String> map)
    {
        reg.clickContinue();
        String username=DriverManager.getDriver().findElement(By.xpath("//a[contains(text(),'Logged in')]/b")).getText();
        Assertions.assertThat(map.get("NAME")).isEqualTo(username);
    }

    @Test(priority = 6)
    private void verifyAccountDeletion()
    {
        new Headerbuttons().clickDeleteAccount();
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("Account Deleted!");
        reg.clickContinue();

    }







}
