package codefighters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WellOfIntegration {
	static int houseNumbersSum(int[] inputArray) {
		int sum = 0;
		for(int i = 0; i < inputArray.length && inputArray[i] != 0; i++){
			sum += inputArray[i];
		}
		return sum;
	}

	static String[] allLongestStrings(String[] inputArray) {

		List<String> result = new ArrayList<String>();
		int longest = 0;
		for(String current : inputArray){
			if(current.length() == longest){
				result.add(current);
			}else if (current.length() > longest){
				longest = current.length();
				result = new ArrayList<String>();
				result.add(current);
			}
		}
		return result.toArray(new String[0]);
	}

	static int[] houseOfCats(int legs) {
		List<Integer> people = new ArrayList<>();

		for(int i = 0; i*2 <= legs; i++){
			int temp = legs;
			temp -= i*2;
			if(temp%4==0){
				people.add(i);
			}
		}

		return people.stream().mapToInt(i->i).toArray();
	}

	static boolean alphabetSubsequence(String s) {
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i-1) >= s.charAt(i)){
				return false;
			}
		}
		return true;
	}

	static int minimalNumberOfCoins(int[] coins, int price) {
		int count = 0;
		for(int i = coins.length-1; price > 0;){
			if(price-coins[i] >= 0){
				price -= coins[i];
				count++;
			}else{
				i--;
			}
		}
		return count;
	}

	static String[] addBorder(String[] picture) {
		String[] pic = new String[picture.length+2];
		for(int i = 0; i < picture.length; i++){
			pic[i+1] = "*" + picture[i] + "*";
		}
		for(int i = 0; i < pic[1].length(); i++){
			pic[0] = pic[0]==null?"*":pic[0]+"*";
			pic[pic.length-1] = pic[pic.length-1]==null?"*":pic[pic.length-1]+"*";
		}
		return pic;
	}

	static int[] switchLights(int[] a) {
		for(int i = 0; i < a.length; i++){
			if(a[i] == 1){
				for(int j = i; j >= 0; j--){
					a[j]=a[j]==1?0:1;
				}
			}
		}
		return a;
	}

	static int timedReading(int maxLength, String text) {
		int count = 0;
		for(String current : text.split("\\W+")){
			if(current.length() <= maxLength){
				count++;
			}
		}
		return count;
	}

	static int electionsWinners(int[] votes, int k) {
		int maxVotes = 0, possition = 0, possible = 0;
		for(int i = 0; i < votes.length; i++){
			if(votes[i] > maxVotes){
				maxVotes = votes[i];
				possition = i;
			}
		}
		if(k > 0)
			for(int i : votes){
				if(i + k > maxVotes){
					possible++;
				}
			}

		if(possible == 0){
			boolean more = false;
			for(int i = 0; i < votes.length; i++){
				if(votes[i] == maxVotes && i != possition){
					more = true;
				}
			}
			if(!more){
				possible++;
			}
		}
		return possible;
	}

	static String integerToStringOfFixedWidth(int number, int width) {
		int seed = (int)Math.pow(10, width);
		String tmp = "";
		number = number%seed;
		if((number+"").length()< width){
			int diff = width - (number+"").length();
			for(int i = 0; i < diff; i++){
				tmp += "0";
			}
		}
		return tmp + number;

	}

	static boolean areSimilar(int[] A, int[] B) {
		int a = -1, b = -1;
		for(int i = 0; i < A.length; i++){
			if(A[i] != B[i]){
				if(a < 0 && b < 0){
					a = i;
					for(int j = i; j < A.length; j++){
						if(b < 0 && A[i] == B[j] && A[j] != B[j]){
							b = j;
						}
					}
				}else{
					if(i == b){
						if(A[b] != B[a]){
							return false;
						}
					}else{
						return false;
					}

				}
			}
		}
		return true;
	}

	static boolean adaNumber(String line) {
		line = line.replaceAll("_", "");
		if(line.indexOf("#") > -1){
			String base = line.substring(0, line.indexOf("#"));
			String digits = "";
			switch(base){
			case "1":return false;

			case "2":digits = "0-1";
			break;
			case "3":digits = "0-2";
			break;
			case "4":digits = "0-3";
			break;
			case "5":digits = "0-4";
			break;
			case "6":digits = "0-5";
			break;
			case "7":digits = "0-6";
			break;
			case "8":digits = "0-7";
			break;
			case "9":digits = "0-8";
			break;
			case "10":digits = "0-9";
			break;
			case "11":digits = "0-9aA";
			break;
			case "12":digits = "0-9a-bA-B";
			break;
			case "13":digits = "0-9a-cA-C";
			break;
			case "14":digits = "0-9a-dA-D";
			break;
			case "15":digits = "0-9a-eA-E";
			break;
			case "16":digits = "0-9a-fA-F";
			break;
			default: digits = "0-9";
			}
			return line.matches("^[0-9]{1,2}#[" + digits + "]{1,}#$");
		}else{
			return line.matches("^[0-9]{1,}$");
		}
	}

	static int threeSplit(int[] a) {
		int[] sum = new int [3];
		int count = 0;
		int j = 0, k = 0;
		for(int i = 0; i < a.length-2; i++){
			sum[0] += a[i];
			sum[1] = 0;
			for(j = i+1; j < a.length-1; j++){
				sum[1] += a[j];
				sum[2]=0;
				if(sum[0] == sum[1]){
					for(k = j+1; k < a.length; k++){
						sum[2] += a[k];
					}
					if(sum[0] == sum[1] && sum[0] == sum[2]){
						count++;
					}
				}
			}
		}
		return count;
	}


}
