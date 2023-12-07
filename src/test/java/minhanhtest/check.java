package minhanhtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class check {
    @Test
    public void check() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://cms.anhtester.com/login");
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));;
        WebElement  passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        emailInput.sendKeys("admin@example.com");
        passwordInput.sendKeys("123456");
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")));
        WebElement menuHamburger = driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"));
        WebElement buttonProduct = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/a[1]/span[1]"));
        WebElement buttonAddproduct = driver.findElement(By.xpath("//span[contains(text(),'Add New Product')]"));
        menuHamburger.click();
        Thread.sleep(2000);
        buttonProduct.click();
        Thread.sleep(2000);
        buttonAddproduct.click();
    }
}
