package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class CartPage extends Utility {


    By welcomeText=By.xpath("//h1[contains(text(),'Shopping cart')]");
    By quantityLink=By.xpath("//input[contains(@id,'itemquantity')]");
    By updateShoppingCartLink=By.xpath("//button[contains(text(),'Update shopping cart')]");
    By totalPriceLink=By.xpath("//td[@class='subtotal']/child::span");
    By termsOfServiceCheckBox=By.id("termsofservice");
    By checkOutButton=By.id("checkout");

    public String getWelcomeText(){
        Reporter.log("Getting welcome text from "+welcomeText.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(welcomeText,20));
    }

    public void changeQuantityOfSelectedProduct(String quantity){
        Reporter.log("Change Quantity "+quantity+" On element "+quantityLink.toString()+"<br>");
        changeTheQuantityOnElement(quantityLink,quantity);
    }

    public void selectUpdateShoppingCart(){
        Reporter.log("Clicking on update shopping cart "+updateShoppingCartLink.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(updateShoppingCartLink,20));
    }

    public String getTextFromTotalPrice(){
        Reporter.log("Getting total price text from "+totalPriceLink.toString()+"<br>");
      return   getTextFromElement(waitUntilVisibilityOfElementLocated(totalPriceLink,20));
    }

    public void selectTermsOfService(){
        Reporter.log("Clicking on terms of service "+termsOfServiceCheckBox.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(termsOfServiceCheckBox,20));
    }

    public void selectCheckOutButton(){
        Reporter.log("Clicking on check out button "+checkOutButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(checkOutButton,20));
    }

}
