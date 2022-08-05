package stepDefinitions;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginStepDefinition {
	
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
    public void user_already_on_login_page(){
		 System.setProperty("webdriver.chrome.driver", "/Users/zankhanapurani/Desktop/Class/SeleniumJars/chromedriver");
		 driver = new ChromeDriver(); 
		driver.get("https://classic.freecrm.com/index.html?e=1");
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.",title);
		
		
		}
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		 driver.findElement(By.name("username")).sendKeys("crmpropro");
	     driver.findElement(By.name("password")).sendKeys("crmpropro");
		
	}
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);
		
	}
	
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		String title = driver.getTitle();
		System.out.println("Home Page title ::"+ title);
        Assert.assertEquals("CRMPRO", title);
	}
	   
	@Then("^Close the browser$")
	public void close_the_browser() {
	    driver.quit();
	    
	}
	

}
