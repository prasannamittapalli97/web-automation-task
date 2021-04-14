package com.web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends PageObject {

    @FindBy(xpath="//a[@title='Continue shopping']//preceding-sibling::a")
    WebElementFacade proceedToCheckOutButton;

    @FindBy(id="email_create")
    WebElementFacade email;

    @FindBy(id="SubmitCreate")
    WebElementFacade createAccountButton;

    @FindBy(id="customer_firstname")
    WebElementFacade customerFirstName;

    @FindBy(id="customer_lastname")
    WebElementFacade customerLastName;

    @FindBy(id="passwd")
    WebElementFacade password;

    @FindBy(id="firstname")
    WebElementFacade firstName;

    @FindBy(id="lastname")
    WebElementFacade lastName;

    @FindBy(id="address1")
    WebElementFacade address;

    @FindBy(id="city")
    WebElementFacade city;

    @FindBy(id="id_state")
    WebElementFacade state;

    @FindBy(id="postcode")
    WebElementFacade postcode;

    @FindBy(id="phone_mobile")
    WebElementFacade mobilePhone;

    @FindBy(id="submitAccount")
    WebElementFacade register;

    @FindBy(xpath="//button[@name='processAddress']")
    WebElementFacade processAddress;

    @FindBy(xpath="//button[@name='processCarrier']")
    WebElementFacade processCarrier;

    @FindBy(id="uniform-cgv")
    WebElementFacade agreeTerms;

    @FindBy(xpath="//a[@title='Pay by bank wire']")
    WebElementFacade payByBankWire;

    @FindBy(xpath = "//span[contains(text(),'confirm')]")
    WebElementFacade confirmOrder;

    @FindBy(css= "div.box")
    WebElementFacade confirmationContent;

    @FindBy(xpath="//a[@title='Back to orders']")
    WebElementFacade backToOrders;

    @FindBy(css="a.color-myaccount")
    WebElementFacade orderNumber;


    public void proceedToCheckOutButton(){
        proceedToCheckOutButton.waitUntilVisible().click();
    }

    public void proceedAddressCheckOutButton(){
        processAddress.waitUntilClickable().click();
    }

    public void proceedCarrierButton(){
        processCarrier.waitUntilClickable().click();
    }

    public void clickOnAgree(){
        agreeTerms.waitUntilVisible().click();
    }

    public void clickOnBackToOrders(){
        backToOrders.waitUntilVisible().click();
    }

    public void enterFirstName(String firstNameValue){
        firstName.clear();
        enterFieldValue(firstName,firstNameValue);
    }

    public void enterPassword(String passwordValue){
        enterFieldValue(password,passwordValue);
    }

    public String getOrderNumber(){
        return orderNumber.waitUntilVisible().getText();
    }

    public void clickOnPayByBankWire(){
        payByBankWire.waitUntilClickable().click();
    }

    public void clickOnConfirmOrder(){
        confirmOrder.waitUntilVisible().click();
    }

    public String getConfirmationText(){
       return confirmationContent.waitUntilVisible().getText();
    }

    public void enterEmail(String emailValue){
        enterFieldValue(email,emailValue);
    }

    public void enterPersonalInformation(){
        enterFieldValue(customerFirstName,"Automationfn");
        enterFieldValue(customerLastName,"Automationln");
        enterFieldValue(password,"987654321");
    }

    public void enterAddressInformation(){
        enterFieldValue(address,"automation address1");
        enterFieldValue(city,"AutomationCity");
        Select stateField = new Select(state);
        stateField.selectByIndex(2);
        enterFieldValue(postcode,"00000");
        enterFieldValue(mobilePhone,"08654321976");
    }

    public void register(){
        register.waitUntilVisible().click();
    }

    public void clickCreateAccount(){
        createAccountButton.waitUntilVisible().click();
    }

    public void enterFieldValue(WebElementFacade element,String value){
        element.waitUntilClickable().sendKeys(value);
    }



}
