package tiendm.codefight.challenge.august;

import java.util.HashMap;
import java.util.Map;

public class RockPaperScissor {

	int[] rockPaperScissor(String opponentsMoves) {
		int[] result = new int[3];
		int w = 0, l = 0, d = 0;
		Map<Character, Integer> frequently = new HashMap<>();
		Map<Character, Character> mapWin = new HashMap<>();
		Map<Character, Character> mapLose = new HashMap<>();
		mapWin.put('R', 'S');
		mapWin.put('P', 'R');
		mapWin.put('S', 'P');
		mapLose.put('R', 'P');
		mapLose.put('P', 'S');
		mapLose.put('S', 'R');
		frequently.put('R', 0);
		frequently.put('P', 0);
		frequently.put('S', 0);
		String you = "";
		char current = 'S';
		char opponent = opponentsMoves.charAt(0);
		int resultPrev = compare(current, opponent, mapWin, mapLose);
		if (resultPrev == 1) {
			w++;
		} else if (resultPrev == -1) {
			l++;
		} else {
			d++;
		}
		frequently.put(current, 1);
		you += "S";
		for (int i = 1; i < opponentsMoves.length(); i++) {
			char preOpponent = opponentsMoves.charAt(i-1);
			opponent = opponentsMoves.charAt(i);
			current = caculate(current, preOpponent, resultPrev, frequently, you);
			resultPrev = compare(current, opponent, mapWin, mapLose);
			if (resultPrev == 1) {
				w++;
			} else if (resultPrev == -1) {
				l++;
			} else {
				d++;
			}
			Integer frequentCurrent = frequently.get(current);
			frequently.put(current, frequentCurrent+1);
			you += current;
		}

		result[0] = w;
		result[1] = l;
		result[2] = d;
		return result;
	}

	private char caculate(char current, char opponent, int resultPrev, Map<Character, Integer> frequently, String you) {
		if (resultPrev == 1) {
			return opponent;
		} else if (resultPrev == -1) {
			if ((current == 'R' && opponent == 'P') || (current == 'P' && opponent == 'R')) {
				return 'S';
			} else if ((current == 'R' && opponent == 'S') || (current == 'S' && opponent == 'R')) {
				return 'P';
			} else {
				return 'R';
			}
		}
		int freR = frequently.get('R');
		int freP = frequently.get('P');
		int freS = frequently.get('S');
		if(freS == 1 && freP == 0 && freR == 0){
			return 'R';
		}
		if(freP == freS && freS == freR){
			return you.charAt(you.length()-1);
		}
		if(freP != freR && freR != freS && freP != freS){
			int min = Math.min(Math.min(freP, freR), freS);
			if(min == freP){
				return 'P';
			}else if (min == freR) {
				return 'R';
			}
			return 'S';
		}
		char check = 'R';
		if(freR == freS){
			if(freP < freR) return 'P';
			else{
				check = 'P';
			}
		}else if (freP == freR) {
			if(freS < freR) return 'S';
			else{
				check = 'S';
			}
		}else{
			if(freR < freP) return 'R';
			else{
				check = 'R';
			}
		}
		for(int i = you.length()-1; i >=0; i--){
			if(you.charAt(i) == check){
				continue;
			}else {
				return you.charAt(i);
			}
		}
		return check;
	}

	int compare(char current, char opponent, Map<Character, Character> mapWin, Map<Character, Character> mapLose) {
		if (mapWin.get(current).equals(opponent))
			return 1;
		if (mapLose.get(current).equals(opponent))
			return -1;
		return 0;
	}

	public static void main(String[] args) {
		RockPaperScissor r = new RockPaperScissor();
		System.out.println(r.rockPaperScissor("RPSPRRRPRR"));
	}
}
