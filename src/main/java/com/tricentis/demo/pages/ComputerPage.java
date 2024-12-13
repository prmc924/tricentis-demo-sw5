package com.tricentis.demo.pages;

import com.aventstack.extentreports.Status;
import com.tricentis.demo.customlisteners.CustomListeners;
import com.tricentis.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class ComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='sublist']/li/a")
    List<WebElement> subMenuLinks;


    public String getPageTitleText() {
        String message = getTextFromElement(pageTitle);
        CustomListeners.node.log(Status.PASS, "Get pageTitle text : " + pageTitle.getText());
        Reporter.log("Get pageTitle text : " + pageTitle.getText() + "<br>");
        log.info("Get pageTitle text : " + pageTitle.getText());
        return message;
    }

    public void clickOnSubMenu(String subTab) {
        for (WebElement menu : subMenuLinks) {
            System.out.println(menu.getText());
            if (menu.getText().trim().contains(subTab)) {
                CustomListeners.node.log(Status.PASS, "Click on '" + subTab + "' link");
                Reporter.log("Click on '" + subTab + "' link <br>");
                log.info("Click on '" + subTab + "' link");
                clickOnElement(menu);
                break;
            }
        }
    }

}
