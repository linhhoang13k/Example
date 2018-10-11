package com.codefight.challanges;

public class ZigArray {

	public static void main(String[] args) {
		getZigZagArray(5);
	}
	


	public static int[][] getZigZagArray(int mSize){
		int[][] zigZag = new int[mSize][mSize];
		int x=0, y=0;
		for(int i=1; i<= mSize*mSize;i++){
			zigZag[x][y]=i;
			
			int mod = (x+y) %2;
			if(mod ==0 ){
				y++;
				if(y < mSize) x--;
				x = (x < 0)?0:x;
				if (y >= mSize){
					y--;
					x++;
				};
			}else{
				x++;
				if(x < mSize) y--;
				y = (y < 0)?0:y;
				if(x >= mSize){
					x--;
					y++;
				}
			}
		}
		
		for (int[] is : zigZag) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
		return zigZag;
	}
}
