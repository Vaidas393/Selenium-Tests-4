package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Hower extends Driver {

	public Hower(WebDriver driver) {
		super(driver);
	}
	
	 Actions actions = new Actions(driver);
	
	public void howerCheck(int number){
		 driver.get("https://the-internet.herokuapp.com/hovers");
		 WebElement Image = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div["+number+"]/img"));
		 actions.moveToElement(Image);
		 WebElement howeredImage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div["+number+"]/div/h5"));
		 actions.perform();
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Chosen user is:"+howeredImage.getText().toString()+"\n");
		 }
}
