package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoading extends Driver {

	public DynamicLoading(WebDriver driver) {
		super(driver);
	}
	
    @FindBy(xpath="//*[@id=\"start\"]/button")
    private WebElement button;
	
    @FindBy(id="finish")
    private WebElement loadedDiv;
	
	public void visible(){
		 driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		 this.button.click();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Content loaded"+"\n");
		 }

	 public WebElement getButton() {
	    	return button;
	    }
	
	 public WebElement getLoadedDiv() {
	    	return loadedDiv;
	    }
}
