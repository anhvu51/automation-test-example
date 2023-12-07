package minhanhtest.pages;

import minhanhtest.common.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private ValidateHelpers validateHelper;
    private CheckProduct checkProduct;

    private By hamburgerMenu = By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]");
    private By productbutton = By.xpath("//body/div[1]/div[1]/div[1]/div[2]/ul[2]/li[1]/a[1]/span[1]");
    private By allproduct = By.xpath("//span[contains(text(),'All products')]");


    public  DashboardPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelpers(driver);
    }

    public CheckProduct allProduct() throws InterruptedException {

        validateHelper.waitClickable(hamburgerMenu);
        validateHelper.clickElement(hamburgerMenu);

        validateHelper.waitClickable(productbutton);
        validateHelper.clickElement(productbutton);

        validateHelper.waitClickable(allproduct);
        validateHelper.clickElement(allproduct);
        Thread.sleep(2000);

        return new CheckProduct(driver);
   }

}
