package org.automation.tests;

import org.junit.Before;
import org.junit.Test;

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
    public void checkAToZfilter() {
        headerPage.openFilterMenu();
        headerPage.clickAToZ();
        List<String> actualNamesList = productsPage.getInventoryNamesList();
        List<String> orderedList = actualNamesList
                .stream()
                .sorted()
                .toList();
        assertEquals(orderedList, actualNamesList);
    }

    @Test
    public void checkZtoAfilter() {
        headerPage.openFilterMenu();
        headerPage.clickZToA();
        List<String> actualNamesList = productsPage.getInventoryNamesList();
        List<String> reverseOrderedList = actualNamesList
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        assertEquals(reverseOrderedList, actualNamesList);
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
        assertEquals(orderedList, actualPriceList);
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
        assertEquals(reverseOrderedList, actualPriceList);
    }
}
