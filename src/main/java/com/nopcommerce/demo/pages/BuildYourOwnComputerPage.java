package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class BuildYourOwnComputerPage extends Utility {

    By welcomeText=By.xpath("//h1[contains(text(),'Build your own computer')]");
    By processorAttribute=By.xpath("(//select[contains(@id,'product_attribute')])[1]");
    By ramAttribute=By.xpath("(//select[contains(@id,'product_attribute')])[2]");
    By hDDRadioButton =By.xpath("(//ul[@class='option-list'])[1]//label");
    By oSRadioButton=By.xpath("(//ul[@class='option-list'])[2]//label");
    By softwareCheckBox =By.xpath("(//ul[@class='option-list'])[3]//label");
    By checkBoxTotalCommander=By.xpath("(//input[contains(@id,'product_attribute')])[7]");
    By priceLink=By.xpath("//span[contains(@id,'price-value')]");
    By addToCartButton=By.xpath("//button[contains(@id,'add-to-cart-button')]");
    By popUpTextFromAddToCart=By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    By popUpCloseButton=By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]");
    By shoppingCartLink=By.xpath("//span[contains(text(),'Shopping cart')]");
    By goToCartButton=By.xpath("//button[contains(text(),'Go to cart')]");



    public String getWelcomeText(){

        Reporter.log("Getting welcome text "+welcomeText.toString()+"<br>");
        return getTextFromElement(welcomeText);
    }

    public void selectProcessor(String value){
        Reporter.log("Select processor from drop down "+processorAttribute.toString()+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElementLocated(processorAttribute,30),value);
    }

    public void selectRamFromDropDown(String value){
        Reporter.log("Select ram from drop down "+ramAttribute.toString()+"<br>");
        selectByValueDropDown(waitUntilVisibilityOfElementLocated(ramAttribute,30),value);
    }

    public void selectHddRadioButton(String hdd) {

            Reporter.log("Getting list of hdd radio buttons "+hDDRadioButton.toString()+"<br>");
            List<WebElement> menuList = driver.findElements(hDDRadioButton);
            for (WebElement element : menuList) {
                Reporter.log("Getting text"+element.getText()+"From element "+element.getText()+" and compare with hdd"+hdd+"<br>");
                if (element.getText().equalsIgnoreCase(hdd)) {
                    Reporter.log("Clicking on element "+element.toString()+"<br>");
                    element.click();
                    break;
                }
            }
    }

    public void selectOsRadioButton(String os) {

        Reporter.log("Getting list of os radio buttons "+oSRadioButton.toString()+"<br>");
        List<WebElement> menuList = driver.findElements(oSRadioButton);
        for (WebElement element : menuList) {
            Reporter.log("Getting text"+element.getText()+"From element "+element.getText()+" and compare with os"+os+"<br>");
            if (element.getText().equalsIgnoreCase(os)) {
                Reporter.log("Clicking on element "+element.toString()+"<br>");
                element.click();
                break;
            }
        }
    }

    public void selectSoftwareCheckBox(String software) {

        Reporter.log("Getting list of software check box "+softwareCheckBox.toString()+"<br>");
        List<WebElement> menuList = driver.findElements(softwareCheckBox);
        for (WebElement element : menuList) {
            Reporter.log("Getting text"+element.getText()+"From element "+element.getText()+" and compare with software"+software+"<br>");
            if (element.getText().equalsIgnoreCase(software)) {

                if(!element.isSelected()){
                    Reporter.log("Clicking on element "+element.toString()+"<br>");
                    element.click();
                }
                break;
            }
        }
    }


    /*public void checkOnCheckBoxMicroSoftOffice(){

        WebElement microSoftOfficeCheckBox=driver.findElement(checkBoxMicroSoftOffice);
        if(!microSoftOfficeCheckBox.isSelected()){
            microSoftOfficeCheckBox.click();
        }
    }

    public void checkOnCheckBoxTotalCommander(){

        Reporter.log();
        clickOnElement(waitUntilVisibilityOfElementLocated(checkBoxTotalCommander,30));
    }*/

    public String getTextFromPrice(){
        Reporter.log("Getting price text from "+priceLink.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(priceLink,30));
    }

    public void selectAddToCart(){

        Reporter.log("Clicking on add to cart button "+addToCartButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(addToCartButton,30));
    }

    public String getTextFromAddToCartPopup(){
        Reporter.log("Getting popup text from "+popUpTextFromAddToCart.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(popUpTextFromAddToCart,30));
    }

    public void setPopUpCloseButton(){

        Reporter.log(("Accept pop up close button "+popUpCloseButton.toString()+"<br>"));
        clickOnElement(waitUntilVisibilityOfElementLocated(popUpCloseButton,20));
    }

    public void mouseHoverOnShoppingCart(){
        Reporter.log("Mouse hover to shopping cart link "+shoppingCartLink.toString()+"<br>");
        mouseHoverToElement(waitUntilVisibilityOfElementLocated(shoppingCartLink,30));
    }

    public void selectGoToCartButton(){
        Reporter.log("Clicking on go to cart button "+goToCartButton.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(goToCartButton,30));
    }
}
