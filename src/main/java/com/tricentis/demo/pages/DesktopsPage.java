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
public class DesktopsPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(css = "div[class='page-title'] h1")
    WebElement pageTitle;

    @CacheLookup
    @FindBy(id = "products-orderby")
    WebElement sortBy;

    @CacheLookup
    @FindBy(id = "products-pagesize")
    WebElement display;

    @CacheLookup
    @FindBy(xpath = "//h2[@class='product-title']/a")
    List<WebElement> productTitleList;


    public String getPageTitleText() {
        String message = getTextFromElement(pageTitle);
        CustomListeners.node.log(Status.PASS, "Get pageTitle text : " + pageTitle.getText());
        Reporter.log("Get pageTitle text " + pageTitle.getText() + "<br>");
        log.info("Get pageTitle text " + pageTitle.getText());
        return message;
    }

    public void selectSortBy(String position) {
        selectByVisibleTextFromDropDown(sortBy, position);
        CustomListeners.node.log(Status.PASS, "Sort by '" + position + "' position");
        Reporter.log("Sort by '" + position + "' position <br>");
        log.info("Sort by '" + position + "' position");
    }

    public void selectDisplayPerPage(String number) {
        selectByVisibleTextFromDropDown(display, number);
        CustomListeners.node.log(Status.PASS, "Display product '" + number + "' per page");
        Reporter.log("Display product '" + number + "' per page <br>");
        log.info("Display product '" + number + "' per page");
    }

    public void selectProduct(String productName) {
        for (WebElement product : productTitleList) {
            if (product.getText().equals(productName)) {
                CustomListeners.node.log(Status.PASS, "Click on product '" + productName + "' : " + product.getText());
                Reporter.log("Click on product '" + productName + "' : " + product.getText() + "<br>");
                log.info("Click on product '" + productName + "' : " + product.getText());
                clickOnElement(product);
                break;
            }
        }
    }

}
