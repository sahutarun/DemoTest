package pages;



import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automatiom.Context;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {

	@FindBy(how=How.XPATH, using="//button[contains(text(),'Place Order')]")
	public WebElementFacade button_placeOrder;

	@FindBy(how=How.ID, using="name")
	public WebElementFacade name;

	@FindBy(how=How.ID, using="country")
	public WebElementFacade country;

	@FindBy(how=How.ID, using="city")
	public WebElementFacade city;

	@FindBy(how=How.ID, using="card")
	public WebElementFacade card;

	@FindBy(how=How.ID, using="month")
	public WebElementFacade month;

	@FindBy(how=How.ID, using="year")
	public WebElementFacade year;

	@FindBy(how=How.XPATH, using="//button[contains(text(),'Purchase')]")
	public WebElementFacade button_purchase;

	@FindBy(how=How.XPATH, using="//p[@class='lead text-muted ']")
	public WebElementFacade purchase_text;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'OK')]")
	public WebElementFacade button_OK;
	
	
	
	Context context = new Context();


	public void deleteItem(String item) throws Exception{
		try{
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("//td[contains(text(),'"+item+"')]/following::a[contains(text(),'Delete')]")).click();
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on add to Cart button " + e.getMessage());
		}
	}

	public void clickOnPlaceOrder() throws StaleElementReferenceException, InterruptedException{
		try{
			Thread.sleep(3000);
			if(button_placeOrder.isPresent()){
				button_placeOrder.click();		
			}else{
				Thread.sleep(3000);
				button_placeOrder.click();		
				throw new IllegalStateException("Unable to click on place order button");
			}
		}catch(StaleElementReferenceException e){
			getDriver().navigate().refresh();
			Thread.sleep(3000);
			button_placeOrder.click();	
		}
	}


	public void fillForm() throws Exception{
		try{
			name.type("Tarun");
			country.type("India");
			city.type("Gurgaon");
			card.type("41111111111111111");
			month.type("11");
			year.type("2020");
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on place order button " + e.getMessage());
		}
	}

	public void clickOnPurchase() throws Exception{
		try{
			button_purchase.click();		
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on place order button " + e.getMessage());
		}
	}

	public void getPurchaseDetails() throws Exception{
		String purchaseDetails = null;
		try{
			purchaseDetails = purchase_text.getText();
			String id = StringUtils.substringBetween(purchaseDetails, "Id: ", "Amount").trim();
			context.setPurchaseID(id);
			System.out.println("Purchase id of product is: "+id);
			String purchaseAmount = StringUtils.substringBetween(purchaseDetails, "Amount: ", "Card").replaceAll("USD", "").trim();
			context.setPurchasedProductAmount(purchaseAmount);
			System.out.println("Purchase amount of product is: "+purchaseAmount);

		}catch(Exception e){
			throw new IllegalStateException("Unable to get product details " + e.getMessage());
		}
		 
	}
	
	public void clickOnOK() throws Exception{
		try{
			button_OK.click();		
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on OK button " + e.getMessage());
		}
	}

}
