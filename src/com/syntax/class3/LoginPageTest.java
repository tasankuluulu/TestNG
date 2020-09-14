package com.syntax.class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
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

	@Test(dataProvider = "getData")
	public void multipleLogin(String usernameFromData, String passwordFromData, String name) {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginButton = driver.findElement(By.id("btnLogin"));
		username.sendKeys(usernameFromData);
		password.sendKeys(passwordFromData);
		loginButton.click();

		WebElement welcome = driver.findElement(By.id("welcome"));
		String welcomeText = welcome.getText();

		Assert.assertEquals(welcomeText, "Welcome " + name);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "Admin", "Hum@nhrm123", "Admin" }, { "JohnTest", "Syntax123!", "John" },
				{ "KokaL", "Kokaytvyn$12345", "Koka" } };
		return data;
	}

}
