package tiendm.codefight.challenge.sep;

import java.util.ArrayList;
import java.util.List;

public class MultiplyToSingleDigit {
	List<Integer> multiplyToSingleDigit(int addend, int limit) {
		List<Integer> lsResult = new ArrayList<>();
		List<Integer> lsFalse = new ArrayList<>();
		if(addend == 0 || limit < 10) return new ArrayList<>();
		for(int i = 10; i <= limit; i++){
			if(isDangerous(i,addend,limit, lsResult, lsFalse)) {
				lsResult.add(i);
			}else{
				lsFalse.add(i);
			}
		}
		return lsResult;
	}


	private boolean isDangerous(int number,int added, int limit, List<Integer> lsResult, List<Integer> lsFalse) {
		String s = "";
		if(check(lsResult, number)) return true;
		if(check(lsFalse, number)) return false;
		while(true){
			s = number + "";
			int product = 1;
			for(int i = 0; i < s.length(); i++){
				product *= ((s.charAt(i) - '0') + added);
			}
			if(product < 10 || lsFalse.contains(product)) return false;
			if(product == number || product > limit || lsResult.contains(product)) return true;
			number = product;
		}
	}

	private boolean check(List<Integer> ls, int number) {
		String s = number + "";
		int len1 = s.length();
		int[] occ1 = new int[10];
		for(int i = 0; i < s.length(); i++){
			occ1[s.charAt(i) - '0']++;
		}
		for(int i = 0; i < ls.size(); i++){
			String s2 = ls.get(i).toString();
			if(s2.length() != len1) continue;
			int[] occ2 = new int[10];
			for(int j = 0; j < s2.length(); j++){
				occ2[s2.charAt(j) - '0']++;
			}
			int sum = 0;
			for(int j = 0; j < 10; j++){
				if(occ1[j] == occ2[j]){
					sum++;
				}
			}
			if(sum == 10) return true;
		}
		return false;
	}


	public static void main(String[] args) {
		MultiplyToSingleDigit p = new MultiplyToSingleDigit();
		System.out.println(p.multiplyToSingleDigit(2, 21));
	}
}
