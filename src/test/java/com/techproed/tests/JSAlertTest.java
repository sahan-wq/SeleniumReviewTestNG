package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    WebDriver diriver;
    @BeforeTest
    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        diriver= new ChromeDriver();
        diriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        diriver.manage().window().maximize();


    }
    @Test
    public void test01() throws InterruptedException {
        diriver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton = diriver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton.click();

        String mesaj = diriver.switchTo().alert().getText();
        System.out.println(mesaj);
        Thread.sleep(2000);

        diriver.switchTo().alert().sendKeys("Selamlar");
        diriver.switchTo().alert().accept();// kabul et
        //diriver.switchTo().alert().dismiss(); bu da olabilir. vazgec dismiss


    }

}
