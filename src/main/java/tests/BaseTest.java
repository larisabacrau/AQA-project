package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import testdata.User;


import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;

    public LoginPage loginPage;
    public ProductsPage productsPage;
    public CheckoutYourInformationPage checkoutYourInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public CheckoutCompletePage checkoutCompletePage;
    public CartPage cartPage;
    public HeaderPage headerPage;
    public ProductPage productPage;

    public User standardUser = new User("login_valid");
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        //wait implicit
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        cartPage = new CartPage(driver);
        headerPage = new HeaderPage(driver);
        productPage = new ProductPage(driver);

        driver.get("https://www.saucedemo.com/");

    }
    @After
    public void tearDown() {
        driver.close();
    }
}
