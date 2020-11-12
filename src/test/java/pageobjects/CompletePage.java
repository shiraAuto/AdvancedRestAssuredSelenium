package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CompletePage extends BasePage{
	@FindBy(css=".complete-header")
	@CacheLookup
	private WebElement msg;
	
	public CompletePage(WebDriver driver) {
		super(driver);
	}
	
	public String getMessage() {
		return getText(msg);
	}

}
