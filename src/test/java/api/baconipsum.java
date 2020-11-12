package api;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class baconipsum extends BaseTest {

	@Test(description = "Body Assertion")
	public void responseTimeAssertion() throws InterruptedException {
		{
			String Body = given().queryParam("format", "json").when()
					.get("https://baconipsum.com/api/?type=meat-and-filler").asString();
			System.out.println(Body);
	        Assert.assertNotNull(Body);
		}
	}

}
