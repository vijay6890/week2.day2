package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("Demosalesmanager");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		WebElement login = driver.findElement(By.className("decorativeSubmit"));
		login.click();

		WebElement getin = driver.findElement(By.linkText("CRM/SFA"));
		getin.click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("VJ");
		driver.findElement(By.id("lastNameField")).sendKeys("RJ");

//		 * 9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("DJ");

		// * 10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Bravo");

		// * 11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Cricket Test");

		// * 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys("Cricket Test in-progress");

		// * 13. Enter your email in the E-mail address Field using the locator of your
		// choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("v@c.com");

		// * 14. Select State/Province as NewYork Using Visible Text
		WebElement stat = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select drop = new Select(stat);
		drop.selectByValue("NY");

		// * 15. Click on Create Contact
		driver.findElement(By.className("smallSubmit")).click();

		// * 16. Click on edit button
		driver.findElement(By.linkText("Edit")).click();

		// * 17. Clear the Description Field using .clear
		driver.findElement(By.id("updateContactForm_description")).clear();

		// * 18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Testing note");
		// * 19. Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		// * 20. Get the Title of Resulting Page.
		String str = driver.getTitle();
		System.out.println(str);
		// Thread.sleep(3000);
		// driver.close();
	}
}
