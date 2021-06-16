package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    By homePageMenuTabs=By.xpath("//div[@class='header-menu']/ul[1]/li/a");
    By computersLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']");
    By electronicsLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']");
    By apparelLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']");
    By digitalDownloadLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']");
    By booksLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']");
    By jewelryLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']");
    By giftCardsLink = By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']");
    By pageTitleText = By.xpath("//div[@class='page-title']");
    By welcomeText=By.xpath("//h2[text()='Welcome to our store']");


    public String selectMenu(String menu) {

        Reporter.log("Getting list of top menu tabs "+homePageMenuTabs.toString()+"<br>");
        List<WebElement> menuList = driver.findElements(homePageMenuTabs);
        String expectedText = null;
        for (WebElement element : menuList) {
            if (element.getText().equalsIgnoreCase(menu)) {
                expectedText = element.getText();
                element.click();
                break;
            }
        }
        return expectedText;
    }

    public String getActualText() {
        Reporter.log("getting title text "+pageTitleText.toString()+"<br>");
        return waitUntilVisibilityOfElementLocated(pageTitleText, 30).getText();
    }

    public String getWelcomeText(){
        Reporter.log("Getting welcome Text"+welcomeText.toString()+"<br>");
        return getTextFromElement(waitUntilVisibilityOfElementLocated(welcomeText,20));
    }

}
