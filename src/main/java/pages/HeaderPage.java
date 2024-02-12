package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderPage {
    public WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }
    private By logo = By.xpath("//div[@class=\"app_logo\"]");
    private By menuButton = By.xpath("//button[@id=\"react-burger-menu-btn\"]");
    private By cart = By.xpath("//a[@class=\"shopping_cart_link\"]");

    private By secondHeaderText = By.xpath("//span[@class=\"title\"]");
    private By filter = By.xpath("//select[@class=\"product_sort_container\"]");
    private By filterAToZ = By.xpath("//option[@value=\"az\"]");
    private By filterZToA = By.xpath("//option[@value=\"za\"]");
    private By filterPriceLowToHigh = By.xpath("//option[@value=\"lohi\"]");
    private By filterPriceHighToLow = By.xpath("//option[@value=\"hilo\"]");

    private By allItems = By.xpath("//a[@id=\"inventory_sidebar_link\"]");
    private By about = By.xpath("//a[@id=\"about_sidebar_link\"]");
    private By logout = By.xpath("//a[@id=\"logout_sidebar_link\"]");
    private By resetAppState = By.xpath("//a[@id=\"reset_sidebar_link\"]");
    private By backToProductsButton = By.xpath("//button[@id=\"back-to-products\"]");


    public String getTitle() {
        return driver.findElement(secondHeaderText).getText();
    }
    public void openMenu() {
        driver.findElement(menuButton).click();
    }
    public void logout() {
        openMenu();
        driver.findElement(logout).click();
    }
    public void clickBackToProducts() {
        driver.findElement(backToProductsButton).click();
    }
    public void openCart() {
        driver.findElement(cart).click();
    }
    public void openFilterMenu() {
        driver.findElement(filter).click();
    }
    public void clickAToZ() {
        driver.findElement(filterAToZ).click();
    }
    public void clickZToA() {
        driver.findElement(filterZToA).click();
    }
    public void clickPriceLowToHigh() {
        driver.findElement(filterPriceLowToHigh).click();
    }
    public void clickPriceHighToLow() {
        driver.findElement(filterPriceHighToLow).click();
    }
}


