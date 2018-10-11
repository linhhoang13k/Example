package codefighters;

import java.util.ArrayList;
import java.util.List;

public class SpringOfIntegration {
	static int arrayConversion(int[] inputArray) {
		for(int i = 0; inputArray.length > 1; i++){
			int[] tmp = new int[inputArray.length/2];
			for(int j = 0; j < tmp.length; j++){
				if(i%2==0){
					tmp[j] = inputArray[j*2] + inputArray[j*2+1];
				}else{
					tmp[j] = inputArray[j*2] * inputArray[j*2+1];
				}
			}
			inputArray = tmp;
		}
		return inputArray[0];
	}

	static int[] arrayPreviousLess(int[] items) {
		int[] result = new int[items.length];
		for(int i = 0; i < items.length; i++){
			result[i] = -1;
			for(int j = i - 1; j >= 0; j--){
				if(items[j] < items[i]){
					result[i] = items[j];
					break;
				}
			}
		}
		return result;
	}

	static boolean pairOfShoes(int[][] shoes) {

		List<int[]> shoe = new ArrayList<int[]>(){{for(int[] current: shoes)add(current);}};
		boolean paired = false;
		for(int i = 0; i < shoe.size();){
			paired = false;
			for(int j = i + 1; j < shoe.size() && !paired;j++){
				if(shoe.get(i)[1] == shoe.get(j)[1] && shoe.get(i)[0] != shoe.get(j)[0]){
					shoe.remove(j);
					shoe.remove(i);
					paired = true;
					break;
				}
			}
			if(!paired){
				return false;
			}
		}
		if(shoe.size() == 0){
			return true;
		}
		return false;
	}

	static int combs(String comb1, String comb2) {
		int currentLength = comb1.length() + comb2.length();
		int offset = -comb2.length();
		boolean bonded = false;

		for(int i = 0; offset < comb1.length(); i++, offset++){
			bonded = true;
			for(int j = 0; j < comb2.length() && j+offset < comb1.length(); j++){
				if(j + offset >= 0 && j + offset < comb1.length()){
					if(comb1.charAt(j+offset) != comb2.charAt(j) || comb1.charAt(j+offset) == '.'){
						bonded = true;
					}else{
						bonded = false;
						break;
					}
				}
			}
			if(bonded){
				if(offset < 0){
					if(currentLength > comb2.length() - (comb2.length() + offset) + comb1.length()){
						currentLength = comb2.length() - (comb2.length() + offset) + comb1.length();
					}
				}else if(offset + comb2.length() < comb1.length()){
					if(currentLength > comb1.length())
						currentLength = comb1.length();
				}else{
					if(currentLength > comb1.length() + (comb2.length() - (comb1.length() - offset))){
						currentLength = comb1.length() + (comb2.length() - (comb1.length() - offset));
					}
				}
			}

		}
		return currentLength;
	}

	static int stringsCrossover(String[] inputArray, String result) {
		boolean crossed = true;
		int count = 0;
		for(int i = 0; i < inputArray.length; i++){
			for(int j = i + 1; j < inputArray.length; j++){
				crossed = true;
				for(int k = 0; k < result.length() && crossed; k++){
					if(result.charAt(k) != inputArray[i].charAt(k) && result.charAt(k) != inputArray[j].charAt(k)){
						crossed = false;
					}
				}
				if(crossed){
					count++;
				}
			}
		}
		return count;
	}

	static int cyclicString(String s) {
		for (int i = 1;i<=s.length();i++) {
			String sub = s.substring(0,i);
			boolean root = true;
			for (int j = 0;j<s.length();j++) {
				if (s.charAt(j) != sub.charAt(j % sub.length())) {
					root = false;
					break;
				}
			}
			if (root) {
				return i;
			}
		}
		return 0;
	}

	static boolean beautifulText(String inputString, int l, int r) {
		for(int i = l; i <= r; i++){
			if(inputString.length() % i != 0){
				if(inputString.length() % i == (inputString.length() / i)-1){
					boolean correct = true;
					for(int j = 1; (j*i)+(j-1) < inputString.length(); j++){
						if(inputString.charAt((j*i)+(j-1)) != ' '){
							correct = false;
						}
					}
					if(correct){
						return true;
					}
				}
			}
		}
		return false;
	}

	static int runnersMeetings(int[] startPosition, int[] speed) {

		int count = -1;
		for(int i = 0; i < startPosition.length; i++){
			for(int j = i + 1; j < startPosition.length; j++){
				int diffPos = startPosition[j] - startPosition[i], diffSpeed = speed[i] - speed[j];
				int current = 0;
				if(diffPos != 0 && diffSpeed == 0){
					break;
				}
				for(int k = 0; k < startPosition.length; k++){
					if(startPosition[k] * diffSpeed + speed[k] * diffPos == startPosition[i] * diffSpeed + speed[i] * diffPos){
						current++;
					}
				}
				if(current > count){
					count = current;
				}
			}
		}
		return count;
	}

	static String[] christmasTree(int levelNum, int levelHeight) {
		//top
		List<String> finalist = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			String tmp = "";
			for(int j = 1; j < 1 + levelHeight + levelNum ; j++){

				if(i == 2){
					if(j < levelHeight + levelNum){
						tmp += " ";
						System.out.print(" ");
					}else{
						tmp += "***";
						System.out.print("***");
					}
				}else{
					if(j < levelHeight + levelNum){
						tmp += " ";
						System.out.print(" ");
					}else{
						tmp += " *";
						System.out.print(" *");
					}
				}
			}
			finalist.add(tmp);
			System.out.println("");
		}

		//body
		for(int i = 0; i < levelNum; i++){
			for(int j = 0; j < levelHeight; j++){
				String tmp = "";
				for(int k = 0; k < (levelHeight - j - i - 1) + (6 + 2*j + 2*i) + (levelNum-1 * 2); k++){
					if(k < levelHeight - j - i  + levelNum- 2){
						tmp += " ";
						System.out.print(" ");
					}else{
						tmp += "*";
						System.out.print("*");
					}
				}
				System.out.println("");
				finalist.add(tmp);
			}
		}
		//foot
		int adjust = levelHeight%2==0?1:0;
		int last = finalist.get(finalist.size()-1).length();
//		for(int i = 0; i < levelNum; i++){
			String tmp = "";
			
			
//			(finalist.get(finalist.size()-1).length() - levelHeight + adjust)/2 
			for(int j = 0; j < finalist.get(finalist.size()-1).length() - levelHeight  ; j++){
				if(levelHeight%2==0){
//					if(j <= levelHeight -1){
					if(j <= (finalist.get(finalist.size()-1).length() - levelHeight)/2 -1){
						tmp += " ";
						System.out.print(" ");
					}else{
						tmp += "*";
						System.out.print("*");
					}
				}else{
//					if(j < levelHeight){
					if(j < (finalist.get(finalist.size()-1).length() - levelHeight)/2 ){
						tmp += " ";
						System.out.print(" ");
					}else if(j > (finalist.get(finalist.size()-1).length() - levelHeight)/2 + levelHeight/2){
					}else{
						tmp += "*";
						System.out.print("*");
					}
				}
			}
			finalist.add(tmp);
			System.out.println("");
//		}
		

		String [] ultimo = finalist.toArray(new String[0]);

		return finalist.toArray(new String[0]);

	}

}
