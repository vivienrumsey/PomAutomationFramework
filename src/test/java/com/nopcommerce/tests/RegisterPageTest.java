package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    @BeforeMethod
    public void registerPageSetup() {
        registerPage = homePage.goToRegisterPage();
    }

    @Test(dataProvider = "getUserData")
    public void registerNewUserTest(String gender, String fName, String lName, String bDay, String bMonth, String bYear, String email, String companyName, String password,String confirmPassword) {
        registerPage.registerNewUser(gender, fName, lName, bDay, bMonth, bYear, email, companyName, password, confirmPassword);
        Assert.assertTrue(homePage.verifyMyAccountLink());

    }

    @DataProvider
    public Object[][] getUserData() {
        Object data[][] = ExcelUtil.getTestData("Sheet1");
        return data;
    }

}
