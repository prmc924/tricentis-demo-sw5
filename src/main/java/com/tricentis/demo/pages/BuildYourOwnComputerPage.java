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
public class BuildYourOwnComputerPage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-name']//h1")
    WebElement productNameText;

    @CacheLookup
    @FindBy(id = "product_attribute_16_5_4")
    WebElement processor;

    @CacheLookup
    @FindBy(id = "product_attribute_16_6_5")
    WebElement ram;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li/input[@type='radio']/parent::li/label")
    List<WebElement> hDDRadios;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li/input[@type='radio']/parent::li/label")
    List<WebElement> oSRadios;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='option-list']//li/input[@type='checkbox']/parent::li/label")
    List<WebElement> softwareCheckBoxes;

    @CacheLookup
    @FindBy(xpath = "(//input[@id='add-to-cart-button-16'])[1]")
    WebElement addToCartBtn;

    @CacheLookup
    @FindBy(xpath = "//p[@class='content']")
    WebElement productAddeMessage;


    public String getProductNameText() {
        String message = getTextFromElement(productNameText);
        CustomListeners.node.log(Status.PASS, "Get productName text : " + productNameText.getText());
        Reporter.log("Get productName text : " + productNameText.getText() + "<br>");
        log.info("Get productName text : " + productNameText.getText());
        return message;
    }

    public void selectProcessor(String processorName) {
        selectByVisibleTextFromDropDown(processor, processorName);
        CustomListeners.node.log(Status.PASS, "Select processor '" + processorName + "'");
        Reporter.log("Select processor '" + processorName + "'" + "<br>");
        log.info("Select processor '" + processorName + "'");
    }

    public void selectRam(String ramGB) {
        selectByVisibleTextFromDropDown(ram, ramGB);
        selectByVisibleTextFromDropDown(ram, ramGB);
        CustomListeners.node.log(Status.PASS, "Select RAM '" + ramGB + "'");
        Reporter.log("Select RAM '" + ramGB + "'" + "<br>");
        log.info("Select RAM '" + ramGB + "'");
    }

    public void selectHDD(String hDdGB) {
        for (WebElement hdd : hDDRadios) {
            if (hdd.getText().equals(hDdGB)) {
                clickOnElement(hdd);
                CustomListeners.node.log(Status.PASS, "Select HDD '" + hDdGB + "'");
                Reporter.log("Select HDD '" + hDdGB + "'" + "<br>");
                log.info("Select HDD '" + hDdGB + "'");
                break;
            }
        }
    }

    public void selectOS(String oSName) {
        for (WebElement os : oSRadios) {
            if (os.getText().equals(oSName)) {
                clickOnElement(os);
                CustomListeners.node.log(Status.PASS, "Select HDD '" + oSName + "'");
                Reporter.log("Select HDD '" + oSName + "'" + "<br>");
                log.info("Select HDD '" + oSName + "'");
                break;
            }
        }
    }

    public void selectSoftware(String softwareName) {
        for (WebElement software : softwareCheckBoxes) {
            if (software.getText().equals(softwareName)) {
                clickOnElement(software);
                CustomListeners.node.log(Status.PASS, "Select Software '" + softwareName + "'");
                Reporter.log("Select Software '" + software + "'" + "<br>");
                log.info("Select Software '" + softwareName + "'");
                break;
            }
        }
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartBtn);
        CustomListeners.node.log(Status.PASS, "Click on 'ADD TO CART' Button");
        Reporter.log("Click on 'ADD TO CART' Button" + "<br>");
        log.info("Click on 'ADD TO CART' Button");
    }

    public String getProductAddedMessage() {
        String message = getTextFromElement(productAddeMessage);
        CustomListeners.node.log(Status.PASS, "Get productAdded Message : " + productAddeMessage.getText());
        Reporter.log("Get productAdded Message : " + productAddeMessage.getText() + "<br>");
        log.info("Get productAdded Message : " + productAddeMessage.getText());
        return message;
    }
}