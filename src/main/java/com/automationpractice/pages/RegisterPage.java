package com.automationpractice.pages;


import com.automationpractice.enums.ExcelColumns;
import com.automationpractice.utils.UtilMethods;
import org.openqa.selenium.By;

import java.util.Map;

public final class RegisterPage {

  // private static final By TXTBOX_NAME=By.id("name");
   //private static final By TXTBOX_EMAIL=By.id("email");
    private static final By TXTBOX_PASSWORD=By.id("password");
    private static final By TXTBOX_FIRSTNAME=By.id("first_name");
    private static final By TXTBOX_LASTNAME=By.id("last_name");
    private static final By TXTBOX_COMPANY=By.id("company");
    private static final By TXTBOX_ADDRESS=By.id("address1");
    private static final By TXTBOX_STATE=By.id("state");
    private static final By TXTBOX_CITY=By.id("city");
    private static final By TXTBOX_ZIPCODE=By.id("zipcode");
    private static final By TXTBOX_MOBILENUMBER=By.id("mobile_number");
    private static final By DRPDOWN_COUNTRY = By.id("country");
    private static final By DRPDOWN_DAY =By.id("days");
    private static final By DRPDOWN_MONTH =By.id("months");
    private static final By DRPDOWN_YEAR =By.id("years");
    private static final By BTN_CREATEACCOUNT = By.xpath("//button[contains(text(),'Create Account')]");
    private static final By BTN_CONTINUE=By.xpath("//a[contains(text(),'Continue')]");
    public void fillAccountDetails(Map<String, String> map)
    {
            UtilMethods.sendKeys(TXTBOX_PASSWORD, map.get(ExcelColumns.PASSWORD.toString()));
            UtilMethods.select(DRPDOWN_DAY,map.get(ExcelColumns.DAY.toString()));
            UtilMethods.select(DRPDOWN_MONTH,map.get(ExcelColumns.MONTH.toString()));
            UtilMethods.select(DRPDOWN_YEAR,map.get(ExcelColumns.YEAR.toString()));
            UtilMethods.sendKeys(TXTBOX_FIRSTNAME,map.get(ExcelColumns.FIRSTNAME.toString()));
            UtilMethods.sendKeys(TXTBOX_LASTNAME,map.get(ExcelColumns.LASTNAME.toString()));
            UtilMethods.sendKeys(TXTBOX_COMPANY,map.get(ExcelColumns.COMPANY.toString()));
            UtilMethods.sendKeys(TXTBOX_ADDRESS,map.get(ExcelColumns.ADDRESS.toString()));
            UtilMethods.sendKeys(TXTBOX_STATE,map.get(ExcelColumns.STATE.toString()));
            UtilMethods.sendKeys(TXTBOX_CITY,map.get(ExcelColumns.CITY.toString()));
            UtilMethods.sendKeys(TXTBOX_ZIPCODE,map.get(ExcelColumns.ZIPCODE.toString()));
            UtilMethods.sendKeys(TXTBOX_MOBILENUMBER,map.get(ExcelColumns.MOBILENUMBER.toString()));
            UtilMethods.select(DRPDOWN_COUNTRY,map.get(ExcelColumns.COUNTRY.toString()));
            UtilMethods.click(BTN_CREATEACCOUNT);
            
    }

    public void clickContinue()
    {
        UtilMethods.click(BTN_CONTINUE);
    }




}
