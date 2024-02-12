package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    public WebDriver driver;
    private final By overviewHeader = By.xpath("//div[@class='header_secondary_container']/descendant::span[@class='title']");
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
    private By itemTotal = By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getOnesieDescription() {
        return driver.findElement(onesieDescription).getText();
    }

    public String getOnesiePrice() {
        return driver.findElement(onesiePrice).getText();
    }

    public String getOnesieTitle() {
        return driver.findElement(onesieTitle).getText();
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

    public double getItemSubtotal() {
        String subTotalString = driver.findElement(itemSubtotal).getText();
        return Double.valueOf(subTotalString.substring(subTotalString.indexOf('$') + 1));
    }

    public double getItemTax() {
        String taxString = driver.findElement(itemTax).getText();
        return Double.valueOf(taxString.substring(taxString.indexOf('$') + 1));
    }

    public double getItemTotal() {
        String totalString = driver.findElement(itemTotal).getText();
        return Double.valueOf(totalString.substring(totalString.indexOf('$')+1));
    }
}
