package com.web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AutomationPracticeHomePage extends PageObject {

    @FindBy(css="ul.sf-menu > li")
    List<WebElementFacade> menuItems;

    @FindBy(xpath="//a[@title='T-shirts']")
    List<WebElementFacade> tShirtsLink;

    @FindBy(xpath="//span[(text()='Add to cart')]")
    WebElementFacade addToCartButton;

    @FindBy(css="a.product_img_link img")
    WebElementFacade productImage;

    @FindBy(xpath="//a[@title='Proceed to checkout']")
    WebElementFacade proceedToCheckOutButton;

    @FindBy(css="a.login")
    WebElementFacade signIn;

    @FindBy(css="a.account")
    WebElementFacade account;

    public void clickOnTshirts(){
        menuItems.get(2).click();
    }

    public void clickOnAccount(){
        account.waitUntilVisible().click();
    }

    public void clickOnSignIn(){
        signIn.waitUntilVisible().click();
    }

    public void clickOnAddToCart(){
        addToCartButton.waitUntilVisible().click();
    }

    public void moveToProductImage(WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(productImage).perform();
    }

    public void proceedToCheckOutButton(){
        proceedToCheckOutButton.waitUntilVisible().click();
    }

}
