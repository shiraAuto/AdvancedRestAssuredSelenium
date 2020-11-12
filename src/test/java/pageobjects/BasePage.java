package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	protected void click(WebElement el) {
		// highlight
		el.click();
	}

	/**
	 * This method fills text in a given webelement
	 * @param el the element we want to fill
	 * @param text the text needed to fill 
	 */
	protected void fillText(WebElement el, String text) {
		// hightlight
		el.clear();
		el.sendKeys(text);
	}

	protected String getText(WebElement el) {
		// highlight
		return el.getText();
	}

	protected void sleep(int mil) {
		try {
			Thread.sleep(mil);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
