package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class HomePage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    //1. Capture elements on the page by its locator - Object Repository;
    /*// only Java support PageFactory method
    @FindBy(xpath = "//img[@alt='nopcommerce demo store']")
    WebElement logo;

    @FindBy(linkText = "Register")
    WebElement RegisterLink;

    //@FindBy(linkText = "Login")
    @FindBy(how = How.LINK_TEXT, using = "Login")
    WebElement LoginLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
     */

    private By logo = By.xpath("//img[@alt='nopCommerce demo store']");
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By wishlistLink = By.linkText("Wishlist");
    private By shoppingCart = By.linkText("Shopping Cart");
    private By searchField = By.id("small-searchterms");
    private By searchBtn = By.xpath("//button[text()='Search']");
    private By myAccountLink = By.linkText("My account");
    private By logoutLink = By.linkText("Log out");


    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    //2. method that performs action on the elements;
    public boolean verifyLogo() {
       //return driver.findElement(logo).isDisplayed();
        return elementUtil.doIsDisplayed(logo);
    }

    public String getPageTitle() {

        return driver.getTitle();
    }

    public boolean verifyRegisterLink() {
        //return driver.findElement(registerLink).isDisplayed();
        return elementUtil.doIsDisplayed(registerLink);
    }

    public RegisterPage goToRegisterPage() {
        //driver.findElement(registerLink).click();
        elementUtil.doClick(registerLink);
        return new RegisterPage(driver);
    }

    public boolean verifyLoginLink() {
        //return driver.findElement(loginLink).isDisplayed();
        return elementUtil.doIsDisplayed(loginLink);
    }

    // page chaining
    //public void gotoLoginPage() {
    public LoginPage goToLoginPage() {
        //driver.findElement(loginLink).click();
        elementUtil.doClick(loginLink);
        return new LoginPage(driver);
    }

    public boolean verifyMyAccountLink() {
        //return driver.findElement(myAccountLink).isDisplayed();
        return elementUtil.doIsDisplayed(myAccountLink);
    }

    public boolean verifyLogoutLink() {
        //return driver.findElement(logoutLink).isDisplayed();
        return elementUtil.doIsDisplayed(logoutLink);
    }

    public SearchPage doSearch(String keyword) {
        elementUtil.doSendKeys(searchField, keyword);
        elementUtil.doClick(searchBtn);
        return new SearchPage(driver);
    }


}
