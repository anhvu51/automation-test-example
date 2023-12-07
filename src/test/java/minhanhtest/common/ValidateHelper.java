package minhanhtest.common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ValidateHelper {
    private WebDriver driver;

    JavascriptExecutor js;

    public ValidateHelper(WebDriver driver2){
        this.driver = driver2;
        js = (JavascriptExecutor) driver;
    }

    public void setText(By element,String value){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);

    }
    public void clickElement(By element){
        driver.findElement(element).click();
        //js.executeScript("arguments[0].click();", element);
    }

}

