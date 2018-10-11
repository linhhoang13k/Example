package com.codefight.arcade;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReverseParentheses1Test {
	private static ReverseParentheses rp;
	
	@BeforeClass
	public static void init(){
		rp = new ReverseParentheses();
	}
	@Test
	public void test1(){
		String s = "a(bc)de";
		assertEquals("acbde", rp.reverseParentheses(s));	
	}
	@Test
	public void test2(){
		String s = "a(bcdefghijkl(mno)p)q";
		assertEquals("apmnolkjihgfedcbq", rp.reverseParentheses(s));	
	}
	@Test
	public void test3(){
		String s = "co(de(fight)s)";
		assertEquals("cosfighted", rp.reverseParentheses(s));	
	}
	@Test
	public void test4(){
		String s = "Code(Cha(lle)nge)";
		assertEquals("CodeegnlleahC", rp.reverseParentheses(s));	
	}
	@Test
	public void test5(){
		String s = "Where are the parentheses?";
		assertEquals("Where are the parentheses?", rp.reverseParentheses(s));	
	}
	@Test
	
	public void test6(){
		String s = "abc(cba)ab(bac)c";
		assertEquals("abcabcabcabc", rp.reverseParentheses(s));	
	}
	
	@Test
	public void test7(){
		String s = "The ((quick (brown) (fox) jumps over the lazy) dog)";
		assertEquals("The god quick nworb xof jumps over the lazy", rp.reverseParentheses(s));	
	}
}
