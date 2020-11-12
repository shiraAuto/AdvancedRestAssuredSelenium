package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class YourInfoPage extends BasePage{
	@FindBy(css="[data-test='firstName']")
	@CacheLookup
	private WebElement nameField;
	@FindBy(css="[data-test='lastName']")
	@CacheLookup
	private WebElement lastNameField;
	@FindBy(css="[data-test='postalCode']")
	@CacheLookup
	private WebElement zipField;
	@FindBy(css=".cart_checkout_link")
	@CacheLookup
	private WebElement btnContinue;
	
	public YourInfoPage(WebDriver driver) {
		super(driver);
	}
	
	public void addYourInfo(String name,String lastName,String zipCode) {
		fillText(nameField,name);
		fillText(lastNameField, lastName);
		fillText(zipField, zipCode);
		click(btnContinue);
	}

}
