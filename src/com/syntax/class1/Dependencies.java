package com.syntax.class1;

import org.testng.annotations.Test;

public class Dependencies {

	@Test
	public void login() {
		System.out.println("Login test");
	}

	@Test(dependsOnMethods = "login")
	public void checkReport() {
		System.out.println("Checkreport test");
	}

}
