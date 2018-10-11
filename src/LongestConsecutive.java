package tiendm.codefight.challenge.april;

public class LongestConsecutive {
	int longestConsecutive(int[] arr) {
		int max = 0, maxIndex = 0;
		for(int i = 0; i < arr.length; i++){
			int x = getConsecute(arr[i]);
			if(x > max){
				max = x;
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	int getConsecute(int num) {
		String strNum = Integer.toBinaryString(num);
		for(int i = strNum.length(); i >=1; i--){
			String strCheck = String.format("%"+i+"s", " ").replace(" ", "1");
			if(strNum.contains(strCheck)) return i;
		}
		return 1;
	}
	public static void main(String[] args) {
		LongestConsecutive test = new LongestConsecutive();
		System.out.println(test.getConsecute(1000000000-1));
	}
}
