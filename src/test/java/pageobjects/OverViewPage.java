package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OverViewPage extends BasePage{
	@FindBy(css=".cart_checkout_link")
	@CacheLookup
	private WebElement btnFinish;
	@FindBy(css=".cart_cancel_link")
	@CacheLookup
	private WebElement btnCancel;

	public OverViewPage(WebDriver driver) {
		super(driver);
	}

	public void finish() {
		click(btnFinish);
	}

	public void cancel() {
		click(btnCancel);
	}

}
