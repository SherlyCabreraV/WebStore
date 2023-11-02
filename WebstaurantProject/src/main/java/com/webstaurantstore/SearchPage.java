package com.webstaurantstore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;



public class SearchPage extends base{

    @FindBy(xpath="//span[@data-testid='itemDescription']")
    List<WebElement> tableTitles;

    @FindBy(css="div.add-to-cart")
   List <WebElement> AddToCardBtns;

    @FindBy(xpath="//a[contains(text(),'View Cart')]")
    WebElement popupAddToCard;

    @FindBy(xpath="//li[@class='inline-block leading-4 align-top rounded-r-md']/child::a")
    WebElement nextPageBtn;

    @FindBy(css="#paging > nav > ul > li.inline-block.leading-4.align-top.rounded-r-md > a > svg")
    WebElement nextPageBtn2;

    public SearchPage(){
        PageFactory.initElements(driver, this);
    }

    public void checkItemDescriptionText(String text) {

        for (WebElement tableTitle : tableTitles) {
            String elementText = tableTitle.getText();
            if (!elementText.contains(text)) {
                System.out.println(elementText + " : does not contain " + text);
            }
            Assert.assertTrue(elementText.contains(text));
        }
    }

    public void clickAddToCartBTn(){
        WebElement lastButton = AddToCardBtns.getLast();
        lastButton.click();
    }

        public CartPage goToCart(){
            waitForElement(popupAddToCard);
            popupAddToCard.click();
            return new CartPage();
    }
    public void goToNextPage(){
        waitForElement(nextPageBtn2);
        nextPageBtn2.click();
    }

    public void checkAllResultsForText(String text) {

        try {
            while(nextPageBtn.isDisplayed())
            {
                checkItemDescriptionText(text);
                goToNextPage();
                if (!nextPageBtn2.isDisplayed()) {
                    throw new LoopExitException("Exiting the loop gracefully.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        checkItemDescriptionText(text);
    }



}


