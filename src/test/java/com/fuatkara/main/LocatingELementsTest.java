package com.fuatkara.main;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class LocatingELementsTest {

    WebDriver driver;   // driver:"ChromeDriver: chrome on MAC (null)"

    @Before
    public void setUp(){
        //Telling the system where to find chromdriver. On windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        //1. Instantiate the driver
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        //7. quit the driver
        driver.quit();
    }

    @Test
    public void elementsQuiz1(){
        //2.navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element // 4. check the state
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        //5. take action //6. record the result
        assertTrue(element.isDisplayed());
    }

    @Test
    public void typesOfLocators(){
        // 2. navigate to the URL
        driver.get("https://www.saucedemo.com/");
        // 3. Find Element
        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //Name
        //driver.findElement(By.id("name of Locator"));
        //Class name
        driver.findElement(By.className("form_input"));
        //Tag name
        driver.findElement(By.tagName("input"));
        //Css selector
        //#user-name
        driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        // //*[@id="user-name"]
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));

        //Telling the system where to find chromdriver. On Windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        // 1. Instanciate the driver
        driver = new ChromeDriver();
        // 2. navigate to the URL
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        // Partial link text
        driver.findElement(By.partialLinkText("link text!"));
    }

    @Test
    public void locatorExam(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 2. navigate to the URL
        driver.get("https://www.saucedemo.com/");

        //USE CSS Selectors
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector(".btn_action")).click();

        //Use CSS/Xpath
        //Here choosing the inventory
        driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']")).click();
        //And then clicking on the button
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();

        //Use the best locator
        driver.findElement(By.id("first-name")).sendKeys("first name");
        driver.findElement(By.id("last-name")).sendKeys("last name");
        driver.findElement(By.id("postal-code")).sendKeys("zip");
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();

        driver.findElement(By.cssSelector(".btn_medium.cart_button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".btn_primary.btn_small")).isDisplayed());
    }
}

