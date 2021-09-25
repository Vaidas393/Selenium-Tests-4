package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Driver {
	protected WebDriver driver;

	public Driver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
