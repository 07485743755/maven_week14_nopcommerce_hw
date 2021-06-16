package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class ComputersPage extends Utility {

    By desktopLink=By.xpath("//h2[@class='title']/a[@href='/desktops']");

    public void clickOnDesktop(){

        Reporter.log("Clicking on desktopLink"+desktopLink.toString()+"<br>");
        clickOnElement(waitUntilVisibilityOfElementLocated(desktopLink,60));
    }
}
