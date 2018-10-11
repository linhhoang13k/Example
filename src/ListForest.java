package tiendm.codefight.core;

public class ListForest {
	int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
		for(int i = 0; i < inputArray.length; i++) {
			if(inputArray[i] == elemToReplace) inputArray[i] = substitutionElem;
		}
		return inputArray;
	}
	
	int[] concatenateArrays(int[] a, int[] b) {
		int[] x = new int[a.length+b.length];
	    int count = 0;
	    for(int i : a) x[count++] = i;
	    for(int i : b) x[count++] = i;
	    return x;
	}
	
	int[] removeArrayPart(int[] inputArray, int l, int r) {
	    int[] x = new int [inputArray.length + l - r  - 1];
	    int count = 0;
	    for(int i = 0; i < l || i > r ; i++){
	    	x[count++] = inputArray[i];
	    }
	    return x;
	}
	
	boolean isSmooth(int[] arr) {
		int l = arr.length, mid = 0;
		if(arr[0] != arr[l-1]) return false;
		mid = l % 2 == 1 ? arr[l/2] : arr[l/2-1] + arr[l/2];
		return arr[0] == mid;
	}
	
	int[] replaceMiddle(int[] arr) {
		int l = arr.length, mid = 0,c = 0;
		if(l % 2 == 1) return arr;
		int [] x = new int[l-1];
		mid = arr[l/2-1] + arr[l/2];
		for(int i = 0; i < l/2 - 1; i++) x[c++] = arr[i];
		x[c++] = mid;
		for(int i = l/2+1; i< l; i++) x[c++] = arr[i];
		return arr;
	}
	
	int makeArrayConsecutive2(int[] statues) {
		int min = statues[0], max = statues[0];
		for(int i : statues){
			if(i > max) max = i;
			if(i < min) min = i;
		}
		return max - min - statues.length + 1;
	}


	public static void main(String[] args) {
		ListForest test = new ListForest();
		System.out.println("TienDM");
		System.out.println(test);
	}
}
