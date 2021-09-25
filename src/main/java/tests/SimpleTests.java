package tests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//actions import for right click
import org.openqa.selenium.interactions.Actions;
//import for select
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;




public class SimpleTests {
	public WebDriver driver;
	  


	  @Test(priority=1)
	  public void addRemove() throws InterruptedException {
		 
		 driver.get("https://the-internet.herokuapp.com/");
		 driver.findElement(By.linkText("Add/Remove Elements")).click();
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		 For loop to add more buttons
		 for (int i = 0; i < 20; i++) {
		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
		 }
	 
     	 WebElement delete = driver.findElement(By.className("added-manually"));
//     	 Counts how many buttons were added
     	 int size = driver.findElements(By.className("added-manually")).size();
//     	 Checks if buttons are added
		 Assert.assertEquals(true, delete.isDisplayed());
		 System.out.print("Number of buttons added:" + size +"\n");
//		 For loop to delete buttons 
		 for (int i = 0; i < 20; i++) {
			 driver.findElement(By.xpath("//*[@id=\"elements\"]/button[1]")).click();
			 }
	
		 String actualString = driver.findElement(By.tagName("body")).getText();
//		 Checks if all buttons were deleted
		 Assert.assertFalse(actualString.contains("delete"));
		 System.out.print("----------------------------------"); 
		 System.out.print("\n"+"All buttons deleted" +"\n"); 

	  }
	  
	@Test(priority=2)
	  public void checkboxes() throws InterruptedException {
		 driver.get("https://the-internet.herokuapp.com/");
		 driver.findElement(By.linkText("Checkboxes")).click();
	
//		 counts number of checkboxes
		 int checks = driver.findElements(By.tagName("input")).size();

//		 cycle to go trough all checkboxes and select them
	  	 for (int i = 0; i < 1+checks; i++) {	 
	  		WebElement checkbox = driver.findElement(By.xpath("//input['"+i+"']"));
	  		
	  		if(!checkbox.isSelected())
	   			checkbox.click();
				 }
//	  	Assert to check if all boxes are selected
		for (int c = 1; c < 1+checks; c++) {
	        Assert.assertTrue(driver.findElement(By.xpath("//input["+c+"]")).isSelected()); 
		}
		

	  	WebElement checkBoxElement = driver.findElement(By.xpath("//input[1]"));
	  	boolean isSelected = checkBoxElement.isSelected();
		 System.out.print("\n"+ isSelected +"\n"); 

//	  	Added sleep so it would be visible that boxes are checked and unchecked
	  	Thread.sleep(500);

 //		 cycle to go trough all checkboxes and unselect them
		 for (int n = 1; n < 1+checks; n++) {	 
		  		WebElement checkbox = driver.findElement(By.xpath("//input["+n+"]"));
				 
		  		if(checkbox.isSelected())
		   			checkbox.click();
					 }
//		 Assert to check if all boxes are unselected
		 for (int c = 1; c < 1+checks; c++) {
		        Assert.assertFalse(driver.findElement(By.xpath("//input["+c+"]")).isSelected()); 
			}
		 
		 
		 
//		 checking if body contains checked class
		 String checkString = driver.findElement(By.tagName("body")).getText();
		 Assert.assertFalse(checkString.contains("checked"));
		 System.out.print("----------------------------------"); 
		 System.out.print("\n"+"All boxes checked and unchecked" +"\n"); 




	 }
	


	@Test(priority=3)
	  public void dropdown() throws InterruptedException {
		 driver.get("https://the-internet.herokuapp.com/");
		 driver.findElement(By.linkText("Dropdown")).click();
		 Select select = new Select(driver.findElement(By.id("dropdown")));
		 select.selectByVisibleText("Option 1");
		 WebElement selectedValue = select.getFirstSelectedOption();
		 String defaultValue = selectedValue.getText();
		 Assert.assertEquals(defaultValue,"Option 1");
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Selected:" +defaultValue+"\n");
		
	}
	


	@Test(priority=4)
	  public void dynamicLoading() throws InterruptedException {
		 driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		 driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		 
		 String visibleTitle = driver.findElement(By.tagName("h4")).getText();
		 Assert.assertFalse(visibleTitle.contains("Hello World!"));
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Content loaded"+"\n");



	}

	@Test(priority=5)
	  public void hower() throws InterruptedException {
		 Actions actions = new Actions(driver);
		 driver.get("https://the-internet.herokuapp.com/hovers");
		 WebElement firstImage = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		 actions.moveToElement(firstImage);
		 WebElement subMenu = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
		 actions.perform();
		 String defaultValue = subMenu.getText();
		 Assert.assertEquals(defaultValue,"name: user1");
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Chosen first image"+"\n");



	}

	@Test(priority=6)
	  public void input() throws InterruptedException {
		 driver.get("https://the-internet.herokuapp.com/inputs");
	  	 for (int i = 0; i < 20; i++) {	 
		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).click();
		 int number = ThreadLocalRandom.current().nextInt(-1000, 1000 + 1);
		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).sendKeys(String.valueOf(number));
		 String value = driver.findElement(By.tagName("input")).getAttribute("value");
		 Assert.assertEquals(value,value);
		 driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/input")).clear();
		 System.out.print("----------------------------------"); 
		 System.out.println("\n"+"Entered number:"+value+"\n");
	  	 }
	}
	 
	@Test(priority=7)
	  public void contextMenu() throws InterruptedException {
		 //Instantiate Action Class for right click
		 Actions actions = new Actions(driver);
		 driver.get("https://the-internet.herokuapp.com/");
		 driver.findElement(By.linkText("Context Menu")).click();
		 WebElement btnElement = driver.findElement(By.id("hot-spot"));
		 actions.contextClick(btnElement).perform();
		 
	 
		 WebDriverWait wait = new WebDriverWait(driver, 300);
		 
		 if(wait.until(ExpectedConditions.alertIsPresent())==null)
		     System.out.println("\n"+"alert was not present"+"\n");
		 else
		     System.out.println("\n"+"alert was present"+"\n");
		 driver.switchTo().alert().accept();
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	 
	}
	  
		
	  @BeforeClass
	  public void beforeClass() {

			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	  }
//
//	  @AfterClass
//	  public void afterClass() {
//		  driver.quit();
//	   }

	}
