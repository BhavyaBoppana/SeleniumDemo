package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuy {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.bestbuy.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement searchitem = driver.findElement(By.id("gh-search-input"));
        searchitem.sendKeys("mobile");
        driver.findElement(By.className("header-search-button")).click();
        driver.findElement(By.id("soldout_facet-Exclude-Out-of-Stock-Items-0")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Motorola - moto g play 2024 64GB (Unlocked) - Sapphire Blue")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='c-button c-button-primary c-button-lg c-button-block " +
                "c-button-icon c-button-icon-leading add-to-cart-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("c-button-link continue-shopping")).click();
    }
}