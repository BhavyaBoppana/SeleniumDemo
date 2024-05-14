package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Ex1 {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        //EdgeDriver driver=new EdgeDriver();
        driver.get("https://www.google.com/");
    }
}
