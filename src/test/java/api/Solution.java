package api;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Solution extends BaseTest {

	@Test(description = "Body Assertion")
	public void responseTimeAssertion() throws InterruptedException {
		{
			ArrayList<String> bodyType = new ArrayList<String>();
			bodyType.add("html");
			bodyType.add("json");
			bodyType.add("text");
			//java 8 foreach loop
			bodyType.forEach(type -> {
				String Body = getBody(type);
				System.out.println(Body);
		        Assert.assertNotNull(Body);

			});
			
			//java 7 foreach loop
//			for (String type : bodyType) {
//				String Body = getBody(type);
//				System.out.println(Body);
//			}

		}
	}

	private String getBody(String Type) {
		String Body = given().queryParam("format", Type).when().get("https://baconipsum.com/api/?type=meat-and-filler")
				.asString();
		return Body;
	}

}
