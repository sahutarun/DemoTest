package stepDefination;




import org.junit.Assert;

import com.automatiom.Context;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import steps.User;


public class PlaceOrder {

	@Steps
	User user;
	
	HomePage homepage;
	ProductPage productPage;
	CartPage cartPage;
	
	Context context = new Context();
	
	@Given("^user open the site DEMO ONLINE SHOP$")
	public void user_open_the_site_DEMO_ONLINE_SHOP() throws Throwable {
		homepage.openHomePage();
	}

	@Given("^user navigate to \"([^\"]*)\" and select \"([^\"]*)\" and click on \"([^\"]*)\" and accept pop up confirmation\\.$")
	public void user_navigate_to_and_select_and_click_on_and_accept_pop_up_confirmation(String arg1, String product, String arg3) throws Throwable {
		user.userClickOnLaptop();
		if(product.equalsIgnoreCase("Sony vaio i5")){
		user.userclickOnSonyAioi5();
		}if(product.equalsIgnoreCase("Dell i7 8gb")){
			homepage.clickOnDelli78gb();
		}
		user.userClickOnAddToCart();
		productPage.acceptTheConfirmation();
	}

	@Given("^user navigate to home page$")
	public void user_navigate_to_home_page() throws Throwable {
		homepage.clickOnTopNavHomeLink();
	}

	@Given("^user navigate to \"([^\"]*)\" and Delete \"([^\"]*)\" from cart\\.$")
	public void user_navigate_to_and_Delete_from_cart(String arg1, String item) throws Throwable {
		homepage.clickOnTopNavCartLink();
		cartPage.deleteItem(item);
	}

	@When("^user click on \"([^\"]*)\"\\.$")
	public void user_click_on(String arg1) throws Throwable {
		cartPage.clickOnPlaceOrder();
	}

	@When("^user Fill in all web form fields and$")
	public void user_Fill_in_all_web_form_fields_and() throws Throwable {
		cartPage.fillForm();
	}

	@When("^user click on \"([^\"]*)\" and capture and log purchase Id and Amount\\.$")
	public void user_click_on_and_capture_and_log_purchase_Id_and_Amount(String arg1) throws Throwable {
		cartPage.clickOnPurchase();
		cartPage.getPurchaseDetails();
		
	}

	@Then("^purchase amount equals expected\\.$")
	public void purchase_amount_equals_expected() throws Throwable {
	 Assert.assertEquals("Price did not match", context.getProductAmount(), context.getPurchasedProductAmount());
	}

	@Then("^Click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
	  
	}

}
