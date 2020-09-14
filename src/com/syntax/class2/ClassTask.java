package com.syntax.class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClassTask {
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void invalidLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();

		WebElement PIM = driver.findElement(By.linkText("PIM"));
		PIM.click();

		WebElement addEmp = driver.findElement(By.id("menu_pim_addEmployee"));
		addEmp.click();

		WebElement fullName = driver.findElement(By.id("firstName"));
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(fullName.isDisplayed());

		WebElement empID = driver.findElement(By.xpath("//label[@for='employeeId']"));
		softAssertion.assertTrue(empID.isDisplayed());

		WebElement photo = driver.findElement(By.xpath("//label[@for='photofile']"));
		softAssertion.assertTrue(photo.isDisplayed());

		WebElement uploadPhoto = driver.findElement(By.id("photofile"));
		uploadPhoto.sendKeys("C:\\Users\\talaf\\Desktop\\img1.jpg");

		driver.findElement(By.id("firstName")).sendKeys("Ivan1");
		driver.findElement(By.id("lastName")).sendKeys("Ivanov1");
		WebElement save = driver.findElement(By.id("btnSave"));
		save.click();

		String actualName = driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
		String expectedName = "Ivan1 Ivanov1";
		softAssertion.assertEquals(actualName, expectedName);

		softAssertion.assertAll();

	}
}
