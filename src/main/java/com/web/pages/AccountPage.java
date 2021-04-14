package com.web.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class AccountPage extends PageObject {

    @FindBy(xpath="//a[@title='Information']")
    WebElementFacade personalInformation;

    @FindBy(xpath = "//button[@name='submitIdentity']")
    WebElementFacade saveButton;

    @FindBy(css="p.alert-success")
    WebElementFacade successMessage;

    @FindBy(id="old_passwd")
    WebElementFacade oldPassword;

    public void clickOnPersonalInformation(){
        personalInformation.waitUntilVisible().click();
    }

    public void clickOnSave(){
        saveButton.waitUntilVisible().click();
    }

    public void enterOldPassword(String password){
        oldPassword.waitUntilVisible().sendKeys(password);
    }

    public String getSuccessMessageText(){
        return successMessage.waitUntilVisible().getText();
    }
}
