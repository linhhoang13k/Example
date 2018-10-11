package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.List;

public class InterGration {
	int houseNumbersSum(int[] inputArray) {
		int sum = 0;
		for(int i = 0; i < inputArray.length; i++){
			if(inputArray[i] == 0) {
				break;
			}else {
				sum += inputArray[i];
			}
		}
		return sum;
	}
	
	String[] allLongestStrings(String[] inputArray) {
		List<String> lsLongest = new ArrayList<>();
		int max = 0;
		for(String s : inputArray){
			if(s.length() > max){
				max = s.length();
				lsLongest.clear();
				lsLongest.add(s);
			} else if (max == s.length()) {
				lsLongest.add(s);
			}
		}
		return lsLongest.toArray(new String[lsLongest.size()]);
	}
	
	List<Integer> houseOfCats(int legs) {
		List<Integer> lsPeople = new ArrayList<>();
		for(int i = 0; i <= legs/2; i++){
			if((legs - 2*i) % 4 == 0) lsPeople.add(i);
		}
		return lsPeople;
	}
	
	boolean alphabetSubsequence(String s) {
		for(int i = 0; i < s.length()-1; i++){
			if(s.charAt(i) >= s.charAt(i+1)) return false;
		}
		return true;
	}
	
	int minimalNumberOfCoins(int[] coins, int price) {
		int c = 0, index = coins.length - 1;
		while (price > 0) {
			if(price / coins[index] > 0){
				c += price / coins[index];
				price = price % coins[index];
			} 
			index--;
		}
		return c;
	}
	
	String[] addBorder(String[] picture) {
		int length = picture[0].length();
		String[] x = new String[picture.length+2];
		x[0] = new String(new char[length+2]).replaceAll("\0", "*");
		x[picture.length+1] = x[0];
		for(int i = 0; i < picture.length; i++){ 
			x[i+1] = "*" + picture[i] + "*";
		}
		return x;
	}
	
	int[] switchLights(int[] a) {
		for(int i = 0; i < a.length; i++){
			if(a[i] == 0) continue;
			for(int j = 0; j <= i; j++){
				a[j] = 1 - a[j];
			}
		}
		return a;
	}
	
	int timedReading(int maxLength, String text) {
		String[] aText = text.split(" ");
		int count = 0;
		for(String t : aText){
			int length = t.length();
			for(int i = 0; i < t.length(); i ++){
				char c = t.charAt(i);
				if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) length--; 
			}
			if(length >0 && length <= maxLength) count++;
		}
		return count;
	}
	
	String integerToStringOfFixedWidth(int number, int width) {
		String s = number+"";
		int length = s.length();
		if(length >= width) return s.substring(length-width);
		return String.format("%5s", s).replaceAll(" ", "0");
	}
	
	boolean areSimilar(int[] A, int[] B) {
		int count = 0, idx1 = 0;
		for(int i = 0 ; i < A.length; i++){
			int x = A[i] - B[i];
			if(x != 0){
				if(count > 1) return false;
				else if (count == 0) {
					idx1 = i;
					count++;
				} else {
					if(A[idx1] != B[i] || A[i] != B[idx1]) return false;
					count++; 
				}
			}
		}
		return true;
	}
	
	int threeSplit(int[] a) {
		int sum = 0,n = a.length, count = 0,sum1 = 0, sum2 = 0;
		for(int i : a){
			sum += i;
		}
		if(sum % 3 != 0) return 0;
		int s = sum / 3;
		for(int i1 = 0; i1 < n-2; i1++){
			sum2 = 0;
			sum1 += a[i1];
			if(sum1 != s) continue;
			for(int i2 = i1+1; i2 < n-1; i2++){
				sum2+=a[i2];
				if(sum2 != s) continue;
				count++;
			}
		}
		return count;
	}

	
	public static void main(String[] args) {
		InterGration test = new InterGration();
		int [] x = {-1, 0, -1, 0, -1, 0};
		System.out.println(test.threeSplit(x));
	}
}
