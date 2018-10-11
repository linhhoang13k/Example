package tiendm.codefight.tournament.sep;

import java.util.ArrayList;
import java.util.List;

public class Tour1409 {
	String[] addBorder(String[] picture) {

		List<String> answer = new ArrayList<>();
		answer.add("");

		for (int i = 0; i < picture[0].length() + 2; i++) {
			answer.set(0, answer.get(0) + "*");
		}

		for (int i = 0; i < picture.length; i++) {
			answer.add("*");
			for (int j = 0; j < picture[0].length(); j++) {
				answer.set(i + 1, answer.get(i + 1) + picture[i].charAt(j));
			}
			answer.set(i + 1, answer.get(i + 1) + "*");
		}

		answer.add(answer.get(0));

		return answer.toArray(new String[picture.length + 2]);
	}

	public static void main(String[] args) {
		Tour1409 t = new Tour1409();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t);
	}
}
