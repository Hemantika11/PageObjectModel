package nopCommerce.Demo;

import nopCommerce.Demo.Base.BasePage;
import nopCommerce.Demo.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterPageTest
{
    WebDriver driver;
    BasePage basePage= new BasePage();
    Properties prop=new Properties();
    RegisterPage registerPage;

    @BeforeMethod
    public void openBrowser()
    {
        basePage=new BasePage();
        prop=basePage.initialiseProperties();
        String webEngine=prop.getProperty("browser");
        driver = basePage.initialiseDriver(webEngine);
        driver.get(prop.getProperty("url"));
        registerPage= new RegisterPage(driver);
    }

    @Test
    public void RegisterPageTest() throws InterruptedException
    {
        registerPage.clickDoRegisterLink();
        registerPage.clickOnGender();
        registerPage.doRegister(prop.getProperty("gender"),prop.getProperty("firstname"),prop.getProperty("lastname"),prop.getProperty("dayDOB"),prop.getProperty("monthDOB"),prop.getProperty("yearDOB"), prop.getProperty("email"),prop.getProperty("companyname"),prop.getProperty("password"),prop.getProperty("confirmpassword"));
        registerPage.clickOnRegister();

        Thread.sleep(5000);
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.close();

    }

}
