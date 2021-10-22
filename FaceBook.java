package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Step 1: Download and set the path
		// Step 2: Launch the chromebrowser
		// Step 3: Load the URL https://en-gb.facebook.com/
		// Step 4: Maximise the window
		// Step 5: Add implicit wait
		// Step 6: Click on Create New Account button
		// Step 7: Enter the first name
		// Step 8: Enter the last name
		// Step 9: Enter the mobile number
		// Step 10: Enterthe password
		// Step 11: Handle all the three drop downs
		// Step 12: Select the radio button "Female"
		// ( A normal click will do for this step)

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Vijay");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("0468481044");
		driver.findElement(By.xpath("(//input[@type=\"password\"])[2]")).sendKeys("FBTEST");

		WebElement drop1 = driver.findElement(By.id("day"));
		Select dropone = new Select(drop1);
		dropone.selectByValue("6");
		// driver.findElement(By.name("birthday_day")).sendKeys("6");
		driver.findElement(By.name("birthday_month")).sendKeys("Aug");
		driver.findElement(By.name("birthday_year")).sendKeys("1990");
		driver.findElement(By.xpath("//label[text()=\"Female\"]")).click();
	}

}
