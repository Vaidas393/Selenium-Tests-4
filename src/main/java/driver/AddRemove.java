package driver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemove extends Driver {

	@FindBy(linkText="Add/Remove Elements")
    private WebElement link;

    @FindBy(xpath="//*[@id=\"content\"]/div/button")
    private WebElement addButton;

    @FindBy(className="added-manually")
    private WebElement addedButtons;
    
    @FindBy(xpath="//*[@id=\"elements\"]/button[1]")
    private WebElement deleteButton;
    
    @FindBy(id="elements")
    private WebElement elementsDiv;
    
    public AddRemove(WebDriver driver) {
		super(driver);
	}

   public void addButtons(){
	 driver.get("https://the-internet.herokuapp.com/");
	 this.link.click();
	 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	 for (int i = 0; i < 20; i++) {
	 this.addButton.click();
	 }
 	 int size = driver.findElements(By.className("added-manually")).size();
	 System.out.print("----------------------------------"); 
     System.out.print("\n"+"Number of buttons added:" + size +"\n");
     }
   
   public void removeButtons(){
	   	 for (int i = 0; i < 20; i++) {
		 this.deleteButton.click();
		 }
		 System.out.print("----------------------------------"); 
	     System.out.print("\n"+"Buttons deleted:" +"\n");
	     }
    
    public WebElement getLink() {
    	return link;
    }
    
    public WebElement getaddButton() {
    	return addButton;
    }
    
    public WebElement getaddedButtons() {
    	return addedButtons;
    }
    
    public WebElement getdeleteButton() {
    	return deleteButton;
    }
    
    public WebElement getElementsDiv() {
    	return elementsDiv;
    }
    
}
