package main.java.lt.visma.codefights.tests.FightBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFightBot {

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
		    stdin.close();
		    
		    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    String[] lines = new String[100];
		    
		    for (int i = 0; i < 100;i++) {				
				lines[i] = in.readLine();
				if (lines[i] == null) {
					break;
				}
		    }		    	
		    
		    Assert.assertTrue(Arrays.asList(lines).contains("FIGHT OVER"));
		    Assert.assertTrue(Arrays.asList(lines).contains("THE WINNER IS boxer"));
	}
}
