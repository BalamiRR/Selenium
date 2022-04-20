package com.fuatkara.main;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginPage {

    @Test
    public void openBrowser(){
        //Set location of chromedriver
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");

        //Start session (open browser)
        WebDriver driver = new ChromeDriver();

        //Quit session (closes browser)
        driver.quit();
    }

    @Test
    public void navigation(){
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");

        // Start session (open browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("http://address-book-example.herokuapp.com");

        // Quit session (closes browser)
        driver.quit();
    }

    @Test
    public void findElement(){
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");

        // Start session (open browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("http://address-book-example.herokuapp.com");

        // Find Element
        driver.findElement(By.id("sign-in"));

        // Quit session (closes browser)
        driver.quit();
    }

    @Test
    public void findElement2(){
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");

        // Start session (open browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("http://address-book-example.herokuapp.com");

        // Ensure browser in correct state when finding element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sign-in")));

        //Take action on element
        signIn.findElement(By.id("sign-in"));

        // Quit session (closes browser)
        driver.quit();
    }


    @Test
    public void findErrorFfff(){
        // Set location of chromedriver
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");

        // Start session (open browser)
        WebDriver driver = new ChromeDriver();

        // Navigate
        driver.get("https://www.saucedemo.com/");

        // Ensure browser in correct state when finding element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));

        assertTrue(element.isDisplayed());
        // Quit session (closes browser)
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {

        @Override
        protected void failed(Throwable e, Description description){
            System.out.println(description.getMethodName() + ": Failed");
        }

        @Override
        protected void succeeded(Description description){
            System.out.println(description.getMethodName() + ": Succeeded");
        }
    };
}
