package com.nopcommerce.demo.basePage;

import com.nopcommerce.demo.propertyReader.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    String projectPath = System.getProperty("user.dir");
    int implicitlyWait=Integer.parseInt(PropertyReader.getInstance().getProperty("implicitlyWait"));

    public void selectBrowser(String browser) {

        try {


            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",projectPath +"/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", projectPath + "/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            } else {
                System.out.println("Wrong browser name");
            }

        }catch(Exception exception){

            System.out.println(exception.getMessage());
        }
            driver.manage().window().maximize();
            //   driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

            driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }



    public void closeBrowser(){

        if(driver !=null){

            driver.quit();
        }
    }

}
