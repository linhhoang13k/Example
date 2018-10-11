package com.codefight.arcade;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codefight.arcade.PassCodeCheck;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PassCodeCheckTest {
	public static PassCodeCheck passCodeCheck= null; 
	@BeforeClass
	public static void init(){
		passCodeCheck =  new PassCodeCheck();
	}

	
	@Test
	public void test1(){
		String passcode =  "1234";
		String[] attempts =  {"9999", 
			 "9999", 
			 "9999", 
			 "9999", 
			 "9999", 
			 "9999", 
			 "9999", 
			 "9999", 
			 "9999", 
			 "1234", 
			 "9999", 
			 "9999"};
		
		assertFalse(passCodeCheck.incorrectPasscodeAttempts(passcode, attempts));
	}
	
	@Test
	public void test2(){
		String passcode1 = "1111";
		String[] attempts1 =  {"1111", 
			 "4444", 
			 "9999", 
			 "3333", 
			 "8888", 
			 "2222", 
			 "7777", 
			 "0000", 
			 "6666", 
			 "7285", 
			 "5555", 
			 "1111"};
		assertTrue(passCodeCheck.incorrectPasscodeAttempts(passcode1, attempts1));		
	}
	
	@Test
	public void test3(){
		String passcode1 = "1234";
		String[] attempts1 =  {"9999", 
				 "9999", 
				 "9999", 
				 "9999", 
				 "9999", 
				 "9999", 
				 "9999", 
				 "9999", 
				 "9999", 
				 "1234", 
				 "9999", 
				 "9999"};
		assertFalse(passCodeCheck.incorrectPasscodeAttempts(passcode1, attempts1));		
	}	
	
	@Test
	public void test4(){
		String passcode1 = "1111";
		String[] attempts1 =  {"1111", 
				 "4444", 
				 "9999", 
				 "3333", 
				 "8888", 
				 "2222", 
				 "7777", 
				 "0000", 
				 "6666", 
				 "7285", 
				 "5555", 
				 "1111"};
		assertTrue(passCodeCheck.incorrectPasscodeAttempts(passcode1, attempts1));		
	}	
}
