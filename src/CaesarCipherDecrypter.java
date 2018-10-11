/**
 * 
 */
package com.codefight.challanges;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author muralimanohar
 *The captain has just intercepted a message from the opposition. But they were clever (or not?) enough to encode it using the Caesar Cipher, leaving the captain unable to get the information he needed.
 *
 *Having zero patience with figuring out the right number themselves, they ask for you and the IT department's help to crack the message.
 *
 *You and the IT department are bored as well, and decide to just mess around and see who can make a program that can crack the encoded string (Nobody wants to shift it 26 times, that's boring and tedious!)
 *
 *Example
 *For messge = "Uijt jt b sfbebcmf tusjoh jo Fohmjti!", the output should be
 *privateEyesOnly(message) = "This is a readable string in English!".
 *
 *Out of all the 26 possible shifts, the only readable (and valid) string is when you shift 25 times "This is a readable string in English!".
 *
 *Input/Output
 *
 *[execution time limit] 3 seconds (java)
 *
 *[input] string message
 *
 *The encoded string, and it is guaranteed to be readable in English and forms a sentence(s).
 *
 *Guaranteed constraints:
 *9 < a.length < 2000.
 *The only special characters are ' , . ! ? ( )
 *
 *[output] string
 *
 *The decoded string, shifted the right amount without ruining the capitalization and punctuation.
 */
public class CaesarCipherDecrypter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String messge = "Arire tbaan tvir lbh hc, arire tbaan yrg lbh qbja, arire tbaan eha nebhaq naq qrfreg lbh.";
		System.out.println(privateEyesOnly(messge));

	}

	static String privateEyesOnly(String message) {
		//' , . ! ? ( )
		String[] spls = {"'", ",", ".", "!", "?", "(", ")", " ","0","1","2","3","4","5","6","7","8","9" };
		Set<String> spl = new TreeSet<>();
		for (String s : spls) {
			spl.add(s);
		}
		int shift = shiftter(message);
		System.out.println("Shiftter: " + shift);
		StringBuffer sb = new StringBuffer();
		for(int i=0; i< message.length(); i++){
			char c = message.charAt(i);
			if(spl.contains(String.valueOf(c))){
				sb.append(c);
				continue;
			}
			sb.append(getChar(c , shift));
		}
		return sb.toString();
    }
	
	static int shiftter(String message){
		String[] ws = {"is", "was", "a", "in", "of", "to", "it", "do", "that", "for", 
				"not", "as", "but", "will", "up", "when", "can", "no", "like", 
				"than", "its", "any", "and", "you", "by", "we", "he", 
				"she", "we", "or", "so", "if", "me",  "him", "into", "good",
				"bad", "the", "up", "down", "order"}; 
		Set<String> cws = new TreeSet<>();
		for (String s : ws) {
			cws.add(s);
		}
		String[] ary = message.split(" ");
		for (String s : ary) {
			s = s.replace("'", "").replace(",", "").replace("", "").replace(".", "")
			 .replace("!", "").replace("?", "").replace("(", "").replace(")", "");
			if(s.length() < 6){
				for(int z = 0; z < 26; z++){
					StringBuffer sb = new StringBuffer();
					for(int i=0; i<s.length();i++){
						sb.append((char)(s.charAt(i) + z));
					}	
					if(cws.contains(sb.toString())) {
						return z;
					}
				}
				for(int z = -25; z < 0; z++){
					StringBuffer sb = new StringBuffer();
					for(int i=0; i<s.length();i++){
						sb.append((char)(s.charAt(i) + z));
					}	
					if(cws.contains(sb.toString())) {
						return z;
					}
				}
			}
		}
		return 0;
	}

	private static char getChar(char c, int s) {
		if(c > 96 && c < 123){ // a - z
			int i = c + s;
			if(i > 122){
				int d = i - 122;
				return (char)(96+d);
			}
			if(i < 97){
				int d = 97 - i;
				return (char)(123 - d);
			}
			return (char)i;
		}
		if(c > 64 && c < 91){ //A - Z
			int i = c + s;
			if(i > 90){
				int d = i - 90;
				return (char) (64 + d);
			}
			if(i < 65){
				int d = 65 - i;
				return (char) (91 - d);
			}
			return (char)i;
		}
		return 0;
	}

}

/**
 * Input:
 * message: "Czqm hs Ingm chc xnt enqfds sgd rghes mtladq? Hs'r 1!"
 * Output:
 * "Darn it John did you forget the shift number? It's 1!"
 * Expected Output:
 * "Darn it John did you forget the shift number? It's 1!"
 * 
 * 
 * Input:
 * message: "Arire tbaan tvir lbh hc, arire tbaan yrg lbh qbja, arire tbaan eha nebhaq naq qrfreg lbh."
 * Output:
 * "Never gonna give you up, never gonna let you down, never gonna run around and desert you."
 * Expected Output:
 * "Never gonna give you up, never gonna let you down, never gonna run around and desert you."
 * 
 * Input:
 * message: "Yg'tg pq uvtcpigtu vq nqxg, aqw mpqy vjg twngu cpf uq fq K."
 * Output:
 * "We're no strangers to love, you know the rules and so do I."
 * Expected Output:
 * "We're no strangers to love, you know the rules and so do I."
 * 
 * Input:
 * message: "Jveu lezk B9 kf kyv ivri fw kyv tzkp, givgriv wfi srtblg."
 * Output:
 * "Send unit K9 to the rear of the city, prepare for backup."
 * Expected Output:
 * "Send unit K9 to the rear of the city, prepare for backup."
**/
