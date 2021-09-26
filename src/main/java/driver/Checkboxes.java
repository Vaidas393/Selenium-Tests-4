package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkboxes extends Driver {

	public Checkboxes(WebDriver driver) {
		super(driver);
	}

   public void select(){
	 driver.get("https://the-internet.herokuapp.com/checkboxes");
	 int checks = driver.findElements(By.tagName("input")).size();
  	 for (int i = 1; i < 1+checks; i++) {
	  	WebElement checkbox = driver.findElement(By.xpath("//input['"+i+"']"));
  	    if(!checkbox.isSelected())
   			checkbox.click();
      }
  	 System.out.print("\n"+"All boxes checked" +"\n");
  	 System.out.print("----------------------------------"); 
   	}
 
   public void unselect(){
		 int checks = driver.findElements(By.tagName("input")).size();
		 for (int n = 1; n < 1+checks; n++) {	 
		  	WebElement checkbox = driver.findElement(By.xpath("//input["+n+"]"));
			if(checkbox.isSelected())
		       checkbox.click();
			}
		 System.out.print("\n"+"All boxes unchecked" +"\n");
	  	 System.out.print("----------------------------------"+"\n"); 
	   	}
   
   }
