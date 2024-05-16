package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        //EdgeDriver driver=new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.id("APjFqb")).sendKeys("Selenium webdriver download",Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("gsr")).click();
    }
}
