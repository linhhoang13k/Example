package tiendm.codefight.challenge.may;

public class TotalBinSum {
	int totalBinSum(String num) {
		int sum = 0, d = (int) (Math.pow(10, 9) + 7), max = 0,  l = num.length() , pre = 0;
		for(int i = 0; i < l; i++){
			int x = num.charAt(i) - '0';
			max = (pre * 2) % d + x;
			pre = max % d;
			sum = (sum + pre) % d;
			
		}
		return sum;
	}
	
	public static void main(String[] args) {
		TotalBinSum test = new TotalBinSum();
//		System.out.println(test.totalBinSum("111010011010111011101101011010010")); //682221351
//		System.out.println(test.totalBinSum("1001101011101110111110110011010111100011010111011101101011010010")); //30998030
		System.out.println(test.totalBinSum("1111101011101110111110111000110101111000110101110111011010110100")); //807610166
	}
}
