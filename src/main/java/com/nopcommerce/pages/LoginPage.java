package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    //identify elements
    private By loginPageName = By.xpath("//div[@class='page-title']/h1");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By rememberMeCheckbox = By.id("RememberMe");
    private By loginBtn = By.xpath("//button[text()='Log in']");
    private By registerBtn = By.xpath("//button[text()='Register']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getLoginPageName() {
        //return driver.findElement(loginPageName).getText();
        return elementUtil.doGetText(loginPageName);
    }

    // page chaining - if an action takes you to a new page,
    // return type of the action must be object of landing page
    public HomePage doLogin(String userID, String password) {
        //driver.findElement(emailField).sendKeys(userID);
        elementUtil.doSendKeys(emailField, userID);
        //driver.findElement(passwordField).sendKeys(password);
        elementUtil.doSendKeys(passwordField, password);
        //driver.findElement(loginBtn).click();
        elementUtil.doClick(loginBtn);
        return new HomePage(driver);

    }

    public boolean verifyRegisterButtonStatus() {
        //return driver.findElement(registerBtn).isDisplayed();
        return elementUtil.doIsDisplayed(registerBtn);
    }



}
