package com.codefight.arcade;

import org.junit.BeforeClass;
import org.junit.Test;

import com.codefight.arcade.WordLadder;

import static org.junit.Assert.assertEquals;

public class WordLadderTest {
	private static WordLadder wLadder;
	
	@BeforeClass
	public static void init(){
		wLadder = new WordLadder();
	}
	
	@Test
	public void test1(){
		String beginWord ="hit";
		String endWord = "cog";
		String[] wordList = {"hot", 
				 "dot", 
				 "dog", 
				 "lot", 
				 "log", 
				 "cog"};
		int count = wLadder.wordLadder(beginWord, endWord, wordList);
		assertEquals(5, count);
	}	
	
	@Test
	public void test2(){
		String beginWord ="a";
		String endWord = "c";
		String[] wordList = {"a", "b", "c"};
		int count = wLadder.wordLadder(beginWord, endWord, wordList);
		assertEquals(2, count);
	}	
	
	@Test
	public void test3(){
		String beginWord ="hit";
		String endWord = "cog";
		String[] wordList = {"hot", 
				 "dot", 
				 "dog", 
				 "lot", 
				 "log" };
		int count = wLadder.wordLadder(beginWord, endWord, wordList);
		assertEquals(0, count);
	}	

		@Test
		public void test4(){
			String beginWord ="hot";
			String endWord = "dog";
			String[] wordList = {"hot", 
					 "dog" };
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(0, count);
		}	

		@Test
		public void test5(){
			String beginWord ="hot";
			String endWord = "dog";
			String[] wordList = {"hot", 
								 "cog", 
								 "dog", 
								 "tot", 
								 "hog", 
								 "hop", 
								 "pot", 
								 "dot" };
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(0, count);
		}	

		@Test
		public void test6(){
			String beginWord ="hot";
			String endWord = "dot";
			String[] wordList = { "hot", 
								 "dog", 
								 "cog", 
								 "pot", 
								 "dot"};
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(2, count);
		}	

		@Test
		public void test7(){
			String beginWord ="hit";
			String endWord = "cog";
			String[] wordList = {"hot", 
								 "cog", 
								 "dot", 
								 "dog", 
								 "hit", 
								 "lot", 
								 "log" };
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(5, count);
		}			

		@Test
		public void test8(){
			String beginWord ="lost";
			String endWord = "cost";
			String[] wordList = {"most", 
								 "fist", 
								 "lost", 
								 "cost", 
								 "fish" };
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(2, count);
		}			

		@Test
		public void test9(){
			String beginWord ="talk";
			String endWord = "tail";
			String[] wordList = { "talk", 
								 "tons", 
								 "fall", 
								 "tail", 
								 "gale", 
								 "hall", 
								 "negs"};
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(0, count);
		}			

		@Test
		public void test10(){
			String beginWord ="kiss";
			String endWord = "tusk";
			String[] wordList = {"miss", 
								 "dusk", 
								 "kiss", 
								 "musk", 
								 "tusk", 
								 "diss", 
								 "disk", 
								 "sang", 
								 "ties", 
								 "muss" };
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(5, count);
		}			

		@Test
		public void test11(){
			String beginWord ="teach";
			String endWord = "place";
			String[] wordList = {"peale",
								 "wilts", 
								 "place", 
								 "fetch", 
								 "purer", 
								 "pooch", 
								 "peace", 
								 "poach", 
								 "berra", 
								 "teach", 
								 "rheum", 
								 "peach" };
			int count = wLadder.wordLadder(beginWord, endWord, wordList);
			assertEquals(4, count);
		}			
}
