package org.automation.pages;

import org.automation.testdata.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;
    private By yourCart = By.xpath("//div[@class='header_secondary_container']/descendant::span[@class='title']");

    private By onesieTitle = By.xpath("//div[@class=\"cart_list\"]/descendant::*[contains(text(),\"Onesie\")]");
    private By onesieDescription = By.xpath("//div[@class=\"inventory_item_desc\"]");
    private By onesiePrice = By.xpath("//div[@class=\"inventory_item_price\"]");

    private By cartBikeLightTitle = By.xpath("//div[@class=\"cart_list\"]/descendant::*[contains(text(),\"Bike Light\")]");

    private By removeButton = By.id("remove-sauce-labs-onesie");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");

    private By quantity = By.xpath("//div[@class=\"cart_quantity\"] ");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRemove() {
        driver.findElement(removeButton).click();
    }

    public boolean checkOnesieInCart() {
        return checkElementInCart(onesieTitle);
    }

    public boolean checkBikeLightInCart() {
        return checkElementInCart(cartBikeLightTitle);
    }

    private boolean checkElementInCart(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
    public void clickContinueShopping() { driver.findElement(continueShoppingButton).click(); }
    public void clickProductTitle() { driver.findElement(onesieTitle).click(); }

    public String getQuantity() {
        return driver.findElement(quantity).getText();
    }

    public Product getProductDetails() {
        String title = driver.findElement(onesieTitle).getText();
        String desc = driver.findElement(onesieDescription).getText();
        String price = driver.findElement(onesiePrice).getText();
        return new Product(title, desc, price);
    }

}
