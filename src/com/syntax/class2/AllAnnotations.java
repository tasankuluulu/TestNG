package com.syntax.class2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("This is before suite method");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am before test");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class method");

	}

	@BeforeMethod
	public void before() {
		System.out.println("This is before method");

	}

	@Test
	public void testMethod() {
		System.out.println("This is test method");
	}

	@AfterMethod
	public void after() {
		System.out.println("This is after method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am after class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am after test");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("This is after suite method");

	}
}
