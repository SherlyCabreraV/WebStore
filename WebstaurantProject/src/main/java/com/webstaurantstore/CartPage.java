package com.webstaurantstore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends base{

    @FindBy(xpath="//button[contains(text(),'Empty Cart')]")
    WebElement emptyCartBtn;

    @FindBy(xpath="//button[contains(text(),'Cancel')]/preceding-sibling::button")
    WebElement emptyCartConfirmationBtn;

    @FindBy(xpath="//p[contains(text(),'Your cart is empty.')]")
    WebElement emptyCartHeader;


    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnEmptyCartBtn() {
        emptyCartBtn.click();
    }

    public void confirmEmptyCartPopUp(String hd){
        waitForElement(emptyCartConfirmationBtn);
        emptyCartConfirmationBtn.click();
        waitForElement(emptyCartHeader);
        Assert.assertEquals(emptyCartHeader.getText(), hd);

    }


}
