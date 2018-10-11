package main.java.lt.visma.codefights.tests.Instructions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;

public class TestEmptyInput {
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
	    stdin.close();
	}
	
	@Test
	public void testingEmptyInput() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		//getting rid of junk input
		in.readLine();
		in.readLine();
		in.readLine();
		in.readLine();
		//end

		String line = in.readLine();
		assertThat(line, containsString("--fight-me"));
		assertThat(line, containsString("runs your bot against you in interactive mode"));
		
		line = in.readLine();
		assertThat(line, containsString("--fight-bot boxer"));
		assertThat(line, containsString("runs your bot against a built-in boxer bot"));

		line = in.readLine();
		assertThat(line, containsString("--fight-bot kickboxer"));
		assertThat(line, containsString("runs your bot against a built-in kickboxer bot"));
		
		line = in.readLine();
		assertThat(line, containsString("--fight-on-server"));
		assertThat(line, containsString("runs your bot in codefights engine environment"));
	}
}
