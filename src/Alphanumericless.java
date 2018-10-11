package algo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * https://codefights.com/challenge/cg2EGXh8NWczxCS5L
 * 
 * An alphanumeric ordering of strings is defined as follows: each string is
 * considered as a sequence of tokens, where each token is a letter or a number
 * (as opposed to an isolated digit, as is the case of lexicographic ordering).
 * For example, the tokens of a string "ab01c004" are [a, b, 01, c, 004]. In
 * order to compare two strings, you break them down into tokens and compare
 * corresponding pairs of tokens with each other (i.e. first token of the first
 * string, with the first token of the second string etc).
 * 
 * Here is how tokens are compared:
 * 
 * If a letter is compared with another letter, the usual order applies. A
 * number is always less than a letter. When two numbers are compared, their
 * values are compared. Leading zeros, if any, are ignored.
 * 
 * If at some point one string has no more tokens left while the other one still
 * does, the one with fewer tokens is considered smaller.
 * 
 * If the two strings s1 and s2 appear to be equal, consider the smallest index
 * i such that tokens(s1)[i] and tokens(s2)[i] (where tokens(s)[i] is the ith
 * token of string s) differ only by the number of leading zeros. If no such i
 * exists, the strings are indeed equal. Otherwise, the string whose ith token
 * has more leading zeros is considered less.
 * 
 * Here are some examples of comparing strings using alphanumeric ordering.
 * 
 * "a" < "a1" < "ab" "ab42" < "ab000144" < "ab00144" < "ab144" < "ab000144x"
 * "x11y012" < "x011y13"
 * 
 * Example
 * 
 * For s1 = "a" and s2 = "a1", the output should be alphanumericLess(s1, s2) =
 * true; For s1 = "ab" and s2 = "a1", the output should be alphanumericLess(s1,
 * s2) = false; For s1 = "b" and s2 = "a1", the output should be
 * alphanumericLess(s1, s2) = false.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] string s1
 * 
 * String, consisting of Latin letters and digits.
 * 
 * Guaranteed constraints: 1 ≤ s1.length ≤ 20.
 * 
 * [input] string s2
 * 
 * String, consisting of Latin letters and digits.
 * 
 * Guaranteed constraints: 1 ≤ s2.length ≤ 20.
 * 
 * [output] boolean
 * 
 * true if s1 is alphanumerically strictly less than s2, false otherwise.
 * 
 */
public class AlphaNumericLess {

	boolean alphanumericLess(String s1, String s2) throws Exception {

		List<String> s1_tokens = splitIntoTokens(s1);
		List<String> s2_tokens = splitIntoTokens(s2);
		return compareTokens(s1_tokens, s2_tokens);

	}

	/**
	 * 
	 * 
	 */
	int compare_Str1_To_Str2(String str1, String str2) throws Exception {

		boolean str1_is_Number = false;
		boolean str2_is_Number = false;

		if (str1.length() > 1)
			str1_is_Number = true;
		else
			str1_is_Number = Character.isDigit(str1.charAt(0));

		if (str2.length() > 1)
			str2_is_Number = true;
		else
			str2_is_Number = Character.isDigit(str2.charAt(0));

		if (!str1_is_Number && str2_is_Number)
			return 1;
		if (str1_is_Number && !str2_is_Number)
			return -1;
		if (!str1_is_Number && !str2_is_Number)
			return str1.compareTo(str2);

		// compare 2 numbers

		BigDecimal number1 = new BigDecimal(str1.toCharArray());
		BigDecimal number2 = new BigDecimal(str2.toCharArray());

		return number1.compareTo(number2);
	}

	int compareEqualStrings(String str1, String str2) throws Exception {

		boolean str1_is_Number = false;

		if (str1.length() > 1)
			str1_is_Number = true;
		else
			str1_is_Number = Character.isDigit(str1.charAt(0));

		if (str1_is_Number)
			return (str2.length() - str1.length());

		return 0;

	}

	/**
	 * 
	 * 
	 */
	boolean compareTokens(List<String> tok1, List<String> tok2)
			throws Exception {

		int tokLength = 0;

		if (tok1.size() <= tok2.size())
			tokLength = tok1.size();
		else
			tokLength = tok2.size();

		for (int i = 0; i < tokLength; i++) {

			if (compare_Str1_To_Str2(tok1.get(i), tok2.get(i)) == 0)
				continue;
			if (compare_Str1_To_Str2(tok1.get(i), tok2.get(i)) < 0)
				return true;
			return false;

		}

		if (tok1.size() < tok2.size())
			return true;

		// if strings equal we check leading zeros
		for (int i = 0; i < tokLength; i++) {

			if (compareEqualStrings(tok1.get(i), tok2.get(i)) < 0)
				return true;
			if (compareEqualStrings(tok1.get(i), tok2.get(i)) > 0)
				return false;

		}

		return false;
	}

	/**
	 * 
	 * 
	 */
	List<String> splitIntoTokens(String str) throws Exception {

		List<String> tokens = new ArrayList<String>();

		StringBuilder strB = new StringBuilder(str);
		StringBuilder strNumbers = new StringBuilder();

		for (int i = 0; i < strB.length(); i++) {

			char current = strB.charAt(i);
			boolean isDigit = Character.isDigit(current);

			if (isDigit) {
				// Cumulate number
				strNumbers.append(current);
				continue;
			}

			if (strNumbers.length() > 0) {
				// Add number
				tokens.add(strNumbers.toString());
				strNumbers.setLength(0);
			}
			;

			// Add letter
			tokens.add(String.valueOf(current));

		}

		// Add number in the end of the string
		if (strNumbers.length() > 0)
			tokens.add(strNumbers.toString());

		return tokens;
	}

}
