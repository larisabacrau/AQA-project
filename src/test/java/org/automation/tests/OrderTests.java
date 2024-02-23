package org.automation.tests;

import org.automation.testdata.Product;
import org.automation.testdata.pages.CheckoutCompleteTD;
import org.automation.testdata.pages.CheckoutOverviewTD;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderTests extends BaseTest {
    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login(standardUser);
    }

    @Test
    public void productOrderCompleteFlow() {
        Product productDetails = productsPage.getProductDetails();

        productsPage.clickOnesieProductTitle();
        productPage.clickAddToCart();
        headerPage.openCart();
        cartPage.checkOnesieInCart();

        assertEquals(productDetails, cartPage.getProductDetails());

        cartPage.clickCheckout();
        checkoutYourInformationPage.fillInCheckoutInfo();
        assertEquals(productDetails, checkoutOverviewPage.getProductDetails());
        assertEquals("1", checkoutOverviewPage.getOnesieQuantity());

        assertEquals(CheckoutOverviewTD.PAYMENT_INFORMATION, checkoutOverviewPage.getPaymentInformation());
        assertEquals(CheckoutOverviewTD.SHIPPING_INFORMATION, checkoutOverviewPage.getShippingInformation());
        assertEquals(CheckoutOverviewTD.ITEM_TOTAL, checkoutOverviewPage.getItemSubtotal(), 0);
        assertEquals(CheckoutOverviewTD.ITEM_TAX, checkoutOverviewPage.getItemTax(), 0);
        assertEquals(CheckoutOverviewTD.GRAND_TOTAL, checkoutOverviewPage.getItemTotal(), 0);

        checkoutOverviewPage.clickFinish();
        assertEquals(CheckoutCompleteTD.PAGE_TITLE, headerPage.getTitle());
        assertEquals(CheckoutCompleteTD.THANK_YOU_MESSAGE, checkoutCompletePage.getThankYouMessage());
        assertEquals(CheckoutCompleteTD.ORDER_DISPATCH_MESSAGE, checkoutCompletePage.getOrderDispatchMessage());
        assertTrue(checkoutCompletePage.backHomeButtonIsPresent());
    }

    @Test
    public void productOrderCheckoutCancel() {
        productsPage.clickOnesieProductTitle();
        productPage.clickAddToCart();
        headerPage.openCart();
        cartPage.clickCheckout();
        assertEquals("Checkout: Your Information", headerPage.getTitle());
        checkoutYourInformationPage.clickCancel();

        assertEquals("Your Cart", headerPage.getTitle());
        cartPage.checkOnesieInCart();
    }

    @Test
    public void productOrderCheckoutOverviewCancel() {
        productsPage.clickOnesieProductTitle();
        productPage.clickAddToCart();
        headerPage.openCart();
        cartPage.clickCheckout();
        cartPage.checkOnesieInCart();
        assertEquals("Checkout: Your Information", headerPage.getTitle());

        checkoutYourInformationPage.fillInCheckoutInfo();
        assertEquals("Checkout: Overview", headerPage.getTitle());

        checkoutOverviewPage.clickCancel();
        assertEquals("Products", headerPage.getTitle());
        assertEquals("1", headerPage.getShoppingCartItems());
        assertTrue(productsPage.isOnesieRemoveButtonDisplayed());
    }

}
