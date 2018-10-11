package main;

import java.util.Scanner;

public class CheckPalindromeApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("To check if string is palindrome, please enter one:");

		String inputString = scanner.next();

		boolean result = CheckPalindrome.checkPalindrome(inputString);

		if (result == true) {
			System.out.println("This is a palindrome!");
		} else {
			System.out.println("Sorry, this isn't a palindrome..");
		}

		scanner.close();

	}

}
