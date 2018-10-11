package tiendm.codefight.tournament.sep;

public class Tour1009 {
	String angleType(int measure) {
		if (measure < 90)
			return "acute";
		else if (measure == 90)
			return "right";
		else if (measure < 180)
			return "obtuse";
		else
			return "straight";

	}

	public static void main(String[] args) {
		Tour1009 t = new Tour1009();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 7, 5, 4, 4, 8 };
		System.out.println(t);
	}
}
