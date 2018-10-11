package tiendm.codefight.core;

public class Loop {
	int countSumOfTwoRepresentations2(int n, int l, int r) {
		int count = 0;
		for(int i = l; i <= r; i++){
			int b = n - i;
			if(b >= i && b <= r) count++;
		}
		return count;
	}
	int magicalWell(int a, int b, int n) {
		int sum = 0;
		for(int i = 0; i < n; i++){
			sum += (a+i) *(b+i);
		}
		return sum;
	}
	
	int lineUp(String commands) {
		int n = commands.length();
		int[] smartStudent = new int[n];
		int[] stupidStudent = new int[n];
		int smart = 0, stupid = 0, count = 0;
		for(int i = 0; i < commands.length(); i++){
			switch (commands.charAt(i)) {
			case 'L':
				smartStudent[i] = (smart + 1) % 4;
				smart = smartStudent[i];
				stupidStudent[i] = (stupid -1 + 4) % 4;
				stupid = stupidStudent[i];
				break;
			case 'R':
				smartStudent[i] = (smart - 1 +4) % 4;
				smart = smartStudent[i];
				stupidStudent[i] = (stupid + 1) % 4;
				stupid = stupidStudent[i];
				break;
			case 'A':
				smartStudent[i] = (smart + 2) % 4;
				smart = smartStudent[i];
				stupidStudent[i] = (stupid + 2) % 4;
				stupid = stupidStudent[i];
				break;
			default:
				break;
			}
		}
		for(int i = 0; i < n; i++){
			if(smartStudent[i] == stupidStudent[i]) count++;
		}
		return count;
	}
	
	int lineUpSolution(String commands) {
	    int count = 0;
	    boolean check = true;
	    for (char c : commands.toCharArray()) {
	        if (c == 'L' || c == 'R')
	            check = !check;
	        if (check)
	            count++;
	    }
	    return count;
	}
	
	int additionWithoutCarrying(int param1, int param2) {
		int sum = 0, mod = 0, count = 0;
	    while(param1 + param2 > 0){
	    	mod = (param1 + param2 ) % 10;
	    	param1 /= 10;
	    	param2 /= 10;
	    	sum += mod * (Math.pow(10, count++));
	    }
	    return sum;
	}
	
	int appleBoxes(int k) {
	    return k % 2 == 0 ? k*(k+1)/2 : -k*(k+1)/2;
	}
	
	boolean increaseNumberRoundness(int n) {
	    boolean check = false;
	    while(n > 0){
	        if(n % 10 != 0) {
	        	check = true;
	        } else if(check) return true;
	        n = n/10;
	    }
	    return false;
	}
	
	int rounders(int value) {
		int p = 0, check = value;
	    while (check > 9) {
	    	int pow = (int) Math.pow(10, p);
	    	int powNext = (int) Math.pow(10, p+1);
	    	value = (int) ((value + 5 * pow) / powNext) * powNext;
	    	check = value / powNext;
			p++;
		}
	    return value;
	}
	
	int rounders2(int value) {
	    return value < 10 ? value : rounders2((value+5)/10)*10;
	}
	
	int candles(int candlesNumber, int makeNew) {
		return candlesNumber + candles(candlesNumber, makeNew, 0);
	}
	
	int candles(int candlesNumber, int makeNew, int preRemain) {
		if(candlesNumber + preRemain < makeNew) return 0;
		int candleNew = candlesNumber / makeNew;
		int remmain = candlesNumber % makeNew;
		int candleNewFromRemain = (remmain + preRemain) / makeNew;
		remmain = (remmain + preRemain) % makeNew;
		candleNew += candleNewFromRemain;
		if(candleNewFromRemain == 1) return candleNew;
		return candleNew + candles(candleNew, makeNew, remmain);
	}
	
	int candles2(int candlesNumber, int makeNew) {
		if(candlesNumber < makeNew) return candlesNumber;
		int sum = candlesNumber, preLeftOver = 0, leftOver = candlesNumber % makeNew ,
					candlesNew = candlesNumber;
		while(candlesNew+ preLeftOver >= makeNew){
			leftOver = candlesNew % makeNew;
			candlesNew = candlesNew / makeNew;
			int candlesFromLeftOver = (leftOver + preLeftOver) / makeNew;
			preLeftOver = (leftOver + preLeftOver) % makeNew;
			candlesNew += candlesFromLeftOver;
			sum += candlesNew ;
		}
		return sum;
	}
	
	int countBlackCells2(int n, int m) {
		int count = 0, x1=0, x2=0, x3 = 0, x4 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				x1 = m * i - n * j;
				x2 = m * (i+1) - n * j;
				x3 = m * i - n * (j+1);
				x4 = m * (i+1) - n * (j+1);
				if(x1 * x2 * x3 * x4 <= 0 || x1 * x2 < 0 || x1 * x3 < 0 || x1 * x4 < 0){
					count++;
				}
			}
		}
		return count;
	}
	
	static int countBlackCells(int n, int m) {
		int count = 0;
		int y_c = 0, x_c = 0, y1_c = 0, x1_c = 0;
		for(int y = 0; y < n; y++) {
			for(int x = 0; x < m; x++) {
				y_c = m * n * x ;
				y1_c = m * n * (x+1);
				x_c = m * n * y;
				x1_c = m * n * (y+1);
				if((m * m * y - y_c) * (m * m * (y+1) - y_c) <= 0){
					count++;
					continue;
				}
				if((n * n * x - x_c) * (n * n * (x+1) - x_c) <= 0){
					count++;
					continue;
				}	
				if((m * m * y - y1_c) * (m * m * (y+1) - y1_c) <= 0){
					count++;
					continue;
				}
				if((n * n * x - x1_c) * (n * n * (x+1) - x1_c) <= 0){
					count++;
					continue;
				}
			}
		}
		return count;
	}
	
	int countBlackCells3(int n, int m) {
		if(n == 1) return m;
		if(m == 1) return n;
		if(m == n) return 4 + 3 * (n-2);
		double b = (double)m/n;
		int sum = 0;
		for(int y = 0; y < n; y++){
			double low_x = b * y;
			double hight_x = b * (y+1);
			int floor_x = (int)Math.floor(low_x);
			int ceil_x = (int)Math.ceil(hight_x);
			if(floor_x == low_x && floor_x != 0) floor_x = floor_x - 1;
			if(ceil_x == hight_x && ceil_x != m) ceil_x = ceil_x + 1;
			sum += (ceil_x - floor_x);
		}
		return sum;
			
	}
	
	int countBlackCellsSolution(int n, int m) {
	    int max = 1;
	    for (int i = 1; i <= n; i++) {
	        if (n%i == 0 && m%i == 0)
	            max = i;
	    }
	    return n+m+max-2;
	}
	
	public static void main(String[] args) {
		Loop test = new Loop();
		System.out.println(test.candles2(5, 2));
	}
}
