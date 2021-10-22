package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Kumar");
		driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[2]")).click();
		System.out.println("My page title is " + driver.getTitle());

		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("NewCompany");
		String Newcompany = "NewCompany";
		driver.findElement(By.className("smallSubmit")).click();
		String attribute = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (attribute.contains(Newcompany)) {
			System.out.println(
					"My new company name is: " + driver.findElement(By.id("viewLead_companyName_sp")).getText());
		} else {
			System.out.println("NewCompany is not there");
		}
		Thread.sleep(2000);
		driver.close();
	}
}
