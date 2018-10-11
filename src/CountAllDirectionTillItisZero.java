package companyBots.spaceX;

/**
 * Count all direction of a given cell till it meets zero
 * If the count matches the number return true
 */
public class CountAllDirectionTillItisZero {
	

	boolean like0hn0M(int[][] grid) {
		int[][] left = new int[grid.length][grid[0].length];
		int[][] right = new int[grid.length][grid[0].length];
		int[][] top = new int[grid.length][grid[0].length];
		int[][] bottom = new int[grid.length][grid[0].length];
		
		boolean result = true;
		for (int i = 0; i < grid.length; i++) {
			int[] gri = grid[i];
			for (int j = 0; j < gri.length; j++) {
				int value = gri[j];
				if (value > 0) {
					left[i][j]= (j-1>=0) ? left[i][j-1]+1 : 1;
					top[i][j]= (i-1>=0) ? top[i-1][j]+1 : 1;
				}
			}
		}
		int start = grid.length-1;
		int end = 0;
		for (int i = start; i >= end; i--) {
			int[] gri = grid[i];
			for (int j = gri.length-1; j >= 0; j--) {
				int value = gri[j];
				if (value > 0) {
					right[i][j]= (j+1<right[i].length) ? right[i][j+1]+1 : 1;
					bottom[i][j]= (i+1<bottom.length) ? bottom[i+1][j]+1 : 1;
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			int[] gri = grid[i];
			for (int j = 0; j < gri.length; j++) {
				int value = gri[j];
				if (value > 0) {
					int leftV = j-1>=0 ? left[i][j-1] : 0;
					int rightV = j+1<gri.length ? right[i][j+1] : 0;
					int topV = i-1>=0 ? top[i-1][j] : 0;
					int bottomV = i+1<grid.length ? bottom[i+1][j] : 0;
					
					int sum = leftV + rightV + topV + bottomV;
					if (value == sum) {
						result = true;
					} else {
						return false;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] grid = {{0},{0},{0},{0}}; 
		CountAllDirectionTillItisZero test = new CountAllDirectionTillItisZero();
		boolean result = test.like0hn0M(grid);
		System.out.println(result);

	}

}
