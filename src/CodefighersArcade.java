package codefighters;

import java.util.ArrayList;
import java.util.Arrays;

public class CodefighersArcade {


	static int largestNumber(int n) {
		int h = 0, j = n, k = 1;

		while(j-- > 0){
			k = k * 10;
		}
		while(n-- > 0){
			h += 9 * (k /= 10);
		}
		return h;
	}

	static int circleOfNumbers(int n, int firstNumber) {
		return (firstNumber > (n / 2)-1 ? firstNumber - (n / 2) : (n / 2) + firstNumber ); 
	}

	static int lateRide(int n) {
		int hr = n / 60;
		int min = n % 60;

		return hr / 10 + hr % 10 + min / 10 + min % 10;

	}

	static int phoneCall(int min1, int min2_10, int min11, int s) {
		int mins = (s / min1 > 0?1:0);
		s -= min1;
		int mins2_10 = (s > 0 ? s / min2_10: 0) > 9? 9 : s / min2_10;
		s -= mins2_10 * min2_10;
		int mins11 = (mins2_10 < 9)?0:s > 0 ? s / min11: 0;

		return mins + mins2_10 + mins11;
	}

	static boolean reachNextLevel(int experience, int threshold, int reward) {
		return (experience + reward) >= threshold? true: false;
	}

