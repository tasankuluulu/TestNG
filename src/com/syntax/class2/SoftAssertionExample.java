package com.syntax.class2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
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
		password.sendKeys("Hum@nhrm123 ");
		loginButton.click();
		String actualErrorMsg1 = driver.findElement(By.id("spanMessage")).getText();
		String expectedErrorMsg1 = "Invalid credential";
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actualErrorMsg1, expectedErrorMsg1);
		Thread.sleep(2000);

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("btnLogin")).click();
		String actualErrorMsg2 = driver.findElement(By.id("spanMessage")).getText();
		String expectedErrorMsg2 = "Password cannot be empty ";
		softAssertion.assertEquals(actualErrorMsg2, expectedErrorMsg2);

		softAssertion.assertAll(); // to throw all failed assertions

	}

}
