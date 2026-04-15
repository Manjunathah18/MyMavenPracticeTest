package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // Set Chrome options for Jenkins/Linux
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--no-sandbox"); // Required for Jenkins/Linux
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--remote-allow-origins=*"); // Avoid connection issues

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open URL
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();

            // Wait for page load
            Thread.sleep(3000);

            // Enter username
            driver.findElement(By.id("username")).sendKeys("student");

            // Enter password
            driver.findElement(By.id("password")).sendKeys("Password123");

            // Click login
            driver.findElement(By.id("submit")).click();

            // Wait to observe result
            Thread.sleep(5000);

            // Print title (for verification in Jenkins logs)
            System.out.println("Page Title: " + driver.getTitle());

        } finally {
            // Close browser
            driver.quit();
        }
    }
}
