package testing;
import org.openqa.selenium.WebDriver;


public class OverviewPage {
	protected WebDriver driver;
	
	public OverviewPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getOverviewPageTitle(){
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	public boolean verifyOverviewPageTitle(){
		String expectedTitle = "Voyanta - Overview";
		return getOverviewPageTitle().contains(expectedTitle);
	}
	
}