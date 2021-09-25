package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.ThreadLocalRandom;


public class ContextMenu extends Driver {

	public ContextMenu(WebDriver driver) {
		super(driver);
	}
	
	 Actions actions = new Actions(driver);

	@FindBy(id="hot-spot")
    private WebElement contextArea;
	
	public void checkingAlert(){
		 driver.get("https://the-internet.herokuapp.com/context_menu");
		 actions.contextClick(this.contextArea).perform();
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 if(wait.until(ExpectedConditions.alertIsPresent())==null)
		     System.out.println("\n"+"alert was not present"+"\n");
		 else
		     System.out.println("\n"+"alert was present"+"\n");
		 driver.switchTo().alert().accept();
		 }
	
	public WebElement getContextArea() {
    	return contextArea;
    }
}
