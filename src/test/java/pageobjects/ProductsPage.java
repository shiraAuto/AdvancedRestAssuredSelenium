package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ProductsPage extends BasePage{
	@FindBy(css=".inventory_item")
	@CacheLookup
	private List<WebElement> list;
	@FindBy(css=".shopping_cart_link path")
	@CacheLookup
	private WebElement btnCart;
	@FindBy(css=".fa-layers-counter.shopping_cart_badge")
	@CacheLookup
	private WebElement iconCartNumberOfItems;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@Step ("Add To Cart {0}")
	public void addToCart(String name) {
		for (int i = 0; i < list.size(); i++) {
			WebElement titleEl = list.get(i).findElement(By.cssSelector(".inventory_item_name"));
			String title = getText(titleEl);
			if (name.equalsIgnoreCase(title)) {
				//click the button
				WebElement btnAdd = list.get(i).findElement(By.cssSelector(".add-to-cart-button"));
				click(btnAdd);
			}
		}
	}

	public void addToCart(int index) {
		WebElement btnAdd = list.get(index).findElement(By.cssSelector(".add-to-cart-button"));
		click(btnAdd);
	}

	public void openCart() {
		click(btnCart);
	}
	
	public int getNumberOfProductInCart() {
		int num = 0;
		String sNum = getText(iconCartNumberOfItems);
		num = Integer.parseInt(sNum);
		return num;
	}
}
