package test;
/*
 * Given two cells on the standard chess board, determine whether they have the same color or not.

Example

For cell1 = "A1" and cell2 = "C3", the output should be
chessBoardCellColor(cell1, cell2) = true.
 */

public class chessBoardCellColor {
	
	boolean chessBoardCellColor(String cell1, String cell2) {
		
		int one = (int)(cell1.charAt(0));
		int oneNumber = Integer.parseInt(cell1.substring(1));
		int two = (int)(cell2.charAt(0));
		int twoNumber = Integer.parseInt(cell2.substring(1));
		int even = 0;
		int odd = 0;
		
	    if(one%2 == 0) even++; else odd++;
	    if(two%2 == 0) even++; else odd++;
	    if(oneNumber%2 == 0) even++; else odd++;
	    if(twoNumber%2 == 0) even++; else odd++;
	    
	    return even == odd || odd == 4 || even == 4;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		chessBoardCellColor color = new chessBoardCellColor();
		System.out.println(color.chessBoardCellColor("a1", "a2"));

	}

}
