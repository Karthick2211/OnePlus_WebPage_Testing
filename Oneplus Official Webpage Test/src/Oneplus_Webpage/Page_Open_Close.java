package Oneplus_Webpage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Page_Open_Close {
	WebDriver driver;
  
  @BeforeClass
  public void Page_Open() {
  driver=new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://www.oneplus.in/");
  
  }
  
  @Test(priority=1)
  
  public void Selecting_phone_option() {
  driver.findElement(By.xpath("/html/body/header/div/div[1]/header/div[2]/div[2]/ul/li[1]/a/span")).click();
  	  
  }
  
  @Test(priority=2)
  
  public void Cookies_Popup() throws InterruptedException {
	
	  WebDriverWait Close_Cookies_Popup = new WebDriverWait(driver,Duration.ofSeconds(30));
	 
	  Close_Cookies_Popup.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div/div[3]/div[1]/a/img")));
	  
	  driver.findElement(By.xpath("/html/body/div[10]/div/div[3]/div[1]/a/img")).click();
	  
	  //Thread.sleep(9000);
	  
	 // try {
       //   WebElement Close_Cookies_Popup = driver.findElement(By.xpath("/html/body/div[10]/div/div[3]/div[1]/a/img")); 
         // if (Close_Cookies_Popup.isDisplayed()) {
        //	  Close_Cookies_Popup.click();
     //     }
      //} catch (Exception e) {
                //}
  
  }
@Test(priority=3)
  
  public void Sort_N_Filter() {
	
  WebElement Series_Button = driver.findElement(By.xpath("//*[@id='CAT00005010cus101689822205444']"));
  Series_Button.click();
  
  WebElement Ram_Storage = driver.findElement(By.xpath("//*[@id=\'CAT00005010cus111689822205445\']"));
  Ram_Storage.click();
  
  WebElement Availability = driver.findElement(By.xpath("//*[@id=\'AVAILABILITY_STOCK\']"));
  Availability.click();

  }
 
@Test(priority=4)

public void Selecting_Oneplus11() {
	
	WebElement Select_Oneplus11 = driver.findElement(By.xpath("//a[@productname='OnePlus 11 5G']"));
	Select_Oneplus11.click();
	
}

@Test(priority=5)

public void Verify_N_AddToCart() throws InterruptedException {
	Thread.sleep(8000);
	
	Set<String> OnePlus11_Tab = driver.getWindowHandles();
	List<String> Tab = new ArrayList<String>(OnePlus11_Tab);
	driver.switchTo().window(Tab.get(1));
	System.out.println(driver.getCurrentUrl());
	
	
	WebElement addtocart = driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div/div[2]/div/div[1]/div"));
	addtocart.click();
}

@Test (priority=6)

 public void Checkout () throws InterruptedException {
	
	WebDriverWait time = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	time.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[5]/div/div/div/div[3]/div/div[2]/div")));  
	driver.findElement(By.xpath("/html/body/main/div[5]/div/div/div/div[3]/div/div[2]/div")).click();
	
	//WebElement Skip_addon = driver.findElement(By.xpath("/html/body/main/div[5]/div/div/div/div[3]/div/div[2]/div"));
	//Skip_addon.click();
	
	time.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"final_checkout\"]")));  
	driver.findElement(By.xpath("//*[@id=\"final_checkout\"]")).click();
	
	

	System.out.println(driver.getCurrentUrl());
	
	
}
  @AfterClass
  public void Page_Close() throws InterruptedException {
	  Thread.sleep(30000);
	  driver.quit();
  }

}
