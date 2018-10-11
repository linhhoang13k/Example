/*
 * Author: Luisa McKenna
 * 
 * Problem: Given a 2d array with an area denoted by 1's return the 
 * perimeter of the array
 * 
 */
public class MyPerimeterArea {
	int xWidth = 0;
	int yWidth = 0;
	boolean flag = false;
	boolean firstWidth = true;
	
	// findPerimeter method takes in a 2d array and an 
	// integer (denoting a color) and returns an integer (perimeter).
	int findPerimeter(int a[][],int color){
		for(int i = 0; i<a.length; i++){
			for(int j = 0; j<a[0].length; j++){
				if(a[i][j] == color){
					flag = true; 
					if(firstWidth == true){
						xWidth++;
					}
				}
			}
			if(flag == true){
				yWidth++;
				firstWidth = false;
				flag = false;
			}
		}
		return (xWidth*2 + yWidth*2);
	}
	
	// main method that tests findPerimeter
	public static void main(String args[]){
		MyPerimeterArea array = new MyPerimeterArea();
		System.out.println(array.findPerimeter(new int[][]{{3,3,3,3,3,3},
													{1,1,1,1,1,1},
													{1,1,1,1,1,1},
													{3,3,3,3,3,3}}, 1));
	}
}
