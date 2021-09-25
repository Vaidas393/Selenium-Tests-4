package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.ThreadLocalRandom;


public class Inputs extends Driver {

	public Inputs(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/input")
    private WebElement input;
	
	public void numberEntering(){
		 driver.get("https://the-internet.herokuapp.com/inputs");
	  	 for (int i = 0; i < 20; i++) {	 
		 this.input.click();
		 int numbers = ThreadLocalRandom.current().nextInt(-1000, 1000 + 1);
		 this.input.sendKeys(String.valueOf(numbers));
		 String value = this.input.getAttribute("value");
		 this.input.clear();
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Entered number:"+value+"\n");
	  	 }
		 }

	public WebElement getInputField() {
    	return input;
    }
}
