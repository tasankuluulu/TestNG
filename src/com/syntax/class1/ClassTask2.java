package com.syntax.class1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClassTask2 {

	public static WebDriver driver;
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test (groups="smoke")
	public void logo() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();
		WebElement logo = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
		System.out.println(logo.isDisplayed());
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void login() {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		loginButton.click();
		WebElement error = driver.findElement(By.id("spanMessage"));
		String actualErrorText = error.getText();
		String expectedErrorText = "Password cannot be empty";
		if (actualErrorText.equals(expectedErrorText)) {
			System.out.println("The error text is CORRECT");
		} else {
			System.out.println("The error text is INCORRECT");
		}
	}

}
