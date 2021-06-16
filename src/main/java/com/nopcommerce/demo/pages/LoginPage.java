package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class LoginPage extends Utility {

    By welcomeText=By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By checkOutAsGuestButton=By.xpath("//button[@class='button-1 checkout-as-guest-button']");

    public String getWelcomeText(){
        Reporter.log("Getting welcome Text"+welcomeText.toString()+"<br>");
        return getTextFromElement(welcomeText);
    }

    public void clickOnCheckOutAsGuestButton(){
        Reporter.log("Clicking on checkOutAsGuest button"+checkOutAsGuestButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(checkOutAsGuestButton,20));
    }

}
