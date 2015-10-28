package testing;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class LoginPageTest{

	private static WebDriver driver;

	@Before
	public void setUp(){
		String applicationURL = "https://live.system.com/account/login";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(applicationURL);
	}
	
	@Test
	public void LoginSuccess(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("test@email.address.com");
		loginPage.enterPassword("mypassword");
		OverviewPage overviewPage = loginPage.clickOnLoginButton();
		assertTrue(overviewPage.verifyOverviewPageTitle());				
	}
	@Test
	public void LoginFailMessage(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail("test@email.address.com");
		loginPage.enterPassword("mypassword");
		loginPage.clickOnLoginButtonIncorrectDetails();
		assertTrue(loginPage.verifyLoginFailMessage());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}