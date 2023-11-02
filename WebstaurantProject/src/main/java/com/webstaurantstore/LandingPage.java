package com.webstaurantstore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends base {

    //Page objects
    @FindBy(xpath="//input[@id='searchval'][@aria-owns='awesomplete_list_1']")
    WebElement searchBar;

    @FindBy(xpath="//span[@class='sr-only']/parent::button")
    WebElement searchButton;

    //Initializing my page objects
    public LandingPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public SearchPage searchAction(String item){
        waitForElement(searchBar);
        searchBar.sendKeys(item);
        searchButton.click();
        return new SearchPage();
    }



}
