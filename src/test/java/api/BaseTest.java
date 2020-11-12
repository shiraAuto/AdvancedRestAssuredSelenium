package api;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	public Faker faker;
	WebDriver driver;
	
	@BeforeClass
	protected void setup() {
		RestAssured.baseURI = "https://www.ynet.co.il/";
		faker = new Faker();
///		RestAssured.proxy("localhost", 8888);
		RestAssured.useRelaxedHTTPSValidation();
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json").build();
		RestAssured.requestSpecification = requestSpecification;
		WebDriverManager.chromedriver().setup(); //I added this row
		WebDriverManager.firefoxdriver().setup(); //I added this row

	}

	@AfterClass
	protected void tearDown() {
		if(driver != null)
		   driver.quit();
	}  //I added this row
}
