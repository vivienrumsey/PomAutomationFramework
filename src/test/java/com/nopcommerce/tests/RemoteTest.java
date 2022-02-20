package com.nopcommerce.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteTest {
    @Test
    public void chromeTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, dc);
        //driver.get("https://demo.nopcommerce.com/");
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium grid");
        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        driver.quit();


    }


}
