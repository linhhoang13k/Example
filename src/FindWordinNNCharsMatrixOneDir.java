package program.java.random;





public class FindWordinNNCharsMatrixOneDir {

	static final int R = 5;
	static final int C = 5;

	static int rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int colNum[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Boolean found = false;

	public static void main(String[] args) {
		

		
		char[][] M = { 
				     { 'a', 'b', 'n', 'd', 'e' }, 
				     { 'd', 'f', 'u', 'g', 'n' }, 
				     { 'f', 'l', 'n', 'n', 's' },
				     { 'b', 'f', 'u', 'o', 'o' }, 
				     { 'n', 'u', 'f', 'u', 'n' } };

		String input = "abn";

		//findWord(M, input);
		
		System.out.println("gopal".substring(0, 0));

	}

	
	static boolean isSafe(int i, int j) {

		if (i >= 0 && i <= (R - 1) && j >= 0 && j <= C - 1) {
			return true;
		}

		return false;
	}

	private static void findWord(char[][] m, String input) {
		// TODO Auto-generated method stub

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				findWordUtil(m, i, j, input);
			}

		}

		if (!found)
			System.out.println("not found the input");

	}

	private static void findWordUtil(char[][] m, int row, int col, String word) {

		if (m[row][col] != word.charAt(0)) {
			return;

		}

		int len = word.length();

		for (int dir = 0; dir < 8; ++dir) {
			int rd = row + rowNum[dir];
			
			int cd = col + colNum[dir];
			int k;
			
			String path = word.charAt(0) + "(" + row + "," + col + ")";

			//System.out.println(" checking for  (" + rd + "," + cd + ")");

			for (k = 1; k <= len - 1; k++) {
                System.out.println("found the word: path:" + rd +" " + cd);
				if (!isSafe(rd, cd)) {
					break;

				}

				if (!(m[rd][cd] == word.charAt(k))) {
					break;
				} else {
					path = path.concat(m[rd][cd] + "(" + rd + "," + cd + ")");
				}

				rd = rd + rowNum[dir];
				cd = cd + colNum[dir];
			}

			if (k == len) {
				System.out.println("found the word: path:" + path);
				found = true;
			}

		}

	}
}
