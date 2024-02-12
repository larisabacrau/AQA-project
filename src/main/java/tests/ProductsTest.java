package tests;

import org.junit.Before;
import org.junit.Test;
import testdata.pages.CheckoutCompleteTD;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class ProductsTest extends BaseTest {
    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login(standardUser);
    }

    @Test
    public void addProductToCart() {
        productsPage.addOnesieToCart();
        productsPage.openCart();
        assertTrue(cartPage.checkOnesieInCart());
    }

    @Test
    public void removeProductFromCart() {
        productsPage.addOnesieToCart();
        productsPage.openCart();
        assertTrue(cartPage.checkOnesieInCart());
        cartPage.clickRemove();
        assertFalse(cartPage.checkOnesieInCart());
    }
    @Test
    public void checkProductDetails() throws InterruptedException {
        String onesieProductTitle = productsPage.getOnesieProductTitle();
        String onesieProductDescription = productsPage.getOnesieProductDescription();
        String onesieProductPrice = productsPage.getOnesieProductPrice();
        productsPage.clickOnesieProductTitle();
        assertEquals(onesieProductTitle, productPage.getProductTitle());
        assertEquals(onesieProductDescription, productPage.getProductDescription());
        assertEquals(onesieProductPrice, productPage.getProductPrice());
    }
    @Test
    public void productOrder() {
        String onesieProductTitle = productsPage.getOnesieProductTitle();
        String onesieProductDescription = productsPage.getOnesieProductDescription();
        String onesieProductPrice = productsPage.getOnesieProductPrice();
        productsPage.clickOnesieProductTitle();
        productPage.clickAddToCart();
        headerPage.openCart();
        cartPage.checkOnesieInCart();
        assertEquals(onesieProductTitle, cartPage.getCartOnesieTitle());
        assertEquals(onesieProductDescription, cartPage.getOnesieDescription());
        assertEquals(onesieProductPrice, cartPage.getOnesiePrice());
        cartPage.clickCheckout();
        checkoutYourInformationPage.fillInCheckoutInfo("Ana","Blandiana","445445");
        assertEquals(onesieProductTitle,checkoutOverviewPage.getOnesieTitle());
        assertEquals(onesieProductDescription,checkoutOverviewPage.getOnesieDescription());
        assertEquals(onesieProductPrice, checkoutOverviewPage.getOnesiePrice());
        assertEquals("SauceCard #31337", checkoutOverviewPage.getPaymentInformation());
        assertEquals("Free Pony Express Delivery!", checkoutOverviewPage.getShippingInformation());
        // make td page for checkout overview
        assertEquals(7.99, checkoutOverviewPage.getItemSubtotal(),0);
        assertEquals(0.64, checkoutOverviewPage.getItemTax(),0);
        assertEquals(checkoutOverviewPage.getItemSubtotal()+checkoutOverviewPage.getItemTax(),checkoutOverviewPage.getItemTotal(), 0);
        checkoutOverviewPage.clickFinish();
        assertEquals(CheckoutCompleteTD.PAGE_TITLE, headerPage.getTitle());
        assertEquals(CheckoutCompleteTD.THANK_YOU_MESSAGE,checkoutCompletePage.getThankYouMessage());
        assertEquals(CheckoutCompleteTD.ORDER_DISPATCH_MESSAGE, checkoutCompletePage.getOrderDispatchMessage());
        assertTrue(checkoutCompletePage.backHomeButtonIsPresent());
    }

    @Test
    public void checkAToZfilter() {
        headerPage.openFilterMenu();
        headerPage.clickAToZ();

        List<String> actualNamesList = productsPage.getInventoryNamesList();
        List<String> orderedList = actualNamesList.stream()
                .sorted()
                .toList();
        assertEquals(orderedList, actualNamesList);
    }
    @Test
    public void checkZtoAfilter() {
        headerPage.openFilterMenu();
        headerPage.clickZToA();
        List<String> actualNamesList = productsPage.getInventoryNamesList();
        List<String> reverseOrderedList = actualNamesList.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        assertEquals(reverseOrderedList,actualNamesList);
    }

    @Test
    public void checkLowToHighPriceFilter() {
        headerPage.openFilterMenu();
        headerPage.clickPriceLowToHigh();
        List<Float> actualPriceList = productsPage.getInventoryPricesList();
        List<Float> orderedList = actualPriceList
                .stream()
                .sorted()
                .toList();
        assertEquals(orderedList,actualPriceList);
    }
    @Test
    public void checkHighToLowPriceFilter() {
        headerPage.openFilterMenu();
        headerPage.clickPriceHighToLow();
        List<Float> actualPriceList = productsPage.getInventoryPricesList();
        List<Float> reverseOrderedList = actualPriceList
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        assertEquals(reverseOrderedList,actualPriceList);
    }
//    @Test
//    public void test() {
//        productsPage.getInventoryNamesList();
//    }

}
