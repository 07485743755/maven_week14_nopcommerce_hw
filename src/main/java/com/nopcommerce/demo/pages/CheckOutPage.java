package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.Random;

public class CheckOutPage extends Utility {


    By firstNameField = By.id("BillingNewAddress_FirstName");
    By lastNameField = By.id("BillingNewAddress_LastName");
    By emailIdField = By.id("BillingNewAddress_Email");
    By country = By.id("BillingNewAddress_CountryId");
    By cityField = By.id("BillingNewAddress_City");
    By addressField = By.id("BillingNewAddress_Address1");
    By postalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    By continueButton = By.xpath("//button[@onclick='Billing.save()']");
    By nextDayAirRadioButton=By.xpath("(//input[contains(@id,'shippingoption')])[2]");
    By shippingContinueButton=By.xpath("//button[@onclick='ShippingMethod.save()']");
    By creditCardRadioButton=By.xpath("(//input[contains(@id,'paymentmethod')])[2]");
    By paymentMethodContinueButton=By.xpath("//button[@onclick='PaymentMethod.save()']");
    By selectCreditCard=By.id("CreditCardType");
    By cardHolderNameField =By.id("CardholderName");
    By cardNumberField=By.id("CardNumber");
    By expireMonthField=By.id("ExpireMonth");
    By expireYearField=By.id("ExpireYear");
    By cardCodeField=By.id("CardCode");
    By paymentConfirmationButton=By.xpath("//button[@onclick='PaymentInfo.save()']");
    By paymentMethodConformationText=By.xpath("//li[@class='payment-method']");
    By shippingMethodConformationText=By.xpath("//li[@class='shipping-method']");
    By totalPriceText=By.xpath("//span[@class='value-summary']/child::strong");
    By confirmOrderButton=By.xpath("//button[@onclick='ConfirmOrder.save()']");




    public void enterFirstName(String firstname){

        Reporter.log("Enter firstname "+firstname+" in first field"+firstNameField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(firstNameField,20),firstname);
    }
    public void enterLastName(String lastName){
        Reporter.log("Enter last name "+lastName+" in last name field"+lastNameField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(lastNameField,20),lastName);
    }
    public void enterEmailID(String username,String domain){

        WebElement emailText=driver.findElement(emailIdField);
        Reporter.log("Clicking on email field "+emailIdField.toString()+"<br>");
        emailText.click();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        Reporter.log("Send email id "+username+"random number"+randomInt+"Domain"+domain+"In emailid field "+emailIdField.toString()+"<br>");
        emailText.sendKeys(username+ randomInt +domain);
    }

    public void selectCountryFromDropDown(String visibleText ){
        Reporter.log("Select visible text "+visibleText+" In country field "+country.toString()+"<br>");
        selectByVisibleText(waitUntilVisibilityOfElementLocated(country,20),visibleText);
    }
    public void enterCityName(String cityName){
        Reporter.log("Enter city name "+cityName+" in city field"+cityField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(cityField,20),cityName);
    }
    public void enterAddress(String address){
        Reporter.log("Enter address"+address+" in address field"+addressField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(addressField,20),address);
    }
    public void enterPostCode(String postalCode){
        Reporter.log("Enter post code"+postalCode+" in postal code field"+postalCodeField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(postalCodeField,20), postalCode);
    }
    public void enterPhoneNumber(String phoneNumber){
        Reporter.log("Enter phone number"+phoneNumber+" in phone number field"+phoneNumberField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(phoneNumberField,20),phoneNumber);
    }

    public void selectContinueButton(){

        Reporter.log("Clicking on continue button "+continueButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(continueButton,20));
    }

    public void selectNextDayAirRadioButton(){

        Reporter.log("Clicking on next day air delivery radio button "+nextDayAirRadioButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(nextDayAirRadioButton,20));
    }

    public void selectShippingContinueButton(){

        Reporter.log("Clicking on shipping continue button "+shippingContinueButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(shippingContinueButton,20));
    }

    public void selectCreditCardRadioButton(){

        Reporter.log("Clicking on credit card radio button "+creditCardRadioButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(creditCardRadioButton,20));
    }

    public void selectPaymentContinueButton(){

        Reporter.log("Clicking on payment continue button "+paymentMethodContinueButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(paymentMethodContinueButton,20));
    }

    public void selectCardFromDropDown(String value){

        Reporter.log("Select card "+value+" from drop down "+selectCreditCard.toString()+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElementLocated(selectCreditCard,20),value);
    }

    public void enterCardHolderName(String cardHolderName){
        Reporter.log("Send text "+cardHolderName+" In card holder field "+cardHolderNameField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(cardHolderNameField,20),cardHolderName);
    }

    public void enterCardNumber(String cardNumber){
        Reporter.log("Send text "+cardNumber+" In card number field "+cardNumberField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(cardNumberField,20),cardNumber);
    }

    public void enterExpireMonth(String expireMonth){
        Reporter.log("Send text "+expireMonth+" In expire month field "+expireMonthField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(expireMonthField,20),expireMonth);
    }

    public void enterExpireYear(String expireYear){
        Reporter.log("Send text "+expireYear+" In expire year field "+expireYear.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(expireYearField,20),expireYear);
    }

    public void enterCardCode(String cardCode){
        Reporter.log("Send text "+cardCode+" In card code field "+cardCodeField.toString()+"<br>");
        sendTextToElement(waitUntilVisibilityOfElementLocated(cardCodeField,20),cardCode);
    }

    public void clickOnPaymentConfirmationButton(){

        Reporter.log("Clicking on payment confirmation button "+paymentConfirmationButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(paymentConfirmationButton,20));
    }

    public String getTextFromPaymentMethod(){
        Reporter.log("Getting payment method confirmation text from "+paymentMethodContinueButton.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(paymentMethodConformationText,20));
    }

    public String getTextFromShippingMethod(){
        Reporter.log("Getting shipping method confirmation text from "+shippingMethodConformationText.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(shippingMethodConformationText,20));
    }

    public String getTextFromTotalPrice(){
        Reporter.log("Getting total price text from "+totalPriceText.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(totalPriceText,20));
    }

    public void selectConfirmOrderButton(){

        Reporter.log("Clicking on confirm order button "+confirmOrderButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(confirmOrderButton,20));
    }
}
