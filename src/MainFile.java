package main.java.lt.visma.codefights.tests;

import java.util.Arrays;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import main.java.lt.visma.codefights.tests.FightBot.TestFightBot;
import main.java.lt.visma.codefights.tests.FightMe.TestFightMe;
import main.java.lt.visma.codefights.tests.FightOnServer.TestFightOnServer;
import main.java.lt.visma.codefights.tests.Instructions.TestEmptyInput;

public class MainFile {

	public static void main(String[] args) {
		
		String text = Arrays.toString(args);
		text = text.replaceAll(",", "");
		
		TestFightMe.setStartText(text.substring(1, text.length()-1) + " --fight-me");
		TestFightBot.setStartText(text.substring(1, text.length()-1) + " --fight-bot boxer");
		TestFightOnServer.setStartText(text.substring(1, text.length()-1) + " --fight-on-server");
		TestEmptyInput.setStartText(text.substring(1, text.length()-1));
		
		Result result = JUnitCore.runClasses(TestFightMe.class, TestEmptyInput.class, TestFightBot.class, TestFightOnServer.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
			
		System.out.println(result.wasSuccessful());
    }
}