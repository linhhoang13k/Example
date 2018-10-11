package main.java.lt.visma.codefights.tests.FightMe;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

public class TestFightMe {
	
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
	public void testingAttackNose() throws IOException {
		    stdin.println("AN");
		    stdin.close();
		    System.out.println("asdf");
		    assertPrintedInfoIsCorrect(": You attacked NOSE(+),  scoring 10  and was NOT defending at all.");
	}
	
	@Test
	public void testingAttackJaw() throws IOException {
		    stdin.println("AJ");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You attacked JAW(+),  scoring 8  and was NOT defending at all.");
	}
	
	@Test
	public void testingAttackBelly() throws IOException {
		    stdin.println("AB");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You attacked BELLY(+),  scoring 6  and was NOT defending at all.");
	}
	
	@Test
	public void testingAttackGroin() throws IOException {
		    stdin.println("AG");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You attacked GROIN(+),  scoring 4  and was NOT defending at all.");
	}
	
	@Test
	public void testingAttackLeggs() throws IOException {
		    stdin.println("AL");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You attacked LEGS(+),  scoring 3  and was NOT defending at all.");
	}
	
	@Test
	public void testingAttackNoseNose() throws IOException {
		    stdin.println("ANAN");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You attacked NOSE(+), NOSE(+),  scoring 20  and was NOT defending at all.");
	}
	
	@Test
	public void testingAttackNoseNoseNose() throws IOException {
		    stdin.println("ANANAN");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You attacked NOSE(+), NOSE(+), NOSE(+),  scoring 30  and was NOT defending at all.");
	}
	
	@Test
	public void testingBlockingNose() throws IOException {
		    stdin.println("BN");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending NOSE");
	}
	
	@Test
	public void testingBlockingJaw() throws IOException {
		    stdin.println("BJ");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending JAW");
	}
	
	@Test
	public void testingBlockingBelly() throws IOException {
		    stdin.println("BB");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending BELLY");
	}
	
	@Test
	public void testingBlockingGroin() throws IOException {
		    stdin.println("BG");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending GROIN");
	}
	
	@Test
	public void testingBlockingLeggs() throws IOException {
		    stdin.println("BL");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending LEGS");
	}
	
	@Test
	public void testingBlockingNoseNose() throws IOException {
		    stdin.println("BNBN");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending NOSE, NOSE");
	}
	
	@Test
	public void testingBlockingNoseNoseNose() throws IOException {
		    stdin.println("BNBNBN");
		    stdin.close();

		    assertPrintedInfoIsCorrect("You did NOT attack at all  while defending NOSE, NOSE, NOSE");
	}
	
	@Test
	public void testingVictory() throws IOException {
		    stdin.println("AJAJAJ");
		    stdin.println("AJAJAJ");
		    stdin.println("AJAJAJ");
		    stdin.println("AJAJAJ");
		    stdin.println("AJAJAJ");
		    stdin.println("AJAJAJ");
		    stdin.println("AJAJAJ");
		    stdin.close();

		    BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    
		    
	    	for (int i = 0; i < 30;i++) {				
				in.readLine();
		    }		    	
		    
		    assertEquals("Should be equal", "You vs Your bot: -4 to -18", in.readLine());
		    in.readLine();//empty line
			assertEquals("Should be equal", "FIGHT OVER", in.readLine());
			assertThat(in.readLine(), containsString("THE WINNER IS You"));
	}
			
	public void assertPrintedInfoIsCorrect(String text) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		//getting rid of junk input
		in.readLine();
		in.readLine();
		in.readLine();
		in.readLine();
		//end
		String line = in.readLine();

		assertTrue(line.contains("Make your move by (A)ttacking and (B)locking (N)ose, (J)aw, (B)elly, (G)roin, (L)egs"));		
		assertTrue(line.contains("(for example, BN BB AN)"));
		assertTrue(line.contains(text));
	}
}
