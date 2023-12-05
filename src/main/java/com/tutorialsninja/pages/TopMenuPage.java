package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
    1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    1.2 This method should click on the menu whatever name is passed as parameter. Write the following Test:
     */
public class TopMenuPage extends Utility {
    public void selectMenu(String menu){
        List<WebElement> topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = driver.findElements(By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*"));
        }
    }

        By desktopLink = By.linkText("Desktops");
        By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");
        By laptopNotebooks = By.linkText("Laptops & Notebooks");
        By laptopNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
        By components = By.linkText("Components");
        By componentsText = By.xpath("//h2[contains(text(),'Components']");

    //1.3 Verify the text ‘Desktops’
    public String verifyDesktopsText(){
        return getTextFromElement(desktopsText);
    }
    //1.1 Mouse hover on “Desktops” Tab and click
    public void mouseHoverOnDesktops(){
        mouseHoverToElementAndClick(desktopLink);
    }
    // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
    public void mouseHoverOnLaptopNotebooks(){
        mouseHoverToElementAndClick(laptopNotebooks);
    }
    //3.1 Mouse hover on “Components” Tab and click
    public void mouseHoverOnComponents(){
        mouseHoverToElementAndClick(components);
    }
    // 2.3 Verify the text ‘Laptops & Notebooks’
    public String verifyLaptopNotebooksText(){
        return getTextFromElement(laptopNotebooksText);
    }
    // 3.3 Verify the text ‘Components
    public String verifyComponentsText(){
        return getTextFromElement(componentsText);
    }
}
