package com.syntax.class1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HrmsTestCases {
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

	@Test (priority = 2)
	public void validLogin() throws InterruptedException {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("Hum@nhrm123");
		loginButton.click();
		WebElement welcome = driver.findElement(By.id("welcome"));
		String welcomeText = welcome.getText();
		if (welcomeText.contains("Welcome")) {
			System.out.println("The login test PASS");
		} else {
			System.out.println("The login test FAIL");
		}

	}

	@Test (priority = 1, enabled = false)
	public void title() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("The title test PASS");
		} else {
			System.out.println("The title test FAIL");
		}
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
