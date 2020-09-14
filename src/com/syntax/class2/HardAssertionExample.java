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

public class HardAssertionExample {
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	public static WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test(groups="Smoke")
	public void title() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("End of title validation");
	}

	@AfterMethod(alwaysRun=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test (groups="regression")
	public void logoValidation() {
		WebElement element = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		Assert.assertTrue(element.isDisplayed());
	}

	@Test (groups="regression")
	public void loginFormText() {
		WebElement loginText = driver.findElement(By.id("logInPanelHeading"));

		Assert.assertEquals(loginText.getText(), "LOGIN Panel");

	}

}
