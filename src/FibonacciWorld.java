import java.util.HashMap;

/**
 * Created by mkale on 7/8/17.
 */
public class FibonacciWorld {

	public static void main(String[] args) {
		Long time = System.currentTimeMillis();
		System.out.println("stime = " + time);
		System.out.println(fibIteration(1));
//		System.out.println(fibonacciWord2(40, "00"));
//		Long time2  = System.currentTimeMillis();
//		//System.out.println("etime = "+time2);
//		System.out.println(time2-time);
	}



	static int fibonacciWord2(int n, String p) {
		String x = "0", y = "1", z = "10";
		int count =0;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = y+x;

			if(x.contains(p)){
				count++;
			}
		}
		return count;

	}

	static String fibIteration(int n) {
		String x = "0", y = "1", z = "10";
		//int count =0;
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = y+x;
		}
		return x;
	}
	
	public static String getFibString1(int num) {
		String i0 = "0";
		String j1 = "1";
		
		String finalS = "";
		HashMap<Integer, String> store = new HashMap<>();
		
		
		for(int i = 0; i<=num; i++){
			if(i==0){
				finalS = i0;
			} else if(i==1){
				finalS = j1;
			} else {
				finalS = store.get(i-1)+store.get(i-2);
			}

			if(store.get(i)==null){
				store.put(i, finalS);
			}
		}
		System.out.println("ftime = "+System.currentTimeMillis());
		return  finalS;
	}

	public static int fibonacciWord1(int n, String p) {
		String str = fibIteration(n);

		int lastIndex = 0;
		int count = 0;

		while(lastIndex != -1){

			lastIndex = str.indexOf(p,lastIndex);

			if(lastIndex != -1){
				count ++;
				lastIndex += p.length();
			}
		}
		return count;
		
	}



	static int fibonacciWord(int n, String p) {
		String str = getFibString(n);
		String strTemp = str;

		char [] arr = strTemp.toCharArray();
		int count=0;
		for(int i = 0; i<arr.length-p.length()+1; i++){
			if(strTemp.substring(i, i+p.length()).equals(p)){
				count++;
			}
		}
		return count;

	}

	static public String getFibString(int n) {
		String x = "0", y = "1", z = "10";
		for (int i = 0; i < n; i++) {
			x = y;
			y = z;
			z = y+x;
		}
		return x;
	}

}
