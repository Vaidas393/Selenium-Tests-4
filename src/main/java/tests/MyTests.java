package tests;
import driver.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MyTests {

	public WebDriver driver;
	public AddRemove addremove;
	public Checkboxes checkboxes;
	public Dropdown dropdown;
	public DynamicLoading dynamicLoading;
	public Hower hower;
	public Inputs numberInputs;
	public Tables table;
	public ContextMenu context;
	
	@Test(priority=1)
	public void AddButtons() throws InterruptedException {
	addremove = new AddRemove(driver);
	addremove.addButtons();
	Assert.assertEquals(addremove.getaddedButtons().getText(), "Delete");
	}
	
	@Test(priority=2)
	public void RemoveButtons() throws InterruptedException {
	addremove = new AddRemove(driver);
	addremove.removeButtons();
	Assert.assertEquals(addremove.getElementsDiv().getSize().toString(), "(970, 0)");
	}

	@Test(priority=3)
	public void SelectCheckboxes() throws InterruptedException {
	checkboxes = new Checkboxes(driver);
	checkboxes.select();
	int checks = driver.findElements(By.tagName("input")).size();
		for (int c = 1; c < 1+checks; c++) {
	    Assert.assertTrue(driver.findElement(By.xpath("//input["+c+"]")).isSelected()); 
		}
	}
	
	@Test(priority=4)
	public void UnselectCheckboxes() throws InterruptedException {
	checkboxes = new Checkboxes(driver);
	checkboxes.unselect();
	int checks = driver.findElements(By.tagName("input")).size();
		for (int c = 1; c < 1+checks; c++) {
	    Assert.assertFalse(driver.findElement(By.xpath("//input["+c+"]")).isSelected()); 
		}
	}
	
	@Test(priority=5)
	public void Dropdown() throws InterruptedException {
	dropdown = new Dropdown(driver);
	dropdown.select("Option 1");
	Select select = new Select(dropdown.getDropdown());
	WebElement selectedValue = select.getFirstSelectedOption();
	String defaultValue = selectedValue.getText();
	Assert.assertEquals(defaultValue,"Option 1");
	System.out.println("\n"+"Selected:" +defaultValue+"\n");
	}
	
	@Test(priority=6)
	public void DynamiclyLoaded() throws InterruptedException {
	dynamicLoading = new DynamicLoading(driver);
	dynamicLoading.visible();
    Assert.assertTrue(dynamicLoading.getLoadedDiv().isDisplayed()); 
	}
	
	@Test(priority=7)
	public void CheckHower() throws InterruptedException {
	hower = new Hower(driver);
	hower.howerCheck(3);
	int number = 3;
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div["+number+"]/div/h5")).isDisplayed()); 
	}
	
	@Test(priority=8)
	public void EnterInputs() {
	numberInputs = new Inputs(driver);
	numberInputs.numberEntering();
	Assert.assertTrue(numberInputs.getInputField().isDisplayed()); 
	}
	
	@Test(priority=9)
	public void TableSorting() throws InterruptedException {
	table = new Tables(driver);
	table.tableSorting();
	Assert.assertEquals(table.getSortedLastName().getText(), "Bach");
	}
	
	@Test(priority=10)
	public void AlertCheck(){
	context = new ContextMenu(driver);
	context.checkingAlert();
	Assert.assertTrue(context.getContextArea().isDisplayed());
	}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
	}

	@AfterClass
	public void afterClass() {
     driver.quit();
	}
}
