package com.web.steps;

import com.web.pages.AccountPage;
import com.web.pages.AutomationPracticeHomePage;
import com.web.pages.CartPage;
import com.web.utilities.TestHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

public class OrderTshirtStepDefs {

    private static final Logger logger = LoggerFactory.getLogger(OrderTshirtStepDefs.class);

    @Managed
    WebDriver driver;
    AutomationPracticeHomePage automationPracticeHomePage;
    CartPage cartPage;
    AccountPage accountPage;
    private String emailAddress = null;
    private String orderNumber = null;

    @Given("I am on home page {string}")
    public void iAmOnHomePage(String automationHomePage) {
        driver.get(automationHomePage);
        driver.manage().window().maximize();
    }

    @And("I Click on T-shirt Category")
    public void iClickOnTShirtCategory() {
        automationPracticeHomePage.clickOnTshirts();
    }

    @And("I mouse over to first product")
    public void iMouseOverToFirstProduct() {
        automationPracticeHomePage.moveToProductImage(driver);
    }

    @When("I Click on add to cart button")
    public void iClickOnAddToCartButton() {
        automationPracticeHomePage.clickOnAddToCart();
    }

    @And("I click on proceed to checkout button")
    public void iClickOnProceedToCheckoutButton() {
        automationPracticeHomePage.proceedToCheckOutButton();
    }

    @And("I click on proceed to checkout in cart page")
    public void iClickOnProceedToCheckoutInCartPage() {
        cartPage.proceedToCheckOutButton();
    }

    @And("I enter email address to create an account")
    public void iEnterEmailAddressToCreateAnAccount() {
        emailAddress = "automation"+ TestHelper.randomAlphaNumeric(6)+"@gmail.com";
        cartPage.enterEmail(emailAddress);
        cartPage.clickCreateAccount();
    }

    @And("I enter personal Information, address Information")
    public void iEnterPersonalInformationAddressInformation() {
        cartPage.enterPersonalInformation();
        cartPage.enterAddressInformation();
    }

    @And("click on Register")
    public void clickOnRegister() {
        cartPage.register();
    }

    @And("click on proceed checkout after entering address information")
    public void clickOnProceedCheckoutAfterEnteringAddressInformation() {
        cartPage.proceedAddressCheckOutButton();
    }

    @And("I click on agree terms")
    public void iClickOnAgreeTerms() {
        cartPage.clickOnAgree();
    }

    @And("I click on proceed checkout after agreeing terms")
    public void clickOnProceedCheckoutAfterAgreeingTerms() {
        cartPage.proceedCarrierButton();
    }

    @And("I click on pay by bankwire")
    public void iClickOnPayByBankwire() {
        cartPage.clickOnPayByBankWire();
    }

    @And("I click on confirm order")
    public void iClickOnConfirmOrder() {
        cartPage.clickOnConfirmOrder();
    }

    @And("get the OrderNumber from confirmation page")
    public void getTheOrderNumberFromConfirmationPage() {
        orderNumber = TestHelper.getOrderNumberFromConfirmation(cartPage.getConfirmationText());
        assertNotNull("Order Number should not be null",orderNumber);
    }

    @And("verify the orderNumber in the order history")
    public void verifyTheOrderNumberInTheOrderHistory() {
        cartPage.clickOnBackToOrders();
        String actualOrderNumber = cartPage.getOrderNumber();
        assertThat("OrderNUmber should be equal",orderNumber,equalTo(actualOrderNumber));
    }

    @And("I Click on SignIn")
    public void iClickOnSignIn() {
        automationPracticeHomePage.clickOnSignIn();
    }

    @And("click on Account")
    public void clickOnAccount() {
        automationPracticeHomePage.clickOnAccount();
    }

    @And("update firstName")
    public void updateFirstName() {
        cartPage.enterFirstName("automationFnUpdate");
        accountPage.enterOldPassword("987654321");
    }

    @When("I click on Save")
    public void iClickOnSave() {
        accountPage.clickOnSave();
    }

    @And("click on personal Information")
    public void clickOnPersonalInformation() {
        accountPage.clickOnPersonalInformation();
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        assertThat(accountPage.getSuccessMessageText(),containsString("Your personal information has been successfully updated"));
    }
}
