package tiendm.codefight.challenge;

public class ReverseOddCount {
	String reverseOddCount(String str) {
		int[] occ = new int[256];
		for(int i = 0; i < str.length(); i++){
			occ[(int)str.charAt(i)]++;
		}
		int i = 0, j = str.length()-1;
		while (i < j) {
			int ci = (int)str.charAt(i);
			int cj = (int)str.charAt(j);
			if(occ[ci] % 2 == 0){
				i++;
			}
			if(occ[cj] % 2 == 0){
				j--;
			}
			if(occ[ci] % 2 == 1 && occ[cj] % 2 == 1){
				str = swap(str, i, j);
				i++;
				j--;
			}
		}
		return str;
	}
	String swap(String str, int i, int j){
		return str.substring(0,i) + str.charAt(j) + str.substring(i+1, j)
		+ str.charAt(i) + (j == str.length()-1 ? "" : str.substring(j+1, str.length()));
	}
	public static void main(String[] args) {
		ReverseOddCount r = new ReverseOddCount();
		String s = "hello world";
		System.out.println(r.reverseOddCount(s));
	}
}
