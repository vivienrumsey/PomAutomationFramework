package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By genderMale = By.id("gender-male");
    private By genderFemale = By.id("gender-female");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By bDay = By.name("DateOfBirthDay");
    private By bMonth= By.name("DateOfBirthMonth");
    private By bYear = By.name("DateOfBirthYear");
    private By email = By.id("Email");
    private By companyName = By.id("Company");
    private By password = By.id("Password");
    private By conformPassword = By.id("ConfirmPassword");
    private By registerBtn = By.id("register-button");
    private By registerSuccessMessage = By.xpath("//div[@class='result']");
    private By continueBtn = By.xpath("//a[text()='Continue']");
    private By logoutBtn = By.linkText("Log out");

    public HomePage registerNewUser(String gender, String fName, String lName, String bDay, String bMonth, String bYear, String email, String companyName, String password,String confirmPassword) {

        if (gender.equalsIgnoreCase("male")) {
            elementUtil.doClick(genderMale);
        } else {
            elementUtil.doClick(genderFemale);
        }

        elementUtil.doSendKeys(this.firstName, fName);
        elementUtil.doSendKeys(this.lastName, lName);
        elementUtil.doSendKeys(this.bDay, bDay);
        elementUtil.doSendKeys(this.bMonth, bMonth);
        elementUtil.doSendKeys(this.bYear, bYear);
        elementUtil.doSendKeys(this.email, email);
        //elementUtil.doSendKeys(this.email, elementUtil.randomString(7)+email);
        elementUtil.doSendKeys(this.companyName, companyName);
        elementUtil.doSendKeys(this.password, password);
        elementUtil.doSendKeys(this.conformPassword, confirmPassword);
        elementUtil.doClick(registerBtn);
        elementUtil.waitFor(2000);
        elementUtil.doClick(continueBtn);
        elementUtil.waitFor(2000);
        elementUtil.doClick(logoutBtn);

        return new HomePage(driver);


    }


}
