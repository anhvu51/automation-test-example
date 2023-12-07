package minhanhtest.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class baseSetup {
    private WebDriver driver;

    @Test
    public void abc() {
        System.out.println("Check");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://kenh14.vn/");
        WebElement homebutton = driver.findElement(By.xpath("//body/form[@id='form1']/div[@id='admWrapsite']/div[2]/div[2]/div[1]/div[1]/a[1]"));
        homebutton.click();
        System.out.println("Print out ");
    }
}
