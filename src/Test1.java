package com.iub.coding.practice.CodeName47;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * String pattern = "((\\.(?i)(jpg|jpeg|png|gif|bmp|webp))$)";
		 * 
		 * Matcher match =
		 * Pattern.compile(pattern).matcher("x.jpeg\r".substring(0,
		 * "x.jpeg\r".lastIndexOf('\r')));
		 * 
		 * if(match.find()) System.out.println(match.group());
		 */
/*
		Integer y = new Integer(2);

		HashSet<Integer> x = new HashSet<Integer>();

		Tiger b;
		Animal a = new Tiger();
		
		System.out.println(a.y);
		
		a= null;*/
		
		System.out.println(testMe());
		//System.gc();

	}
	
	public static int testMe() throws Exception	{
		
		try {
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
		
		finally {
			//return 5;
		}
		
		System.out.println("test");
		return 0;
	}

}

class Animal {

	int x = 0;
	int y = 5;
	
	public Animal(int x)	{
		
	}

	protected int addSomething() {

		return ++x;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
		System.out.println("Deleting parent");
	}
}

class Tiger extends Animal implements Mammal {

	int y = 0;
	Animal an;
	
	public Tiger() {
		// TODO Auto-generated constructor stub
		
		super(1);
	}

	public int addSomething() {

		return (y + 2);
	}
	
	public int addMe()	{
		return 100;
	}
	
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
		System.out.println("Deleting child");

	}
}

interface Mammal	{
	
	int addSomething();
}
