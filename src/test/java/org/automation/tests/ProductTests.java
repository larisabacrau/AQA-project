package org.automation.tests;

import org.automation.testdata.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProductTests extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login(standardUser);
    }

    @Test
    public void addAndRemoveProductFromProductPage() {
        productsPage.clickOnesieProductTitle();
        productPage.clickAddToCart();
        assertEquals("1", headerPage.getShoppingCartItems());

        productsPage.openCart();
        assertTrue(cartPage.checkOnesieInCart());

        cartPage.clickProductTitle();
        productPage.clickRemove();
        assertEquals("", headerPage.getShoppingCartItems());

        productsPage.openCart();
        assertFalse(cartPage.checkOnesieInCart());
    }

    @Test
    public void checkProductDetails() {
        Product productDetails = productsPage.getProductDetails();
        productsPage.clickOnesieProductTitle();
        assertEquals(productDetails, productPage.getProductDetails());
    }
}
