package com.fuatkara.main;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingELementsTest {

    WebDriver driver;   // driver:"ChromeDriver: chrome on MAC (null)"

    @Before
    public void setUp(){
        //Telling the system where to find chromdriver. On windows you also need to add .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Instantiate the driver
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        
    }
}
