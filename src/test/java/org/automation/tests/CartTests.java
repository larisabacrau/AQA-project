package org.automation.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class CartTests extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login(standardUser);
    }

    @Test
    public void addProductToCart() {
        productsPage.addOnesieToCart();
        assertEquals("1", headerPage.getShoppingCartItems());
        assertTrue(productsPage.isOnesieRemoveButtonDisplayed());
        productsPage.openCart();
        assertTrue(cartPage.checkOnesieInCart());
        assertEquals("1", cartPage.getQuantity());
    }

    @Test
    public void addTwoProductsToCart() {
        productsPage.addOnesieToCart();
        productsPage.addBikeLightToCart();
        assertEquals("2", headerPage.getShoppingCartItems());
        productsPage.openCart();
        assertTrue(cartPage.checkOnesieInCart());
        assertTrue(cartPage.checkBikeLightInCart());
    }

    @Test
    public void removeProductFromProductsPage() {
        productsPage.addOnesieToCart();
        assertEquals("1", headerPage.getShoppingCartItems());
        assertTrue(productsPage.isOnesieRemoveButtonDisplayed());
        productsPage.removeOnesieFromCart();
        assertEquals("", headerPage.getShoppingCartItems());
        assertTrue(productsPage.isOnesieAddButtonDisplayed());
        productsPage.openCart();
        assertFalse(cartPage.checkOnesieInCart());
    }

    @Test
    public void removeProductFromShoppingCart() {
        productsPage.addOnesieToCart();
        productsPage.openCart();
        assertTrue(cartPage.checkOnesieInCart());
        cartPage.clickRemove();
        assertFalse(cartPage.checkOnesieInCart());
        cartPage.clickContinueShopping();
        assertTrue(productsPage.isOnesieAddButtonDisplayed());
    }
}
