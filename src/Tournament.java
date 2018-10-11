package program.java.random;

public class Tournament {

	public static void main(String[] args) {
	       
//        System.out.print("Enter any year:");
//        int year = 1996;
//        boolean flag = false;
//        if(year % 400 == 0)
//        {
//        	System.out.println("1");
//            flag = true;
//        }
//        else if (year % 100 == 0)
//        {
//        	System.out.println("11");
//            flag = false;
//        }
//        else if(year % 4 == 0)
//        {
//        	System.out.println("12");
//            flag = true;
//        }
//        else
//        {
//        	System.out.println("13");
//            flag = false;
//        }
//        if(flag)
//        {
//            System.out.println("Year "+year+" is a Leap Year");
//        }
//        else
//        {
//            System.out.println("Year "+year+" is not a Leap Year");
//        }
//		

		int[][] mat= {{1,0,0,2},{0,5,0,1},{0,0,0,5}};
		int[] rows = {1};
		int[] col = {0,2};
		int[][] res = constructSubmatrix(mat, rows, col);
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
		
	}

	public static int[][] constructSubmatrix(int[][] matrix, int[] rowsToDelete, int[] columnsToDelete) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int R = row - rowsToDelete.length;
		int C = col - columnsToDelete.length;
		int[][] res = new int[R][C];
		int rowIndex = 0;
		int colIndex = 0;
		for(int i=0;i<row;i++){
			if(!isThere(rowsToDelete, i)){
				colIndex = 0;
				for(int j=0;j<col;j++){
					if(!isThere(columnsToDelete, j)){
						res[rowIndex][colIndex] = matrix[i][j];
						colIndex++;
					}
				}	
			}
			if(!isThere(rowsToDelete, i)) rowIndex++;
		}
		
		return res;
	}
	public static boolean isThere(int[] arr,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				return true;
			}
		}
		return false;
	}
	
	boolean isPangram(String sentence) {
		
		
		StringBuilder s = new StringBuilder(sentence);
		String reverse = s.reverse().toString();
		if(sentence.equalsIgnoreCase(reverse)){
			return true;
		}
		return false;
	}

}
