package api;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Ynet extends BaseTest {


	@Test(description = "GET YNET return 200")
	public void StatusCode200Ynet() throws InterruptedException {

		{
			given().log().all().when().get("home/0,7340,L-8,00.html").then().statusCode(200);
			given().log().ifValidationFails().when().get("home/0,7340,L-8,00.html").then().statusCode(200);


		}
	}

	//integration with selenium 1
	@Test(description = "GET None Existing resource return 403", enabled = true)
	public void statusCodeIsNot403_try() {
		int statusCode = given().get("400").getStatusCode();
		if (statusCode == 400) {
			driver = new ChromeDriver();
			driver.navigate().to("https://www.walla.co.il");
		} else {
			driver = new FirefoxDriver();
			driver.navigate().to("https://www.ynet.co.il");
		}
		assertEquals(statusCode, 404, "Test Failed Status Code is: " + statusCode);
	}

	//integration with selenium 2
	@Test(description = "GET None Existing resource return 403", enabled = true)
	public void statusCodeIs200() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("home/0,7340,L-8,00.html1");
		if (response.getStatusCode() == 200) {
			driver = new ChromeDriver();
			driver.navigate().to("https://www.walla.co.il");
		} else {
			driver = new FirefoxDriver();
			driver.navigate().to("https://www.ynet.co.il");
		}

		assertEquals(response.getStatusCode(), 200, "Test Failed Status Code is: " + response.getStatusCode());


	}


	@Test(description = "GET does not return Forbiden")
	public void StatusCodeIsNot403() throws InterruptedException {

		{
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("home/0,7340,L-8,00.html1");
			if (response.getStatusCode() == 400) {

			}
			Assert.assertNotEquals(403, response.getStatusCode(), "Test Failed Response is" + response.getStatusCode());

		}

	}
}
