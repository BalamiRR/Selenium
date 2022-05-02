package com.fuatkara.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class WebDriverMethod {
    WebDriver driver;
    WebElement element;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    //Get that link => https://the-internet.herokuapp.com/dropdown
    //Select the option 1 from the dropdown
    //Assert that option 1 is selected
    //Assert that option 2 is NOT selected
    @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
            element.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));  // <option value="1">
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        //    WebElement option1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("option[value='1']")));  // <option value="1">
        //    WebElement option2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("option[value='2']")));
        option1.click();
        assertTrue(option1.isSelected());
        assertFalse(option2.isSelected());
    }

    @Test
    public void hover(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        element = driver.findElement(By.xpath("//*[contains(text(), 'name: user1')]"));
        assertTrue("user1 should appear because we hovered over that image", element.isDisplayed());
    }

    @Test
    public void rightClick(){
        driver.navigate().to("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();  // contextClick is also rightClick
        driver.switchTo().alert().accept();
    }
    //3:0:31
    @Test
    public void keyPresses(){
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target")); //elementi id'si target olani bul
        element.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_RIGHT).pause(1000).perform();

        element = driver.findElement(By.id("result"));
        assertEquals("Click", "You entered: RIGHT", element.getText());
    }

    @Test
    public void getCSSValue(){
        driver.navigate().to("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.linkText("Clickable Icon"));

        String link = element.getAttribute("href");
        assertEquals("https://ultimateqa.com/link-success/",link);

        assertEquals("padding-box",element.getCssValue("background-origin"));

    }


}
