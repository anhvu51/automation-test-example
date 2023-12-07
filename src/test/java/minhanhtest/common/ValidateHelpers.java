package minhanhtest.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ValidateHelpers {
    private WebDriver driver;
//    public WebDriver getDriver() {return driver;}
    public ValidateHelpers(WebDriver driver) {
        this.driver = driver;
    }

    public void setText(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    public void clickElement(By element) {
        driver.findElement(element).click();
    }

    public boolean clarifyDashboard(By element, String textvalue){
    return driver.findElement(element).getText().equals(textvalue);
    }
    public void waitClickable(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}
