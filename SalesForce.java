package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		  	  
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("UserFirstName")).sendKeys("Vijay");
		driver.findElement(By.name("UserLastName")).sendKeys("Kumar");
		driver.findElement(By.name("UserEmail")).sendKeys("v@c.com");
		WebElement droptest = driver.findElement(By.name("UserTitle"));
		Select drop = new Select(droptest);
		drop.selectByIndex(5);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("Grow");
		driver.findElement(By.name("CompanyEmployees")).sendKeys("15 - 100 employees");
		driver.findElement(By.name("UserPhone")).sendKeys("0468481044");
		driver.findElement(By.name("CompanyCountry")).sendKeys("Australia");
		driver.findElement(By.name("CompanyState")).sendKeys("New South Wales");
		driver.findElement(By.className("checkbox-ui")).click();
		
		WebElement drop1 = driver.findElement(By.id("day"));
		Select dropone = new Select(drop1);
		dropone.selectByValue("6");
		// driver.findElement(By.name("birthday_day")).sendKeys("6");
		driver.findElement(By.name("birthday_month")).sendKeys("Aug");
		driver.findElement(By.name("birthday_year")).sendKeys("1990");
		driver.findElement(By.xpath("(//input[@class=\"sr-only\"]/following-sibling::div)")).click();
		driver.findElement(By.xpath("(//div[@class='checkbox-ui'])[2]")).click();
		//driver.close();
	}
	

}
