package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class FlipkartAutomation {
    public static void main(String[] args) throws InterruptedException {
//open flipcart
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.flipkart.com/");
            driver.manage().window().maximize();
//search for mobile phones
            WebElement searchInput = driver.findElement(By.className("Pke_EE"));
            searchInput.sendKeys("mobile phones");
            searchInput.submit();
//add numphone mobile phoes to cart
            String mainpage = driver.getWindowHandle();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/search"));
            // Get the list of mobile elements
            List<WebElement> mobileElements = driver.findElements(By.cssSelector("a[rel='noopener noreferrer']"));
            // Add the first three mobiles to the cart
            int numphone = 3;
            for (int i = 0; i < numphone && i < mobileElements.size(); i++) {
                WebElement mobileLink = mobileElements.get(i);
                mobileLink.click();
                Set<String> allpage = driver.getWindowHandles();
                for (String page : allpage) {
                    if (!page.equals(mainpage)) {
                        driver.switchTo().window(page);
                        break;
                    }
                }
                WebElement addtocart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
                addtocart.click();
                Thread.sleep(3000);
                driver.close();
                driver.switchTo().window(mainpage);
                mobileLink.sendKeys(Keys.F5);
                Thread.sleep(5000);
            }
//remove numphone mobile phoes from cart
            driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
            for (int i = 0; i < numphone; i++) {
                List<WebElement> removeButtons = new WebDriverWait(driver, Duration.ofSeconds(25)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='sBxzFz' and text()='Remove']")));
                WebElement removebutton = removeButtons.get(0);
                Thread.sleep(2000);
                if (i<numphone-1) {
                    Actions actions = new Actions(driver);
                    actions.moveToElement(removebutton).click().perform();
                    Thread.sleep(2000);
                }
                else {
                    JavascriptExecutor js=(JavascriptExecutor)driver;
                    js.executeScript("arguments[0].scrollIntoView(true);", removebutton);
                    Thread.sleep(5000);  // Wait for the scroll to complete
                    removebutton.click();
                }
                    // Confirm the removal
                    WebElement confirmRemoveButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                            .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sBxzFz fF30ZI A0MXnh']")));
                    Thread.sleep(2000);
                    confirmRemoveButton.click();
                    Thread.sleep(8000);
                    driver.get("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
                }
        } finally {
            driver.quit();
        }
    }
}