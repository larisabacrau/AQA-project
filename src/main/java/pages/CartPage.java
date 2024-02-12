package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;
    private By yourCart = By.xpath("//div[@class='header_secondary_container']/descendant::span[@class='title']");



    private By cartOnesieTitle = By.xpath("//*[contains(text(),\"Onesie\")]");
    private By removeButton = By.id("remove-sauce-labs-onesie");
    private By checkoutButton = By.id("checkout");

    private By quantity = By.xpath("//div[@class=\"cart_quantity\"] ");
    private By onesieDescription = By.xpath("//div[@class=\"inventory_item_desc\"]");
    private By onesiePrice = By.xpath("//div[@class=\"inventory_item_price\"]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRemove() {
        driver.findElement(removeButton).click();
    }

    public boolean checkOnesieInCart() {
        try {
            return driver.findElement(cartOnesieTitle).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public String getCartOnesieTitle() {
        return driver.findElement(cartOnesieTitle).getText();
    }
    public String getOnesieDescription() {
        return driver.findElement(onesieDescription).getText();
    }
    public String getQuantity() {
        return driver.findElement(quantity).getText();
    }

    public String getOnesiePrice() {
       return driver.findElement(onesiePrice).getText();
    }
}
