package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest extends TestBase {
    @Test
    public void sagTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        WebElement rightlickMe = driver.findElement(By.xpath("//*[.='right click me']"));
        actions.contextClick(rightlickMe).perform();
    }

    @Test
    public void ciftTiklama() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        Actions actions = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.tagName("button"));
        actions.doubleClick(doubleClick).perform();

    }

    @Test
    public void hoverOver() { // mouse'u bir webelementin üzerine götürme
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        // <a href="" class="nav-a nav-a-2" data-nav-ref="nav_ya_signin"
        // data-nav-role="signin" data-ux-jq-mouseenter="true"
        // id="nav-link-accountList" tabindex="0">
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        actions.moveToElement(accountList).perform();
    }

    @Test
    public void asagiYukariGitme() {
        driver.get("http://amazon.com");
        Actions actions = new Actions(driver);
        //web sayfasının en altına gitmek için
        actions.sendKeys(Keys.END).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //web sayfasında yukarı çıkmak istiyorsak
        //1. YÖNTEM -> PAGE_UP butonu
        actions.sendKeys(Keys.PAGE_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //2. YÖNTEM -> ARROW_UP (yukarı yön tuşu)
        actions.sendKeys(Keys.ARROW_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(Keys.ARROW_UP).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // aşağı gitmek için kullanılıyor
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // alt yön tuşunu kullanarak, aşağı gidebilirsiniz
        actions.sendKeys(Keys.ARROW_DOWN).perform();
    }

    @Test
    public void keyUpKeyDown() {
        // MERHABA nasılsınız
        // shift'e basılı tutarak merhaba               -> MERHABA
        // shift'ten elimizi kaldıracağız nasılsınız    -> nasılsınız
        driver.get("http://google.com");
        Actions actions = new Actions(driver);
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        // aramaKutusu.sendKeys("merhaba nasılsınız");
        actions.moveToElement(aramaKutusu)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("merhaba ")
                .keyUp(Keys.SHIFT)
                .sendKeys("nasılsınız")
                .perform();
    }
    @Test
    public void ikiTusaAyniAndaTiklama(){
        driver.get("http://google.com");
        Actions actions = new Actions(driver);

        // ALT + F4 : sayfayı kapatması gerekiyor
        actions.keyDown(Keys.ALT)
                .keyDown(Keys.F4)
                .perform();
    }

}