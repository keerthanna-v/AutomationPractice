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
    Headerbuttons head = new Headerbuttons();

    @Test(description = "TC01 verifying the new user signup page visible",dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    private void verifyNewUserSignupVisible(Map<String,String> map) {


        //Verify 'New User Signup!' is visible
        head.clickSignupOrLogin();
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("New User Signup!");

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        new SignUpPage().setName(map.get(ExcelColumns.NAME.toString())).setSignUpEmail(map.get(ExcelColumns.EMAIL.toString())).clickSignUp();
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("Enter Account Information");

        //Verify that 'ACCOUNT CREATED!' is visible
        reg.fillAccountDetails(map);
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("Account Created!");

        //Verify that 'Logged in as username' is visible
        reg.clickContinue();
        String username=DriverManager.getDriver().findElement(By.xpath("//a[contains(text(),'Logged in')]/b")).getText();
        Assertions.assertThat(map.get("NAME")).contains(username);

        // Verify that 'ACCOUNT DELETED!'
        head.clickDeleteAccount();
        Assertions.assertThat(DriverManager.getDriver().getPageSource()).contains("Account Deleted!");
        reg.clickContinue();

    }
    }

