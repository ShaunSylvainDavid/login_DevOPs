package com.example.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoginApplicationTests {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/A12-64/WebDriver/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testLoginSuccess(){

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("Shaun");
        passwordField.sendKeys("licet");
        loginButton.click();
    }
    @Test
    public void testLoginFailure(){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        usernameField.sendKeys("testuser");
        passwordField.sendKeys("wrongpassword");
        loginButton.click();
    }
}