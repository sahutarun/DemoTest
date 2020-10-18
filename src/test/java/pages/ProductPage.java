package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Add to cart')]")
	public WebElementFacade button_add_to_Cart;

	public void clickOnAddToCart() throws Exception{
		try{	
			if(!button_add_to_Cart.isPresent()){
				button_add_to_Cart.waitUntilPresent();
				button_add_to_Cart.click();
			}else{
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
		        js.executeScript("arguments[0].click();", button_add_to_Cart);
			}
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on add to Cart button " + e.getMessage());
		}
	}
	
	public void acceptTheConfirmation() throws Exception{
		try{
	    Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		}catch(Exception e){
			throw new IllegalStateException("Unable to accept the alert " + e.getMessage());
		}
	}
	
	

}
