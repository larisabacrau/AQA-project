package org.automation.pages;

import org.automation.testdata.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By productTitle = By.xpath("//*[contains(text(),\"Onesie\")]");
    private By productDescription = By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
    private By productPrice = By.xpath("//div[@class=\"inventory_details_price\"]");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-onesie");
    private By removeButton = By.id("remove-sauce-labs-onesie");

    public Product getProductDetails() {
        String title = driver.findElement(productTitle).getText();
        String desc = driver.findElement(productDescription).getText();
        String price = driver.findElement(productPrice).getText();
        return new Product(title, desc, price);
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }
    public void clickRemove() { driver.findElement(removeButton).click(); }
}
