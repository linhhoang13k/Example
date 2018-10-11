package com.codefight.challanges;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class CandyCrushTest {
	private static CandyCrush candyCrush;
	
	@BeforeClass
	public static void init(){
		candyCrush = new CandyCrush();
	}
	
	@Test
	public void test1(){
		char[][] 	gameboard={{'R','B','G'},
				   			   {'R','Y','B'},
				   			   {'R','O','Y'}};
		
		assertTrue(candyCrush.candyCrush1(gameboard));
	}
	
	@Test
	public void test2(){
		char[][] gameboard={{'R','R','R'},
							  {'R','R','Y'},
							  {'O','G','B'}};
		assertTrue(candyCrush.candyCrush1(gameboard));
	}
	
	@Test
	public void test3(){
		char[][] gameboard={{'Y','R','Y'},
							  {'R','Y','R'},
							  {'Y','R','Y'}};
		assertFalse(candyCrush.candyCrush1(gameboard));
	}

	@Test
	public void test4(){
		char[][] gameboard={{'R','G','G','B'},
							  {'B','O','G','G'},
							  {'P','O','B','P'},
							  {'Y','B','Y','O'}};
		assertFalse(candyCrush.candyCrush1(gameboard));
	}
	
	@Test
	public void test5(){
		char[][]  gameboard={{'R','B','G'},
							   {'R','Y','B'},
							   {'R','O','Y'}};		     	   
		assertTrue(candyCrush.candyCrush1(gameboard));
	}
	
	@Test
	public void test6(){
		char[][] gameboard={{'R','G','B','Y'},
							  {'B','G','Y','P'},
							  {'P','G','B','Y'},
							  {'O','G','P','R'}};
		assertTrue(candyCrush.candyCrush1(gameboard));
	}

	@Test
	public void test7(){
		char[][] gameboard={{'R','Y','R','Y'},
							  {'Y','R','Y','R'},
							  {'R','Y','R','Y'},
							  {'Y','R','Y','R'}};	
		assertFalse(candyCrush.candyCrush1(gameboard));
	}
	
	@Test
	public void test8(){
		char[][] gameboard={{'R','G','G','B','Y','R','Y','R','P','O','B','P'}};
		assertFalse(candyCrush.candyCrush1(gameboard));
	}

	@Test
	public void test9(){
		char[][] gameboard={{'R','G','G','G','G','R','Y','R','P','O','B','P'}};
		assertTrue(candyCrush.candyCrush1(gameboard));
	}

	@Test
	public void test10(){
		char[][] gameboard={{'R'},{'G'},{'G'},{'G'},{'R'},{'Y'},{'R'},{'P'},{'O'},{'B'},{'P'}};
		assertTrue(candyCrush.candyCrush1(gameboard));
	}
	
	//////////////
	@Test
	public void test11(){
		char[][] gameboard =  {{'R','B','G'}, 
							   	{'R','Y','B'}, 
							   	{'R','O','Y'}};
		assertTrue(candyCrush.candyCrush1(gameboard));
	}
}
