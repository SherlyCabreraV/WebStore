import com.webstaurantstore.CartPage;
import com.webstaurantstore.LandingPage;
import com.webstaurantstore.SearchPage;
import com.webstaurantstore.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends base {
   LandingPage Landingpage;
   SearchPage SearchPage;
   CartPage CartPage;


    @BeforeMethod
    public void setup(){
        initialization();
        Landingpage = new LandingPage();
        SearchPage =new SearchPage();
        CartPage = new CartPage();
    }

    @Test(description = "Search for item,add to cart, empty cart")
    public void addToCartE2E(){

        Landingpage.searchAction("stainless work table");
        SearchPage.checkAllResultsForText("Table");
        SearchPage.clickAddToCartBTn();
        SearchPage.goToCart();
        CartPage.clickOnEmptyCartBtn();
        CartPage.confirmEmptyCartPopUp("Your cart is empty.");

    }

    @AfterMethod
    public void close(){
        tearDown();

    }

}
