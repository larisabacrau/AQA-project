package org.automation.pages;

import org.automation.testdata.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");
    private final By onesieTitle = By.xpath("//div[@class=\"inventory_item_name\"][contains(text(), \"Onesie\")]");
    private final By onesieDescription = By.xpath("//div[@class=\"inventory_item_desc\"][contains(text(), \"onesie\")]");
    private final By onesiePrice = By.xpath("//div[@class=\"cart_item\"]/div[contains(string(), \"Onesie\")]/descendant::div[@class=\"inventory_item_price\"]");
    private final By onesieQuantity = By.xpath("//div[@class=\"cart_quantity\"]");
    private final By paymentInformation = By.xpath("//div[@class=\"summary_info_label\"][contains(text(), \"Payment\")]/following::div[@class=\"summary_value_label\"][1]");
    private final By shippingInformation = By.xpath("//div[@class=\"summary_info_label\"][contains(text(), \"Payment\")]/following::div[@class=\"summary_value_label\"][2]");
    private final By itemSubtotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
    private final By itemTax = By.xpath("//div[@class=\"summary_tax_label\"]");
    private final By itemTotal = By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");

    public WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public void clickCancel() {
        driver.findElement(cancelButton).click();
    }

    public String getOnesieQuantity() {
        return driver.findElement(onesieQuantity).getText();
    }

    public String getPaymentInformation() {
        return driver.findElement(paymentInformation).getText();
    }

    public String getShippingInformation() {
        return driver.findElement(shippingInformation).getText();
    }

    public Product getProductDetails() {
        String title = driver.findElement(onesieTitle).getText();
        String desc = driver.findElement(onesieDescription).getText();
        String price = driver.findElement(onesiePrice).getText();
        return new Product(title, desc, price);
    }

    public float getItemSubtotal() {
        String subTotalString = driver.findElement(itemSubtotal).getText();
        return Float.parseFloat(subTotalString.substring(subTotalString.indexOf('$') + 1));
    }

    public float getItemTax() {
        String taxString = driver.findElement(itemTax).getText();
        return Float.parseFloat(taxString.substring(taxString.indexOf('$') + 1));
    }

    public float getItemTotal() {
        String totalString = driver.findElement(itemTotal).getText();
        return Float.parseFloat(totalString.substring(totalString.indexOf('$') + 1));
    }
}
