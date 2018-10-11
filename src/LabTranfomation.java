package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabTranfomation {
	
	String characterParity(char symbol) {
		int x = symbol - '0';
		if(x < 0 || x > 9) return "not a digit";
		else if (x % 2 == 0) {
			return "even";
		} else {
			return "odd";
		}
	}
	
	String reflectString(String inputString) {
		char[] chars = inputString.toCharArray();
		for(int i = 0; i < chars.length; i++){
		}
		return new String(chars);
	}
	
	String[] newNumeralSystem(char number) {
		int n = number - 'A';
		List<String> lsResult = new ArrayList<>();
		for(int i = 0; i <= n/2; i++){
			char[] c = {(char)(i+65),'+',(char)(65+n-i)};
			lsResult.add(new String(c));
		}
		return lsResult.toArray(new String[lsResult.size()]);
	}
	
	String cipher26(String message) {
		char[] c = message.toCharArray();
		char[] cNew = new char[c.length];
		int sum = 0, T = c.length * 26;
		for(int i = 0; i < c.length ; i++){
			int m = c[i]-'a';
			int x = (T + m - sum) % 26;
			cNew[i] = (char) (x + (int)'a');
			sum += x;
		}
		return new String(cNew);
	}
	
	String stolenLunch(String note) {
	    char[] c = note.toCharArray();
	    for(int i = 0; i < c.length; i++){
	    	if(c[i] >= '0' && c[i] <= '9'){
	    		c[i] = (char) ((c[i] - '0') + (int)'a');
	    	} else if (c[i] >= 'a' && c[i] <= 'j') {
	    		c[i] = (char) ((c[i] - 'a') + (int)'0');
			}
	    }
	    return new String(c);
	}
	
	boolean higherVersion(String ver1, String ver2) {
		String[] s1 = ver1.split("\\.");
		String[] s2 = ver2.split("\\.");
		for(int i = 0; i < s1.length; i++){
			if(higher(s1[i], s2[i]) > 0) return true;
			else if (higher(s1[i], s2[i]) < 0) return false;
		}
		return false;
	}
	
	int higher(String s1, String s2){
		if(s1.length() == s2.length()){
			return s1.compareTo(s2);
		}else {
			return s1.length() > s2.length() ? 1 : -1;
		}
	}
	
	String decipher(String cipher) {
		String check = "97-98-99";
		StringBuilder builder = new StringBuilder();
		int count = 0, l = cipher.length();
		while (count < l - 1) {
			String s = cipher.substring(count, count+2);
			if(check.contains(s)){
				builder.append((char)Integer.parseInt(s));
				count += 2;
			} else {
				builder.append((char)Integer.parseInt(cipher.substring(count, count+3)));
				count+=3;
			}
		}
		return builder.toString();
	}
	
	@SuppressWarnings("unused")
	boolean alphanumericLess(String s1, String s2) {
		List<String> ls1 = splitString(s1);
		List<String> ls2 = splitString(s2);
		for(int i = 0; i < ls2.size() ; i++){
			try {
				String str1 = ls1.get(i);
				String str2 = ls2.get(i);
				if(str1.equals(str2)) continue;
				if(getDigit(str1) > -1){
					if(getDigit(str2) == -1) return true;
					else {
						if(getDigit(str1) != getDigit(str2)) return getDigit(str1) < getDigit(str2);
					}
				}else {
					if(getDigit(str2) > -1) return false;
					else {
						return str1.compareTo(str2) < 0;
					}
				}
			} catch (Exception e) {
				return true;
			}
		}
		for(int i = 0; i < ls2.size() ; i++){
			String str1 = ls1.get(i);
			String str2 = ls2.get(i);
			if(getDigit(str1) > -1 && getDigit(str2) > -1){
				int x = compareDigit(str1, str2);
				if( x != 0){
					return x < 0;
				}
			}
		}
		return false;
	}
	
	List<String> splitString(String s) {
		int l = s.length();
		List<String> ls = new ArrayList<>();
		int mark = 0;
		for(int i = 0; i < l-1; i++){
			char c = s.charAt(i);
			if(!isDigit(c)) {
				ls.add(s.substring(i,i+1));
				if(i == l-2 && isDigit(s.charAt(i+1))){
					mark = i+1;
				}
			}else {
				if((i > 0 && !isDigit(s.charAt(i-1)))){
					mark = i;
				}
				if(!isDigit(s.charAt(i+1))){
					ls.add(s.substring(mark,i+1));
				}
			}
		}
		if(!isDigit(s.charAt(l-1))) ls.add(s.substring(l-1));
		else {
			ls.add(s.substring(mark,l));
		}
		return ls;
	}
	
	boolean isDigit(char c){
		return c >= '0' && c <='9';
	}
	
	int getDigit(String s){
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return -1;
		}
	}
	
	int compareDigit(String d1, String d2){
			Integer i1 = Integer.parseInt(d1);
			Integer i2 = Integer.parseInt(d2);
			if(i1.equals(i2)){
				if(d1.length() == d2.length()) return 0;
				return d1.length() < d2.length() ? 1 : -1;
			}else {
				return i1 < i2 ? -1 : 1;
			}
	}

	public static void main(String[] args) {
		LabTranfomation lab = new LabTranfomation();
		System.out.println(lab.alphanumericLess("ab000144","ab144"));
	}
}
