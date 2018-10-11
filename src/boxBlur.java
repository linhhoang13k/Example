package test;
/*
 * Last night you had to study, but decided to party instead. 
 * Now there is a black and white photo of you that is about to go viral. 
 * You cannot let this ruin your reputation, so you want to apply box blur
 *  algorithm to the photo to hide its content.

The algorithm works as follows: each pixel x in the resulting image has a value 
equal to the average value of the input image pixels' values from the 3 × 3 square
 with the center at x. All pixels at the edges are cropped.

As pixel's value is an integer, all fractions should be rounded down.

Example

For

image = [[1, 1, 1], 
         [1, 7, 1], 
         [1, 1, 1]]
the output should be boxBlur(image) = [[1]].

In the given example all boundary pixels were cropped,
 and the value of the pixel in the middle was 
 obtained as (1 + 1 + 1 + 1 + 7 + 1 + 1 + 1 + 1) / 9 = 15 / 9 = ~rounded down~ = 1.

Input/Output

[time limit] 3000ms (java)
[input] array.array.integer image

An image is stored as a rectangular matrix of non-negative integers.

Guaranteed constraints:
3 ≤ image.length ≤ 10,
3 ≤ image[0].length ≤ 10,
0 ≤ image[i][j] ≤ 255.

[output] array.array.integer

A blurred image.


 */
public class BoxBlur {

	int[][] boxBlur(int[][] image) {
		 int sum = 0;
		 
		 
		 int x = image[0].length;
		 int y = image.length;
		 
		 int startX = 0;
		 int startY = 0;
		 int result[][] = new int[x-2][y-2];
		 int resultX=0;
		 int resultY = 0;
		 
		 while (startY<= y-3){
		 while(startX <= x-3)
		 {
			 for (int i=startY;i<startY+3;i++)
			 {
				 for (int j=startX;j<startX+3;j++)
			 {
				 sum = sum + image[i][j];
			 }
			 }
			 result[startX][startY] = Math.round(sum/9);
			 sum = 0;
			 startX++;
		 }
		 startX=0;
		 startY++;
		 
		 }
		 
		    
		 return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] image = {{36,0,18,9}, 
		                  {27,54,9,0}, 
		                  {81,63,72,45}};
		BoxBlur box =  new BoxBlur();
		image = box.boxBlur(image);
		for (int i=0;i<image.length;i++)
		{
			for (int j=0;j<image[i].length;i++)
			{
				System.out.println(image[i][j]);
			}
		}

	}

}
