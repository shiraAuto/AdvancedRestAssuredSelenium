package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	WebDriver driver;
	
	@BeforeClass
	protected void setup(ITestContext testContext) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Drivers\\chromedriver.exe"); 
		WebDriverManager.chromedriver().setup();
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("disable-infobars");
		driver = new ChromeDriver(cOptions);
        testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		System.out.println("1");
	}
	
	@AfterClass
	protected void tearDown() {
		driver.quit();
	}
}

