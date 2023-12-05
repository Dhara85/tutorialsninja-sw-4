package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopsPage;
import com.tutorialsninja.pages.TopMenuPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. Create class “DesktopsTest”
 * Write the following Test:
 * 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Mouse hover on Desktops Tab.and click
 * 1.2 Click on “Show All Desktops”
 * 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully()
 * 2.1 Mouse hover on Currency Dropdown and click
 * 2.2 Mouse hover on £Pound Sterling and click
 * 2.3 Mouse hover on Desktops Tab.
 * 2.4 Click on “Show All Desktops”
 * 2.5 Select Sort By position "Name: A to Z"
 * 2.6 Select product “HP LP3065”
 * 2.7 Verify the Text "HP LP3065"
 * 2.8 Select Delivery Date "2023-11-27"
 * 2.9.Enter Qty "1” using Select class.
 * 2.10 Click on “Add to Cart” button
 * 2.11 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
 * 2.12 Click on link “shopping cart” display into success message
 * 2.13 Verify the text "Shopping Cart"
 * 2.14 Verify the Product name "HP LP3065"
 * 2.15 Verify the Delivery Date "2023-11-27"
 * 2.16 Verify the Model "Product21"
 * 2.17 Verify the Todat "£74.73"
 */
public class DesktopsTest extends BaseTest {

    TopMenuPage topMenuPage = new TopMenuPage();
    DesktopsPage desktopsPage = new DesktopsPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        topMenuPage.mouseHoverOnComponents();
        //1.2 Click on “Show All Desktops”
        topMenuPage.selectMenu("Show AllDesktops");
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);

        // 1.3 Select Sort By position "Name: Z to A"
        desktopsPage.clickOnSortBy("Name (Z - A)");

        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);

        // 1.4 Verify the Product will arrange in Descending order.
        Assert.assertEquals(originalProductsName,afterSortByZToAProductsName);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        //Select currency as £ Pound Sterling
        desktopsPage.clickOnCurrency();
        desktopsPage.selectPoundsSterling();

        //2.3 Mouse hover on Desktops Tab.
        topMenuPage.mouseHoverOnDesktops();
        // 2.4 Click on “Show All Desktops”
        topMenuPage.selectMenu("Show AllDesktops");
        // 2.5 Select Sort By position "Name: A to Z"
        desktopsPage.clickOnSortBy("Name (A - Z)");
        // 2.6 Select product “HP LP3065”
        desktopsPage.clickOnProduct();
        // 2.7 Verify the Text "HP LP3065"
        String actualText = desktopsPage.verifyProductText();
        Assert.assertEquals(actualText,"HP LP3065","text not match");
        // 2.8 Select Delivery Date "2023-11-27"
        desktopsPage.datePicker();

        // 2.9 Click on “Add to Cart” button
        desktopsPage.clickOnAddToCart();
        //2.10 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String actualMessage = desktopsPage.verifyTheSuccessMessage();
        Assert.assertEquals(actualMessage,"Success: You have added HP LP3065 to your shopping cart!\n" +
                "×","message not match");
        //2.11 Click on link “shopping cart” display into success message
        desktopsPage.clickOnShoppingCart();
        //2.12 Verify the text "Shopping Cart"
        String actualShoppingCartText = desktopsPage.verifyShoppingCartText();
        Assert.assertEquals(actualShoppingCartText,"Shopping Cart  (1.00kg)","Text is not match");
        //2.13 Verify the Product name "HP LP3065"
        String actualProductName = desktopsPage.verifyProductName();
        Assert.assertEquals(actualProductName,"HP LP3065","Product name is not match");
        //2.14 Verify the Delivery Date "2022-11-30"
        String actualDeliveryDate = desktopsPage.verifyTheDeliveryDate();
        Assert.assertEquals(actualDeliveryDate,"Delivery Date:2023-11-30","Delivery date is not match");
        //2.15 Verify the Model "Product21"
        String actualModelName = desktopsPage.verifyTheModelName();
        Assert.assertEquals(actualModelName,"Product 21","Model name is not match");
        //2.16 Verify the Total "£74.73"
        String actualTotalAmount = desktopsPage.verifyTheTotalAmount();
        Assert.assertEquals(actualTotalAmount,"£74.73","Total amount is not match");

    }
}
