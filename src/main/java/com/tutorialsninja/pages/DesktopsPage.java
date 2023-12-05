package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DesktopsPage extends Utility {

    By sortBy = By.id("input-sort");
    By product = By.xpath("//a[contains(text(),'HP LP3065')]");
    By productText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By shoppingCart = By.xpath("//a[contains(text(),'shopping cart')]");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By productNameText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDateText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By modelNameText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By selectCurrency = By.xpath("//span[contains(text(),'Currency')]");
    By poundSterling = By.xpath("//button[normalize-space()='£Pound Sterling']");
    By totalAmountText = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    public void clickOnSortBy(String sort) {
        selectByVisibleTextFromDropDown(sortBy, sort);
    }

    public void clickOnProduct() {
        clickOnElement(product);
    }

    public String verifyProductText() {
        return getTextFromElement(productText);
    }

    public void datePicker() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }
    public String verifyTheSuccessMessage(){
        return getTextFromElement(successMessage);
    }
    public void clickOnShoppingCart(){
        clickOnElement(shoppingCart);
    }
    public String verifyShoppingCartText(){
        return getTextFromElement(shoppingCartText);
    }
    public String verifyProductName(){
        return getTextFromElement(productNameText);
    }
    public String verifyTheDeliveryDate(){
        return getTextFromElement(deliveryDateText);
    }
    public String verifyTheModelName(){
        return getTextFromElement(modelNameText);
    }
    public void clickOnCurrency(){
        clickOnElement(selectCurrency);
    }
    public void selectPoundsSterling(){
        mouseHoverToElementAndClick(poundSterling);
    }
    public String verifyTheTotalAmount(){
        return getTextFromElement(totalAmountText);
    }
}

