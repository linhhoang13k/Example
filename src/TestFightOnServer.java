package main.java.lt.visma.codefights.tests.FightOnServer;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;

public class TestFightOnServer {
	Process p;
	PrintWriter stdin;
	public static String startText;
	
	public static void setStartText(String text) {
		startText = text;
	}
	
	@Before
	public void setUp() throws IOException {
		
		p = Runtime.getRuntime().exec("cmd");
	    stdin = new PrintWriter(p.getOutputStream());
	    stdin.println(startText);
	}
	
	@Test
	public void testingFightBoxer() throws IOException {
			stdin.println("YOUR-SCORE 10 OPPONENT-SCORE 10 ENEMY-MOVE bnbnbn");
			stdin.println("YOUR-SCORE 10 OPPONENT-SCORE 10 ENEMY-MOVE ajajaj");
		    stdin.close();
		    
		    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    
		    for (int i = 0; i < 5;i++) {				
				in.readLine();
		    }		    	
		    
			String line = in.readLine();
			assertEquals("Should be equal", "an", line);
			assertEquals("Should be equal", "bnbnbn", in.readLine());
			assertEquals("Should be equal", "ajajaj", in.readLine());
	}
}
