package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{
	@FindBy(css=".cart_checkout_link")
	@CacheLookup
	private WebElement btnCheckOut;
	
	
	public YourCartPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkOut() {
		click(btnCheckOut);
	}

}
