package minhanhtest.testcases;

import minhanhtest.common.ExcelHelpers;
import minhanhtest.common.ValidateHelpers;
import minhanhtest.pages.CheckProduct;
import minhanhtest.pages.DashboardPage;
import minhanhtest.pages.SigninPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignIntest {
    private WebDriver driver;
    private ValidateHelpers validateHelper;
    private SigninPage signinPage;
    private DashboardPage dashboardPage;
    private CheckProduct checkProduct;
    private ExcelHelpers excelLine1;


    @Test (priority = 1)
    public void signIn() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        validateHelper = new ValidateHelpers(driver);
        signinPage = new SigninPage(driver);
        excelLine1 = new ExcelHelpers();
        driver.get("https://cms.anhtester.com/login");
        Thread.sleep(2000);
        excelLine1.setExcelFile("/Users/yuki-/IdeaProjects/ProjectMaven/src/test/resources/CMS.xlsx","Sheet1");
        System.out.println(excelLine1.getCellData("username",1));
        System.out.println(excelLine1.getCellData("password",1));
        dashboardPage = signinPage.signIn(excelLine1.getCellData("username",1),excelLine1.getCellData("password",1));
        Thread.sleep(2000);
    }
    @Test (priority = 2)
    public void allProductPage() throws InterruptedException {
        dashboardPage.allProduct();
    }
    @Test (priority = 3)
    public void checkSearchProduct() throws InterruptedException {
        checkProduct = new CheckProduct(driver);
        checkProduct.search("MINH");
        Thread.sleep(3000);
        checkProduct.checkSearch(2, "MINH");
    }
}

