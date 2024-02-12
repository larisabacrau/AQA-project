package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {

    private By cart = By.id("shopping_cart_container");
    private By onesieProductTitle = By.xpath("//div[@class=\"inventory_list\"]/div[contains(string(), \"Onesie\")]/descendant::div[@class=\"inventory_item_label\"]/a");
    private By onesieAddButton = By.id("add-to-cart-sauce-labs-onesie");
    private By onesieProductDescription = By.xpath("//div[@class=\"inventory_list\"]/div[contains(string(), \"Onesie\")]/descendant::div[@class=\"inventory_item_desc\"]");
    private By onesieProductPrice = By.xpath("//div[@class=\"inventory_list\"]/div[contains(string(), \"Onesie\")]/descendant::div[@class=\"inventory_item_price\"]");
    private By productNames = By.xpath("//div[@class=\"inventory_item_name \"]");;
    private By productPrices = By.xpath("//div[@class=\"inventory_item_price\"]");

    public WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(cart).click();
    }

    public String getOnesieProductTitle() {
        return driver.findElement(onesieProductTitle).getText();
    }

    public String getOnesieProductDescription() {
        return driver.findElement(onesieProductDescription).getText();
    }

    public String getOnesieProductPrice() {
        return driver.findElement(onesieProductPrice).getText();
    }

    public void clickOnesieProductTitle() {
        driver.findElement(onesieProductTitle).click();
    }

    public void addOnesieToCart() {
        driver.findElement(onesieAddButton).click();
    }

    public List<String> getInventoryNamesList() {
        List<String> nameList = driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .toList();
        return nameList;
    }
    public List<Float> getInventoryPricesList() {
        List <Float> priceList = driver.findElements(productPrices)
                .stream()
                .map(element -> element.getText())
                .map(priceText -> priceText.substring(1))
                .map(price -> Float.valueOf(price))
                .toList();
        return priceList;
    }

}
