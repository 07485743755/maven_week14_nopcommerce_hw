package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class CompletedPage extends Utility {

    By thankYouText=By.xpath("//h1[text()='Thank you']");
    By orderConfirmationText=By.xpath("//strong[text()='Your order has been successfully processed!']");
    By continueButton=By.xpath("//button[contains(text(),'Continue')]");

    public String getTextFromThankYou(){
        Reporter.log("Getting thank you text from "+thankYouText.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(thankYouText,20));
    }

    public String getTextOfOrderConfirmation(){
        Reporter.log("Getting order confirmation text from "+orderConfirmationText.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(orderConfirmationText,20));
    }

    public void selectContinueButton(){
        Reporter.log("Clicking on continue button"+continueButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(continueButton,20));
    }
}
