package steps;

import net.thucydides.core.annotations.Step;
import pages.HomePage;
import pages.ProductPage;

public class User {
	
	HomePage homepage;
	
	ProductPage productpage;
	
	@Step
	public void userClickOnAddToCart() throws Exception{
			productpage.clickOnAddToCart();
		}
	
	@Step
	public void userClickOnLaptop() throws Exception{
		homepage.clickOnLaptop();
		}
	
	@Step
	public void userclickOnSonyAioi5() throws Exception{
		homepage.clickOnSonyaioi5();
		}
	
	
	
	}



