package tiendm.codefight.challenge.august;

import java.util.HashMap;
import java.util.Map;

public class Guno {
	int[] guno(int playercount, String[] moves) {
		int[] result = new int[playercount];
		Map<String, Integer> coints = new HashMap<>();
		coints.put("c", 0);
		coints.put("s1", 20);
		coints.put("s2", 20);
		coints.put("s3", 20);
		coints.put("s4", 50);
		coints.put("s5", 50);
		int c = 0;
		int direction = 1;
		for(String s : moves){
			result[c % playercount] += coints.get(s);
			if(s.equals("s3")){
				direction *= -1;
			}
			if(direction < 0){
				c += playercount;
			}
			if(s.equals("s1")){
				c += direction * 2;
			}else{
				c += direction * 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] moves = {"c", 
				 "s5", 
				 "c", 
				 "s4", 
				 "s1", 
				 "c", 
				 "s3", 
				 "s2"};
		Guno g = new Guno();
		System.out.println(g.guno(4, moves));
	}
}
