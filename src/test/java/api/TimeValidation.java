package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class TimeValidation extends BaseTest {
	
	@Test(description = "Body Assertion")
	public void responseTimeAssertion() throws InterruptedException {
		{
			when().get("https://yesno.wtf/api").then().time(lessThan(2L), TimeUnit.MICROSECONDS);

		}
	}


}
