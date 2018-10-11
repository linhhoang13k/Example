package tiendm.codefight.challenge.april;

public class CrazyClover {
	boolean crazyClover(String l) {
		int x = l.length();
		return Integer.parseInt((x < 2) ? l: l.substring(x-2)) % 4 == 0;
	}
	public static void main(String[] args) {
		CrazyClover test = new CrazyClover();
		System.out.println(test.crazyClover("32565527543186766526240463003010854254680"));
	}
}
