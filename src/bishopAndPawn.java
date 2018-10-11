package test;
/*
 * Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop can capture the pawn in one move.

The bishop has no restrictions in distance for each move, but is limited to diagonal movement. Check out the example below to see how it can move:
 */

public class bishopAndPawn {
	
	boolean bishopAndPawn(String bishop, String pawn) {
		System.out.println(bishop.charAt(1) +" " +pawn.charAt(1) + " " + Integer.parseInt(Integer.toHexString(bishop.charAt(0))) + " " + Integer.parseInt(Integer.toHexString(pawn.charAt(0))));
		
		return (Math.abs(bishop.charAt(1) - pawn.charAt(1)) == Math.abs(Integer.parseInt(Integer.toHexString(bishop.charAt(0))) -  Integer.parseInt(Integer.toHexString(pawn.charAt(0)))));

	}



	public static void main(String[] args) {
		
		bishopAndPawn b = new bishopAndPawn();
		System.out.println(b.bishopAndPawn("a3", "b2"));
		// TODO Auto-generated method stub

	}

}
