package codefighters;

import java.text.ParseException;

public class LabOfTransformations {
	static String characterParity(char symbol) {
		int tmp = Character.getNumericValue(symbol);
		if(tmp < 0 || tmp > 9 ){
			return "not a digit";
		}
		return tmp%2==0?"even":"odd";
	}

	static String reflectString(String inputString) {
		String temp = "";
		for(int i = 0; i < inputString.length(); i++){
			int tmp = inputString.charAt(i);
			temp += (char)(122 - tmp + 97);
		}
		return temp;
	}

	static String[] newNumeralSystem(char number) {
		int num = (int)number;
		String[] result = new String[((num-65)/2)+1];
		for(int i = 65; i <= (num-i+65) ; i++){
			result[i-65] = (char)i + " + " + (char)(num-i+65);
		}
		return result;
	}

	static String cipher26(String message) {
		int tmp = 0, chr = 0, chr1 = 0;
		chr1 = Character.getNumericValue(message.charAt(0))-10;
		String clear = Character.forDigit(chr1+10, Character.MAX_RADIX) + "";
		for(int i = 1; i < message.length(); i++){
			chr = Character.getNumericValue(message.charAt(i))-10;
			tmp=chr-chr1<0?chr-chr1+26:chr-chr1;
			clear += Character.forDigit(tmp+10, Character.MAX_RADIX);
			chr1 = chr;
		}
		return clear;
	}

	static String stolenLunch(String note) {
		StringBuilder sb = new StringBuilder(note);
		for(int i = 0; i < note.length(); i++){
			char a = note.charAt(i);
			switch(a){
			case '0':a = 'a';
			break;
			case '1':a = 'b';
			break;
			case '2':a = 'c';
			break;
			case '3':a = 'd';
			break;
			case '4':a = 'e';
			break;
			case '5':a = 'f';
			break;
			case '6':a = 'g';
			break;
			case '7':a = 'h';
			break;
			case '8':a = 'i';
			break;
			case '9':a = 'j';
			break;
			case 'a':a = '0';
			break;
			case 'b':a = '1';
			break;
			case 'c':a = '2';
			break;
			case 'd':a = '3';
			break;
			case 'e':a = '4';
			break;
			case 'f':a = '5';
			break;
			case 'g':a = '6';
			break;
			case 'h':a = '7';
			break;
			case 'i':a = '8';
			break;
			case 'j':a = '9';
			break;
			}
			sb.setCharAt(i, a);
		}
		return sb.toString();
	}

	static boolean higherVersion(String ver1, String ver2) {

		if(ver1.equals(ver2)){
			return false;
		}

		String[] verA = ver1.split("\\.");
		String[] verB = ver2.split("\\.");

		for(int i = 0; i < verA.length; i++){
			if(Integer.parseInt(verB[i]) > Integer.parseInt(verA[i])){
				return false;
			}else if(Integer.parseInt(verA[i]) > Integer.parseInt(verB[i])){
				return true;
			}
		}
		return true;
	}

	static String decipher(String cipher) {
		String result = "";
		for(int i = 0; i < cipher.length(); i++){
			String tmp = cipher.substring(i, i+2);
			if(tmp.compareTo("97") < 0){
				tmp += cipher.substring(i+2, i+3);
				i += 2;
			}else{
				i += 1;
			}
			result += (char)Integer.parseInt(tmp);
		}
		return result;
	}

	static boolean alphanumericLess(String s1, String s2) {
		String[] ver1 = s1.split("(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)|(?<=\\D)");
		String[] ver2 = s2.split("(?<=\\d)(?=\\D)|(?=\\d)(?<=\\D)|(?<=\\D)");

		boolean equalsLess = false;
		
		for(int i = 0; i < ver1.length && i < ver2.length; i++){
			if(isDigit(ver1[i]) && isDigit(ver2[i])){
				if(Integer.parseInt(ver1[i]) > Integer.parseInt(ver2[i])){
					return false;
				}else if(Integer.parseInt(ver1[i]) < Integer.parseInt(ver2[i])){
					return true;
				}else if(Integer.parseInt(ver1[i]) == Integer.parseInt(ver2[i])){
					if(ver1[i].length() > ver2[i].length()){
						equalsLess = true;
					}else if(ver1[i].length() < ver2[i].length()){
						equalsLess = false;
					} 
				}
			}else if(isDigit(ver1[i]) || isDigit(ver2[i])){
				if(isDigit(ver2[i])){
					return false;
				}
			}else{
				if(ver1[i].compareTo(ver2[i]) > 0 ){
					return false;
				}else if(ver1[i].compareTo(ver2[i]) < 0 ){
					return true;
				}
				if(ver1[i].length() > ver2[i].length()){
					return false;
				}
			}
		}
		if(ver1.length < ver2.length){
			return true;
		}else if(equalsLess){
			return true;
		}
		return false;
	}

	static boolean isDigit(String a){
		try{
			Integer.parseInt(a);
		}catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}

}
