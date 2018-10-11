package exercise23;

public class ImageBlur {

	int[][] boxBlur(int[][] image) {
	   
		int[][] result = new int[image.length-2][image[0].length-2];
	    //if it is a 3x3, return a 1x1, if it is 4x3, return a 2x1, etc
	    for (int i =1; i < image.length-1; i++)
	    	//iterate over columns
	        for (int j = 1; j < image[0].length-1; j++) {
	            //iterate over rows
	        	int sum=0;
	            for(int ii=i-1;ii<=i+1;ii++) {
	                for(int jj=j-1;jj<=j+1;jj++) {
	                // add each position value to the array matrix
	                	sum+=image[ii][jj];
	                }               
	            }
	            result[i-1][j-1]=sum/9;
	            
	        }
	    return result;
	}
}
