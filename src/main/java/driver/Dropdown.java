package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends Driver {
	
    @FindBy(id="dropdown")
    private WebElement dropdown;

    public Dropdown(WebDriver driver) {
		super(driver);
	}

   public void select(String option) throws InterruptedException{
	 driver.get("https://the-internet.herokuapp.com/dropdown");
	 Select select = new Select(this.dropdown);
	 select.selectByVisibleText(option);
	 }
   
    public WebElement getDropdown() {
    	return dropdown;
    }
    
}
