package com.syntax.class1;

import org.testng.annotations.Test;

public class TestNGIntro {
	
	// @Test is a main annotation that identifies how many tests 
	@Test // we use this annotation to mark a method as a test method
	public void testOne() {
		System.out.println("I am test one");
	}

	@Test
	public void testTwo() {
		System.out.println("I am test two");
	}

	@Test
	public void testThree() {
		System.out.println("I am test three");
	}
	
	@Test
	public void testFour() {
		System.out.println("I am test four");
	}
	
	// all test methods will get executed in alphabetical order

}
