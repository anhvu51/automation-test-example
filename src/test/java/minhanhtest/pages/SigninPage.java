package minhanhtest.pages;

import minhanhtest.common.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage {
    private WebDriver driver;
    private ValidateHelpers validateHelper;
    private By emailInput = By.xpath("//input[@id='email']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");

    public SigninPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelpers(driver);
    }
    public DashboardPage signIn(String email, String password) {
        validateHelper.setText(emailInput,email);
        validateHelper.setText(passwordInput,password);
        validateHelper.clickElement(loginButton);
        return new DashboardPage(driver);
    }

}
