package driver;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Tables extends Driver {

	public Tables(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"table1\"]/thead/tr/th[1]/span")
    private WebElement lastName;
	
    @FindBy(xpath="//*[@id=\"table1\"]/tbody/tr[1]/td[1]")
    private WebElement sortedLastName;
	
	public void tableSorting(){
		 driver.get("https://the-internet.herokuapp.com/tables");
		 this.lastName.click();
		 }
	
	public WebElement getLastName() {
    	return lastName;
    }

	public WebElement getSortedLastName() {
    	return sortedLastName;
    }
}
