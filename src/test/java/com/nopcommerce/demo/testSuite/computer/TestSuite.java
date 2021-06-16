package com.nopcommerce.demo.testSuite.computer;

import com.nopcommerce.demo.customListener.CustomListener;
import com.nopcommerce.demo.pages.*;
import com.nopcommerce.demo.retryAnalyzer.RetryAnalyzer;
import com.nopcommerce.demo.testBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListener.class)
public class TestSuite extends TestBase {


    HomePage homePage=new HomePage();
    ComputersPage computersPage = new ComputersPage();
    DesktopPage desktopPage = new DesktopPage();
    BuildYourOwnComputerPage buildYourOwnComputerPage=new BuildYourOwnComputerPage();
    CartPage cartPage=new CartPage();
    LoginPage loginPage=new LoginPage();
    CheckOutPage checkOutPage=new CheckOutPage();
    CompletedPage completedPage=new CompletedPage();

    SoftAssert softAssert=new SoftAssert();

    @Test(groups = {"smoke","sanity","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {


        homePage.selectMenu("computers");
        Thread.sleep(2000);
        computersPage.clickOnDesktop();
        Thread.sleep(2000);
        desktopPage.selectSortByFilterZToA("6");
        Thread.sleep(3000);

        List<String>  productNameList=desktopPage.getProductNameList();
        List<String> sortedProductNameList = new ArrayList<>(productNameList);
        Collections.sort(sortedProductNameList, Collections.reverseOrder());
        softAssert.assertEquals(sortedProductNameList,productNameList);

    }

    @Test(groups = {"sanity","regression"},retryAnalyzer = RetryAnalyzer.class)
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        homePage.selectMenu("computers");
        Thread.sleep(2000);
        computersPage.clickOnDesktop();
        Thread.sleep(2000);

        desktopPage.selectSortByFilterAToZ("5");
        Thread.sleep(1000);
        desktopPage.selectAddToCartButtonForBuildYourOwnComputer();

        String expectedTextMessage="Build your own computer";
        String actualTextMessage=buildYourOwnComputerPage.getWelcomeText();
        Assert.assertEquals(expectedTextMessage,actualTextMessage);
        buildYourOwnComputerPage.selectProcessor("1");
        buildYourOwnComputerPage.selectRamFromDropDown("5");
        Thread.sleep(4000);
        buildYourOwnComputerPage.selectHddRadioButton("400 GB [+$100.00]");
        Thread.sleep(2000);
        buildYourOwnComputerPage.selectOsRadioButton("Vista Premium [+$60.00]");
        Thread.sleep(1000);
       // buildYourOwnComputerPage.selectSoftwareCheckBox("Microsoft Office [+$50.00]");
        Thread.sleep(1000);
        buildYourOwnComputerPage.selectSoftwareCheckBox("Total Commander [+$5.00]");
        Thread.sleep(3000);
        String expectedPrice="$1,475.00";
        String actualPrice=buildYourOwnComputerPage.getTextFromPrice();
        softAssert.assertEquals(expectedPrice,actualPrice);
        buildYourOwnComputerPage.selectAddToCart();
        Thread.sleep(2000);
        String expectedAddToCartPopUpText ="The product has been added to your shopping cart";
        String actualAddToCartPopUpText =buildYourOwnComputerPage.getTextFromAddToCartPopup();
        Assert.assertEquals(expectedAddToCartPopUpText, actualAddToCartPopUpText);
        buildYourOwnComputerPage.setPopUpCloseButton();
        buildYourOwnComputerPage.mouseHoverOnShoppingCart();
        buildYourOwnComputerPage.selectGoToCartButton();

        String expectedWelcomeShoppingPageText="Shopping cart";
        String actualWelcomeShoppingPageText=cartPage.getWelcomeText();
        Assert.assertEquals(expectedWelcomeShoppingPageText,actualWelcomeShoppingPageText);
        Thread.sleep(2000);

        cartPage.changeQuantityOfSelectedProduct("2");
        cartPage.selectUpdateShoppingCart();
        Thread.sleep(2000);
        String expectedTotalPrice="$2,950.00";
        String actualTotalPrice=cartPage.getTextFromTotalPrice();
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
        cartPage.selectTermsOfService();
        cartPage.selectCheckOutButton();
        Thread.sleep(3000);

        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage, actualMessage);
        loginPage.clickOnCheckOutAsGuestButton();

        Thread.sleep(5000);
        checkOutPage.enterFirstName("Harry");
        checkOutPage.enterLastName("Potter");
        checkOutPage.enterEmailID("harryPotter","@gmail.com");
        checkOutPage.selectCountryFromDropDown("United Kingdom");
        Thread.sleep(3000);
        checkOutPage.enterCityName("Leicester");
        checkOutPage.enterAddress("75,Corporation road");
        checkOutPage.enterPostCode("LE45NJ");
        checkOutPage.enterPhoneNumber("07896543215");
        checkOutPage.selectContinueButton();
        Thread.sleep(3000);
        checkOutPage.selectNextDayAirRadioButton();
        checkOutPage.selectShippingContinueButton();
        Thread.sleep(2000);
        checkOutPage.selectCreditCardRadioButton();
        checkOutPage.selectPaymentContinueButton();
        Thread.sleep(3000);
        checkOutPage.selectCardFromDropDown("MasterCard");
        Thread.sleep(2000);
        checkOutPage.enterCardHolderName("Harry Potter");
        checkOutPage.enterCardNumber("5465222828379708");
        checkOutPage.enterExpireMonth("01");
        Thread.sleep(2000);
        checkOutPage.enterExpireYear("2022");
        checkOutPage.enterCardCode("283");
        Thread.sleep(2000 );
        checkOutPage.clickOnPaymentConfirmationButton();
        Thread.sleep(3000);
        String expectedPaymentMethodText="Payment Method: Credit Card";
        String actualPaymentMethodText=checkOutPage.getTextFromPaymentMethod();
        Assert.assertEquals(expectedPaymentMethodText,actualPaymentMethodText);
        String expectedShippingMethodText="Shipping Method: Next Day Air";
        String actualShippingMethodText=checkOutPage.getTextFromShippingMethod();
        Assert.assertEquals(expectedShippingMethodText,actualShippingMethodText);
        String expectedTotalPriceText="$2,950.00";
        String actualTotalPriceText=checkOutPage.getTextFromTotalPrice();
        Assert.assertEquals(expectedTotalPriceText,actualTotalPriceText);
        checkOutPage.selectConfirmOrderButton();

        Thread.sleep(5000);
        String expectedTextFromThankYou="Thank you";
        String actualTextFromThankYou=completedPage.getTextFromThankYou();
        Assert.assertEquals(expectedTextFromThankYou,actualTextFromThankYou);
        String expectedTextOfOrderConformation="Your order has been successfully processed!";
        String actualTextOfOrderConfirmation=completedPage.getTextOfOrderConfirmation();
        Assert.assertEquals(expectedTextOfOrderConformation,actualTextOfOrderConfirmation);
        completedPage.selectContinueButton();

        Thread.sleep(4000);
        String expectedWelcomeText="Welcome to our store";
        String actualWelcomeText=homePage.getWelcomeText();
        Assert.assertEquals(expectedWelcomeText,actualWelcomeText);

    }

}
