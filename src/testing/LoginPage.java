package testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	protected WebDriver driver;
	private By emailAddressBox = By.id("email");
	private By passwordBox = By.id("password");
	private By loginButton = By.name("save");
	private By failureMessage = By.id("form-messenger");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}

	public String getLoginPageTitle(){
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	public void displayLoginPageTitle(){
		System.out.println(getLoginPageTitle());
	}
	
	public void enterEmail(String myEmail){
		try {
			WebElement emailElement = driver.findElement(emailAddressBox);
		    System.out.println("Element Found");
		    emailElement.sendKeys(myEmail);
		} catch (Exception e) {
			e.printStackTrace();
		    System.out.println("Element Not Found");
		}
		
	}
	public void enterPassword(String myPassword){
		try {
			WebElement passwordElement = driver.findElement(passwordBox);
			passwordElement.sendKeys(myPassword);
		} catch (Exception e) {
			e.printStackTrace();
		    System.out.println("Element Not Found");
		}
	}
	public OverviewPage clickOnLoginButton(){
		WebElement loginButtonElement = driver.findElement(loginButton);
		if(loginButtonElement.isDisplayed()){
				loginButtonElement.click();
		}
		
			return new OverviewPage(driver);
	}
	public void clickOnLoginButtonIncorrectDetails(){
		System.out.println("click on button return text");
		WebElement loginButtonElement = driver.findElement(loginButton);
		if(loginButtonElement.isDisplayed()){
				loginButtonElement.click();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean verifyLoginPageTitle(){
		String expectedTitle = "Voyanta - Login";
		return getLoginPageTitle().contains(expectedTitle);
	}
	
	public boolean verifyLoginFailMessage(){
		String expectedFailureMessage = "Thes Email or Password you entered is incorrect. Please try again.";
		return getFailureLoginMessage().contains(expectedFailureMessage);
	}

	private String getFailureLoginMessage() {
		String failureLoginMessage = driver.findElement(failureMessage).getAttribute("outerHTML");
		return failureLoginMessage;
	}

}