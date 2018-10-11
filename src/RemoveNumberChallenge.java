package tiendm.codefight.challenge.july;

import java.util.ArrayList;
import java.util.List;

public class RemoveNumberChallenge {
	int removeNumberChallenge(String n, int d) {
		if (d == 0)
			return 0;
		if (d == 1){
			if(n.length() > 1 && Integer.parseInt(n) != 0){
				return 1;
			}
			else {
				return 0;
			}
		}
		List<String> canNext = new ArrayList<>();
		for (int i = 0; i < n.length(); i++) {
			String check = "";
			if (i < n.length() - 1) {
				check = n.substring(0, i) + n.substring(i + 1);
			} else {
				check = n.substring(0, i);
			}
			int checkNum = Integer.parseInt(check);
			if (checkNum % d == 0) {
				canNext.add(checkNum + "");
			}
		}
		int max = 0;
		for(String s: canNext){
			int next = 1 + removeNumberChallenge(s, d-1);
			if( next > max){
				max = next;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		RemoveNumberChallenge r = new RemoveNumberChallenge();
		System.out.println(r.removeNumberChallenge("102045", 4));
	}
}
