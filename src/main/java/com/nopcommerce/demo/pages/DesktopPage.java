package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

import java.util.List;

public class DesktopPage extends Utility {

    By sortFilterLink = By.id("products-orderby");
    By productNameListLink = By.xpath("//div[@class='product-grid']//h2");
    By buildYourOwnComputerLink = By.xpath("//a[contains(text(),'Build your own computer')]");
    By addToCartButtonForBuildYourOwnComputer = By.xpath("//div[@data-productid='1']//div[@class='buttons']");

    public void selectSortByFilterZToA(String value) {

        Reporter.log("Select filter Z to A from" + sortFilterLink.toString() + "<br>");
        selectByValueDropDown(waitUntilVisibilityOfElementLocated(sortFilterLink, 30), value);
    }

    public void selectSortByFilterAToZ(String value) {
        Reporter.log("Select filter A to Z from" + sortFilterLink.toString() + "<br>");
        selectByValueDropDown(waitUntilVisibilityOfElementLocated(sortFilterLink, 40), value);
    }

    public List<String> getProductNameList() throws InterruptedException {
        Reporter.log("Get product name list from " + productNameListLink.toString() + "<br>");
        return setProductNameList(productNameListLink);
    }

    public void selectAddToCartButtonForBuildYourOwnComputer() {

        Reporter.log("Clicking on Build your own computer add to cart button " + addToCartButtonForBuildYourOwnComputer.toString() + "<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(addToCartButtonForBuildYourOwnComputer, 20));
    }

}