	static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW) {
		if(weight1 + weight2 <= maxW){
			return value1 + value2;
		}else{
			if(weight1 <= maxW && (value1 > value2 || weight2 > maxW)){
				return value1;
			}else if(weight2 <= maxW){
				return value2;
			}else{
				return 0;
			}
		}
	}

	static int extraNumber(int a, int b, int c) {
		return (a == b ? c: a == c? b : a);
	}

	static boolean isInfiniteProcess(int a, int b) {
		return a > b ? true: (b - a) % 2 == 0? false : true; 
	}

	static boolean arithmeticExpression(int A, int B, int C) {
		return A + B == C? true: A - B == C ? true : A * B == C? true : A / B == C? A % B == 0? true: false : false;
	}

	static boolean tennisSet(int score1, int score2) {
		if ((score1 > 5 || score2 > 5) && (score1 < 8 && score2 < 8)){
			if((score1 == 7 && score2 < 7 && score2 > 4) || (score1 == 6 && score2 < 5) || (score2 == 7 && score1 < 7 && score1 > 4) || (score2 == 6 && score1 < 5)){
				return true;
			}
		}
		return false;
	}

	static boolean willYou(boolean young, boolean beautiful, boolean loved) {
		if(loved){
			return young == beautiful && young == true? false:true;
		}else{
			return young == beautiful && young == true? true:false;
		}
	}

	static int[] metroCard(int lastNumberOfDays) {
		if(lastNumberOfDays < 31){
			return new int[]{31};
		}else{
			return  new int[]{28, 30, 31};
		}
	}

	static int killKthBit(int n, int k) throws Exception{
		return 	n & ~(1 << k-1);
	}

	static int arrayPacking(int[] a) {
		int i = 0;
		int res = 0;
		while(i < a.length){
			res += (a[i] << i++*8);
		}
		return res;
	}

	static int rangeBitCount(int a, int b) {
		int count = 0;
		while(b >= a){
			String tmp = Integer.toBinaryString(b--);
			count += tmp.length() - tmp.replace("1", "").length();
		}
		return count;
	}

	static int mirrorBits(int a) {
		int i = 0;
		while(a != 0){
			i<<=1;
			i|=(a &1);
			a>>=1;
		}
		return i;
	}

	static int secondRightmostZeroBit(int n) {
		return -~((n-~(n^(n+1))/2)^(n-~(n^(n+1))/2+1))/2 ;
	}

	static int swapAdjacentBits(int n) {
		return ((n & 0b10101010101010101010101010101010) >> 1) | ((n & 0b01010101010101010101010101010101) << 1) ;
	}

	static int differentRightmostBit(int n, int m) {
		return   -~((~(n^m)) ^((~(n^m))+1))/2 ;
	}

	static int equalPairOfBits(int n, int m) {
		return n+m+1 & ~n-m;
	}

	static int leastFactorial(int n) {
		int i = 0, cur = 1;
		while(cur < n){
			cur = cur * ++i;
		}
		return cur;
	}

	static int countSumOfTwoRepresentations2(int n, int l, int r) {
		int count = 0;
		while(l <= r){
			int l2 = l;
			if(l2 + r <= n)
				while(l2  <= r){
					if(l2++ + r == n){
						count++;
					}
				}
			r--;
		}
		return count;
	}

	static int magicalWell(int a, int b, int n) {
		int sum = 0;
		while(n-- > 0){
			sum += a++ * b++;
		}
		return sum;
	}

	static int lineUp(String commands) {
		int i = 0, count = 0;
		boolean pair = true;
		char command[] = commands.toCharArray();
		while(i < command.length){
			if(command[i] == 'L' || command[i] == 'R'){
				if(!pair){
					count++;
				}
				pair = !pair;
			}else{
				if(pair){
					count++;
				}
			}
			i++;
		}
		return count;	
	}

	static int additionWithoutCarrying(int param1, int param2) {
		int result = 0, div = 10;

		while(param1 > 0 || param2 > 0){
			result += (param1 % div + param2 % div) % div;
			param1 -= param1 % div;
			param2 -= param2 % div;
			div *= 10;
		}
		return result;
	}

	static int appleBoxes(int k) {
		int red = 0, yellow = 0, i = 0;
		while(i++ < k){
			if(i % 2 == 0){
				red += i * i;
			}else{
				yellow += i * i;
			}
		}
		return red - yellow;
	}

	static boolean increaseNumberRoundness(int n) {
		String tmp = n+"";
		int i = tmp.indexOf("0");
		if(i < tmp.length() && i > -1){
			tmp = tmp.substring(i);
			if(tmp.contains("1") || tmp.contains("2") || tmp.contains("3") || tmp.contains("4") || tmp.contains("5") || tmp.contains("6") || tmp.contains("7") || tmp.contains("8") || tmp.contains("8")){
				return true;
			}
		}
		return false;
	}

	static int rounders(int value) {
		int div = 10;
		while(div < value){
			int res = value % div;
			value = value - res;
			if(res / (div / 10)  >= 5){
				value += div;
			}
			div *= 10;
		}
		return value;
	}

	static int candles(int candlesNumber, int makeNew) {
		int count = 0, leftover = 0;
		while(candlesNumber > 0){
			count += candlesNumber;
			leftover += candlesNumber;
			candlesNumber = leftover / makeNew;
			leftover = leftover % makeNew;
		}
		return count;
	}

	static int countBlackCells(int n, int m) {
		int cells = 0, div = 2, maxDiv = 1;
		cells = n + m - 2;
		if(n == 1 || m == 1){
			return n * m;
		}else{
			while(n > 1 && m > 1 && div <= n && div <= m){
				if(n%div != 0 || m%div!=0){
					div++;
				}else{
					n /= div;
					m /= div;
					maxDiv *= div;
				}
			}
			return cells + maxDiv;
		}

	}

	static int[] createArray(int size) {
		int[] array = new int[size];
		Arrays.fill(array, 1);
		return array;
	}

	static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		for(int i = 0; i < inputArray.length; i++){
			if(inputArray[i] == elemToReplace)
				inputArray[i]=substitutionElem;
		}
		return inputArray;
	}

	static int[] firstReverseTry(int[] arr) {
		if(arr.length > 0){
			int tmp = arr[0];
			arr[0] = arr[arr.length - 1];
			arr[arr.length - 1] = tmp;			
		}
		return arr;
	}

	static int[] concatenateArrays(int[] a, int[] b) {
		int[] array = new int[a.length + b.length];

		for(int i = 0; i < a.length || i < b.length; i++){
			if(i < a.length){
				array[i] = a[i];
			}
			if(i < b.length){
				array[i + a.length] = b[i];
			}
		}
		return array;
	}

	static int[] removeArrayPart(int[] inputArray, int l, int r) {
		int[] array = new int[inputArray.length - ((r - l) + 1)];

		for(int i = 0, j = 0; i < inputArray.length; i++){
			if(i < l || i > r){
				array[j++] = inputArray[i];
			}
		}
		return array;

	}

	static boolean isSmooth(int[] arr) {
		if(arr[0] == arr[arr.length-1]){
			if(arr.length % 2 == 0){
				if(arr[(arr.length/2)-1] + arr[arr.length/2] == arr[0]){
					return true;
				}
			}else{
				if(arr[arr.length/2] == arr[0]){
					return true;
				}
			}
		}
		return false;
	}

	static int[] replaceMiddle(int[] arr) {
		if(arr.length%2==0){
			int[] array = new int[arr.length - 1];
			for(int i = 0, j = 0; i < arr.length; i++, j++){
				array[j] = arr[i];
				if(i == (arr.length / 2) -1){
					array[j] +=  arr[++i];
				}
			}
			return array;
		}else{
			return arr;
		}
	}

	static int makeArrayConsecutive2(int[] sequence) {
		int min = sequence[0], max = sequence[0];
		for(int i = 0; i < sequence.length; i++){
			if(min > sequence[i]){
				min = sequence[i];
			}
			if(max < sequence[i]){
				max = sequence[i];
			}
		}
		return max - min - (sequence.length - 1);
	}

	static boolean isPower(int n) {
		if(n == 1){
			return true;
		}
		for(int i = 2; i < n/2; i++){
			for(int j = i; j < n/2; j= j * i){
				if(j * i == n){
					return true;
				}
			}
		}
		return false;
	}

	static int isSumOfConsecutive2(int n) {
		int count = 0;
		for(int i = 1; i < (n/2)+1; i++){
			int sum = i;
			for(int j = i + 1; sum < n; j++){
				sum += j; 
				if(sum == n){
					count++;
				}
			}
		}
		return count;
	}

	static int squareDigitsSequence(int a0) {
		int tmp = a0;
		ArrayList al = new ArrayList<>();
		while(!al.contains(a0)){
			al.add(a0);
			a0 = 0;
			for(int i = 10; tmp > 0; ){
				a0 += (tmp%i) * (tmp%i); 
				tmp=tmp/10;
			}
			tmp = a0;
		}
		return al.size() + 1;
	}

	static int pagesNumberingWithInk(int current, int numberOfDigits) {

		while(numberOfDigits >= (current + "").length()){
			numberOfDigits -= (current++ + "").length();
		}

		return current-1;
	}

	static int comfortableNumbers(int L, int R) {
		int pairs = 0;
		while(L < R){
			int comfL = suma(L), i = L + 1;
			while(i <= R){
				int comfR = suma(i);
				if(i <= L + comfL && L >= i - comfR){
					pairs++;
				}
				i++;
			}
			L++;
		}
		return pairs;
	}

	static int suma(int j){
		int comf = 0;
		while(j > 0){
			comf += j % 10;
			j /= 10;
		}
		return comf;
	}

	static int[] weakNumbers(int n) {
		int[] result = {0, 0};
		int nW = weakness(n);
		for(int i = 1; i <= n; i++){
			int j = weakness(i);
			if(j > result[0]){
				result[0] = j;
				result[1] = 1;
			}else if(j == result[0]){
				result[1]++;
			}
		}
		return result;
	}

	static int weakness(int n){
		int divisor = divisor(n--);
		int count = 0;
		while(n>0){
			if(divisor(n--) > divisor){
				count++;
			}
		}
		return count;
		
	}
	
	static int divisor(int n){
		int div = 1;
		if(n > 1)
			for(int i = 1; i < n;i++){
				if(n % i == 0){
					div++;
				}
			}
		return div;
	}

	static int rectangleRotation(int a, int b) {
		int count = 0; 
		for(int x = -a - b; x <= a + b; x++ ){
			for(int y = -a - b; y<= a + b; y++){
				if(2*(x-y)*(x-y)<= a * a && 2*(x+y)*(x+y)<= b*b){
					count++;
				}
			}
		}
		return count;
	}
	
	static int crosswordFormation(String[] words) {
		int count = 0;
		for(int selWord1=0; selWord1<words.length;selWord1++){
			for(int selWord2=0;selWord2<words.length;selWord2++){
				if(selWord2 == selWord1){
					selWord2++;
				}
				if(selWord2 >= words.length){
					break;
				}
				for(int throughWord1=2; throughWord1<words[selWord1].length(); throughWord1++){
					for(int throughWord2=0; throughWord2<words[selWord2].length();throughWord2++){
						if(words[selWord1].charAt(throughWord1) == words[selWord2].charAt(throughWord2)){
//							System.out.println("1: Word.-" + words[selWord1] + ", char: " + throughWord1 + "," + words[selWord1].charAt(throughWord1));
//							System.out.println("2: Word.-" + words[selWord2] + ", char: " + throughWord2 + "," + words[selWord2].charAt(throughWord2));
							
							for(int selWord3=0; selWord3<words.length;selWord3++){
								while(selWord3 < words.length && (selWord3 == selWord1 || selWord3 == selWord2)){
									selWord3++;
								}
								if(selWord3 >= words.length){
									break;
								}
								for(int throughWord2a = throughWord2+2; throughWord2a<words[selWord2].length();throughWord2a++){
									for(int throughWord3=2; throughWord3<words[selWord3].length();throughWord3++){
										if(words[selWord2].charAt(throughWord2a) == words[selWord3].charAt(throughWord3)){
//											System.out.println("3: Word.-" + words[selWord3] + ", char: " + throughWord3 + "," + words[selWord3].charAt(throughWord3));
											
											int selWord4 = 0;
											while(selWord4 < words.length && (selWord4 == selWord1 || selWord4 == selWord2 || selWord4 == selWord3)){
												selWord4++;
											}
											if(selWord4 >= words.length){
												break;
											}
											for(int throughWord4=0; throughWord4 < words[selWord4].length()- (throughWord2a - throughWord2);throughWord4++){
												for(int x = 0; x< throughWord1-1; x++){
													if(words[selWord4].charAt(throughWord4) == words[selWord1].charAt(x)){
														if(throughWord3 - (throughWord1 - x) >= 0 && words[selWord4].charAt(throughWord4 + throughWord2a - throughWord2) == words[selWord3].charAt(throughWord3 - (throughWord1 - x))){
//															System.out.println("1: Word.-" + words[selWord1] + ", char: " + throughWord1 + "," + words[selWord1].charAt(throughWord1));
//															System.out.println("2: Word.-" + words[selWord2] + ", char: " + throughWord2 + "," + words[selWord2].charAt(throughWord2));
//															System.out.println("3: Word.-" + words[selWord3] + ", char: " + throughWord3 + "," + words[selWord3].charAt(throughWord3));
//															System.out.println("4: Word.-" + words[selWord4] + ", char: " + throughWord4 + "," + words[selWord4].charAt(throughWord4));
//															System.out.println();
															count++;
														}
													}
												}
											}
											
										}
									}
									
								}
							}
						}
					}
				}
			}
		}
		return count;
	}

	

}


