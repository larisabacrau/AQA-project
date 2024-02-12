package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By productTitle = By.xpath("//*[contains(text(),\"Onesie\")]");
    private By productDescription = By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
    private By productPrice = By.xpath("//div[@class=\"inventory_details_price\"]");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-onesie");

    public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }
    public String getProductDescription() {
        return driver.findElement(productDescription).getText();
    }
    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }
    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
}
