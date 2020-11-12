package tests;

import org.testng.annotations.Test;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageobjects.LoginPage;

public class LoginTest extends BaseTest {

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lg1_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "111");
	}

	@Link("http://automation.co.il/")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lg11_loginFailed() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "333");
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void lg2_loginSucced() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("standard_user", "secret_sauce");
	}

}
