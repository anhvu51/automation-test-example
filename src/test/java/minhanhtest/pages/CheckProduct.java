package minhanhtest.pages;

import minhanhtest.common.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CheckProduct {
    private WebDriver driver;
    private ValidateHelpers validateHelper;

    private By addProductButton = By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/a[1]/span[1]");
    private By searchBox = By.xpath("//input[@id='search']");

    public CheckProduct(WebDriver driver) {
        this.driver= driver;
        validateHelper = new ValidateHelpers(driver);

    }
    public void search(String value){
    validateHelper.setText(searchBox,value);
        Actions enterAction = new Actions(driver);
        enterAction.sendKeys(Keys.ENTER).build().perform();
    }
    public void checkSearch(int column, String value){
       List<WebElement> row = driver.findElements(By.xpath("//table//tbody//tr"));
       int totalrow = row.size ();
       for (int i = 1 ; i<=totalrow;i++){
        WebElement stockCheck = driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+ column+"]"));
        Assert.assertTrue(stockCheck.getText() .contains(value),"Not contains the value search");
       }
    }

}
