package tiendm.codefight.tournament.oct;

public class Tour1007 {
	boolean charactersRearrangement(String string1, String string2) {
		int occ1[] = new int[26], occ2[] = new int[26];
		for (int i = 0; i < string1.length(); i++) {
			occ1[string1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < string2.length(); i++) {
			occ2[string2.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (occ1[i] != occ2[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Tour1007 t = new Tour1007();
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t);
	}
}
