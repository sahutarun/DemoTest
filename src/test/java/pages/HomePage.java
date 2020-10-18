package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.automatiom.Context;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

public class HomePage extends PageObject {

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Laptops')]")
	public WebElementFacade link_laptops;
	
	@FindBy(how=How.XPATH, using="(//a[@href='prod.html?idp_=8'])[1]")
	public WebElementFacade link_Sony_aio_i5;
	
	@FindBy(how=How.XPATH, using="(//a[@href='prod.html?idp_=8']/following::h5)[1]")
	public WebElementFacade Sony_aio_i5_price;
	
	
	
	@FindBy(how=How.XPATH, using="(//a[@href='prod.html?idp_=12'])[1]")
	public WebElementFacade link_Delli78gb;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Home')]")
	public WebElementFacade topNav_Home;
	
	@FindBy(how=How.ID, using="cartur")
	public WebElementFacade topNav_Cart;
	
	Context context = new Context();

    /*Method to open home page*/
	public void openHomePage(){
		open();
	}

	public void clickOnLaptop() throws Exception{
		try{
			link_laptops.click();
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on laptop link" + e.getMessage());
		}
	}
	
	public void clickOnSonyaioi5() throws Exception{
		try{
			if(link_Sony_aio_i5.isPresent()){
				String prodPrice = Sony_aio_i5_price.getText().replace("$", "").trim();
				context.setProductAmount(prodPrice);
				System.out.println("Product amount is: "+prodPrice);
				link_Sony_aio_i5.click();
			}else{
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
		        js.executeScript("javascript:window.scrollBy(250,350)");
				String prodPrice = Sony_aio_i5_price.getText().replace("$", "").trim();
				context.setProductAmount(prodPrice);
				System.out.println("Product amount is: "+prodPrice);
		        js.executeScript("arguments[0].click();", link_Sony_aio_i5);
			}
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on Sonyaioi5 link " + e.getMessage());
		}
	}
	
	public void clickOnDelli78gb() throws Exception{
		try{
			if(link_Delli78gb.isPresent()){
				link_Delli78gb.click();
			}else{
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
		        js.executeScript("javascript:window.scrollBy(250,350)");
		        js.executeScript("arguments[0].click();", link_Delli78gb);
			}
		}catch(Exception e){
			throw new IllegalStateException("Unable to click on link_Delli78gb link " + e.getMessage());
		}
	}
		
		
		public void clickOnTopNavHomeLink() throws Exception{
			try{
				topNav_Home.click();
			}catch(Exception e){
				throw new IllegalStateException("Unable to click on Home link " + e.getMessage());
			}
		}
		
		public void clickOnTopNavCartLink() throws Exception{
			try{
				topNav_Cart.click();
			}catch(Exception e){
				throw new IllegalStateException("Unable to click on Cart link " + e.getMessage());
			}
		}
	
	

}
