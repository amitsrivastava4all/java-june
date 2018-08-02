package com.brainmentors.testengine.test;

import org.junit.Test;

import com.brainmentors.testengine.util.MathOperations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

public class MathTest {
	MathOperations math ;
@BeforeClass
public void start(){
	math = new MathOperations();
}
@Test(timeout=1000)	
public void shouldAddTwoNumbers(){
	int expectedResult = 30;
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	int result = math.add(10, 20);
	Assert.assertEquals(expectedResult, result);
}
@Test
@Ignore
public void shouldAddTwoNegativeNumbers(){
	int expectedResult = -300;
	//MathOperations math = new MathOperations();
	int result = math.add(-100, -200);
	Assert.assertEquals(expectedResult, result);
}
	

}
