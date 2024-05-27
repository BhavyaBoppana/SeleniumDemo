package LinkedIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.time.Duration;

public class LinkedInJobApplication {
    public static void main(String[] args) throws InterruptedException {
        ReadExcel readExcel=new ReadExcel();
        String excelPath="D:\\Courses\\Java and Selenium\\Excel Uname\\LinkedIn.xlsx";
        String url=readExcel.readExceldata(excelPath,0,1,0);
        String Email=readExcel.readExceldata(excelPath,0,1,1);
        String Password=readExcel.readExceldata(excelPath,0,1,2);
        WebDriver driver= getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement sessionEmail= driver.findElement(By.id("username"));
        sessionEmail.sendKeys(Email);
        WebElement sessionPassword=driver.findElement(By.id("password"));
        sessionPassword.sendKeys(Password);
        driver.findElement(By.cssSelector("button[aria-label='Sign in']")).click();

        wait.until(ExpectedConditions.urlContains("/feed"));
        WebElement job= driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/jobs/?']"));
        job.click();
        wait.until(ExpectedConditions.urlContains("/jobs"));
        WebElement role= driver.findElement(By.xpath("//input[@autocomplete='organization-title']"));
        role.sendKeys("Quality Assurance");
        WebElement location= driver.findElement(By.xpath("//input[@autocomplete='address-level2']"));
        location.sendKeys("United States", Keys.ENTER);
        WebElement easyApply = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Easy Apply filter.']")));
        easyApply.click();
        Thread.sleep(5000);
        // Click on the "Date posted" filter button
        WebElement datePostedFilter = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchFilter_timePostedRange")));
        datePostedFilter.click();

        // Click on the "Past 24 hours" option
        WebElement past24HoursOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='timePostedRange-r86400']")));
        past24HoursOption.click();

        // Apply the filter
        WebElement applyFilterButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("artdeco-button artdeco-button--2 artdeco-button--primary ember-view ml2")));
        applyFilterButton.click();
    }

    private static ChromeDriver getDriver() {
        return new ChromeDriver();
    }
}
