package tiendm.codefight.challenge.april;

public class CoolSubsets {
	
//	long coolSubsets(int[] a) {
//		int max = 0, c = 0;
//		for(int i : a){
//			if(i > max){
//				max = i;
//				c = 1;
//			}else if (i == max) {
//				c++;
//			}
//		}
//		if(checkZero(a)) return (long) (Math.pow(2, a.length)-1);
//		return c;
//	}
//	boolean checkZero(int[] a) {
//		for(int i : a){
//			if(i != 0) return false;
//		}
//		return true;
//	}
	long coolSubsets(int[] a) {
		int m = 0, c = 0, t = 0;
		for(int i : a){
			if(i > m){
				m = i;
				c = 1;
			}else if (i == m) {
				c++;
			}
			if(i == 0) t++;
		}
		if(t == a.length) return (long) (Math.pow(2, a.length)-1);
		return c;
	}
	public static void main(String[] args) {
		CoolSubsets cool = new CoolSubsets();
	}
}
