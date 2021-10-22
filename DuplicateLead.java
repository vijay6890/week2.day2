package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
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

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//span[@class = 'x-tab-strip-text '])[3]")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("vijayvinod123@gmail.com");
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		String leadid = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).getText();
		System.out.println(leadid);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();
		driver.findElement(By.className("subMenuButton")).click();
		boolean content = driver.getTitle().contains("Duplicate Lead");
		System.out.println(content);
		driver.getTitle();
		driver.findElement(By.className("smallSubmit")).click();
		String Firstname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			if (Firstname.equals(leadid)) {
			System.out.println("duplicated lead name " +Firstname+ " is same as original lead name");
		}
		
		Thread.sleep(2000);
		driver.close();
	}
}
