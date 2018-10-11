package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpringIntegration {
	///////////////////////////////////////////////
	int arrayConversion(int[] inputArray) {
		List<Integer> lsTrack = new ArrayList<>();
		for (int i : inputArray) {
			lsTrack.add(i);
		}
		boolean plus = true;
		while (lsTrack.size() > 1) {
			List<Integer> lsTmp = new ArrayList<>();
			if (plus) {
				for (int i = 0; i < lsTrack.size(); i += 2) {
					lsTmp.add(lsTrack.get(i) + lsTrack.get(i + 1));
				}
			} else {
				for (int i = 0; i < lsTrack.size(); i += 2) {
					lsTmp.add(lsTrack.get(i) * lsTrack.get(i + 1));
				}
			}
			lsTrack = lsTmp;
			plus = !plus;
		}
		return lsTrack.get(0);
	}

	///////////////////////////////////////////////
	int[] arrayPreviousLess(int[] items) {
		int[] result = new int[items.length];
		result[0] = -1;
		int c = 0;
		for (int i = 1; i < items.length; i++) {
			c = i - 1;
			while (c >= 0) {
				if (items[c] < items[i]) {
					result[i] = items[c];
					break;
				}
				c--;
			}
			if (c <= 0)
				result[i] = -1;
		}
		return result;
	}

	///////////////////////////////////////////////
	boolean pairOfShoes(int[][] shoes) {
		List<Integer> lsLeft = new ArrayList<>();
		List<Integer> lsRight = new ArrayList<>();
		for (int i = 0; i < shoes.length; i++) {
			if (shoes[i][0] == 0)
				lsLeft.add(shoes[i][1]);
			else
				lsRight.add(shoes[i][1]);
		}
		if (lsLeft.size() != lsRight.size())
			return false;
		Collections.sort(lsLeft);
		Collections.sort(lsRight);
		for (int i = 0; i < lsLeft.size(); i++) {
			if (lsLeft.get(i) != lsRight.get(i))
				return false;
		}
		return true;
	}

	///////////////////////////////////////////////
	int combs(String comb1, String comb2) {
		int check1 = combTmp(comb1, comb2);
		String c1 = new StringBuilder(comb1).reverse().toString();
		String c2 = new StringBuilder(comb2).reverse().toString();
		return Math.min(check1, combTmp(c1, c2));
	}

	int combTmp(String comb1, String comb2) {
		int i = 0;
		for (i = 0; i < comb1.length(); i++) {
			if (checkValid(comb1, comb2, i))
				break;
		}
		return comb1.length() + comb2.length() - Math.min(comb2.length(), comb1.length() - i);
	}

	boolean checkValid(String comb1, String comb2, int n) {
		int min = Math.min(comb2.length(), comb1.length() - n);
		for (int i = 0; i < min; i++) {
			if (comb2.charAt(i) == '*' && comb1.charAt(i + n) == '*')
				return false;
			;
		}
		return true;
	}

	///////////////////////////////////////////////////
	int stringsCrossover(String[] inputArray, String result) {
		int c = 0;
		for (int i = 0; i < inputArray.length - 1; i++) {
			for (int j = i + 1; j < inputArray.length; j++) {
				if (chekPairCross(inputArray[i], inputArray[j], result))
					c++;
			}
		}
		return c;
	}

	boolean chekPairCross(String string1, String string2, String result) {
		for (int i = 0; i < result.length(); i++) {
			if (string1.charAt(i) != result.charAt(i) && string2.charAt(i) != result.charAt(i))
				return false;
		}
		return true;
	}

	//////////////////////////////////////////////////
	int cyclicString(String s) {
		if (s.isEmpty())
			return 0;
		for (int i = 1; i < s.length(); i++) {
			if (checkcyclic(s, i))
				return i;
		}
		return 0;
	}

	boolean checkcyclic(String str, int n) {
		String s = new String(str);
		String check = s.substring(0, n);
		s = s.substring(n);
		while (s.length() >= n) {
			String strCheck = s.substring(0, n);
			if (!strCheck.equals(check))
				return false;
			s = s.substring(n);
		}
		return check.contains(s);
	}

	//////////////////////////////////////////////////
	boolean beautifulText(String inputString, int l, int r) {
		int len = inputString.length();
		for (int i = l; i <= r; i++) {
			// check number letter in a row is valid
			if ((len + 1 - len / i) % i != 0)
				continue;
			int c = 0;
			// (len+1)/(i+1): fomula to calculate row
			for (int j = 0; j < (len + 1) / (i + 1) - 1; j++) {
				if (inputString.charAt((j + 1) * i + j) == ' ')
					c++;
				else
					break;
			}
			if (c == len / i - 1)
				return true;
		}
		return false;
	}

	///////////////////////////////////////////////////////
	int runnersMeetings(int[] startPosition, int[] speed) {
		int len = speed.length;
		double[] speedS = new double[speed.length];
		int[][] graph = new int[len][len];
		for (int i = 0; i < len; i++) {
			speedS[i] = (double)speed[i] / 60;
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(speedS[i] == speedS[j]) continue;
				graph[i][j] = (int) Math.round((startPosition[j] - startPosition[i]) / (speedS[i] - speedS[j]));
			}
		}
		int max = Integer.MIN_VALUE, count = 0;
		for(int i = 0; i < len;i++){
			for(int j = 0; j < len; j++){
				if(graph[i][j] > 0 && graph[i][j] > max){
					max = graph[i][j];
					count = 1;
				}else if (graph[i][j] == max) {
					count++;
				}
			}
		}
		if(max > 0) {
			for(int i = 2; i <= count; i++){
				if(i * (i-1) == count) return i;
			}
		}
		return -1;
	}
	
	//////////////////////////////////////////
	String[] christmasTree(int levelNum, int levelHeight) {
		String[] tree = new String[3+levelNum*levelHeight+levelNum];
		int count = 3;
		tree[0] = String.format("%"+(levelHeight + levelNum + 1)+"s", "*");
		tree[1] = tree[0];
		tree[2] = String.format("%"+(levelHeight + levelNum + 2)+"s", "***");
		for(int i = 1; i <= levelNum; i++){
			for(int j= 1; j <= levelHeight; j++){
				String asterisk = String.format("%"+(3 + (2 * (i+j-1)))+"s", " ").replace(" ", "*");
				tree[count++] = String.format("%"+(1+levelHeight+levelNum+i+j)+"s", asterisk);
			}
		}
		for(int i = 0; i < levelNum; i++){
			String asterisk = String.format("%"+(levelHeight%2==1?levelHeight:levelHeight+1)+"s", " ").replace(" ", "*"); 
			tree[count++] = String.format("%"+(1 + 3 * levelHeight/2 + levelNum)+"s", asterisk);
		}
		return tree;
	}


	public static void main(String[] args) {
		SpringIntegration test = new SpringIntegration();
		String[] s = test.christmasTree(1,3);
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]);
		}
	}
}
