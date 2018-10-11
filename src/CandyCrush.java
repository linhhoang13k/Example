package com.codefight.challanges;

public class CandyCrush {

	public static void main(String[] args) {
		char[][] gameboard = { {'Y','R','Y' }, 
							   {'R','Y','R' }, 
							   {'Y','R','Y' }};

		System.out.println(candyCrush1(gameboard));

	}

	static boolean candyCrush1(char[][] a){
		   int i = 0, j, u;
		   for ( ; i < a.length; i++)
		      for (j = 0; j < a[0].length; j++) {
		         u = a[i][j];
		         if (j > 1 && u == a[i][j-1] && u == a[i][j-2] ||
		             i > 1 && u == a[i-1][j] && u == a[i-2][j])            
		             return true;      
		      }
		   return false;
	}
	
	static boolean candyCrush12(char[][] gameboard) {
		// Horizontal Match
		for (char[] hArry : gameboard) {
			if (horizontalMatch(hArry)) {
				return true;
			}
		}

		// Vertical Match
		int vSize = gameboard.length;

		for (int i = 0; i < gameboard.length; i++) {
			char[] row = gameboard[i];
			for (int j = 0; j < row.length; j++) {
				char s = row[j];
				if (vSize >= 3) {
					if (s == (gameboard[i + 1][j]) && s == (gameboard[i + 2][j])) {
						return true;
					}
				}
			}
			vSize--;
			if (vSize < 3)
				return false;
		}
		return false;
	}

	static boolean horizontalMatch(char[] row) {
		char[] match = new char[3];
		int i = 0;
		for (char s : row) {
			if(i> 0){
				char zChar = match[i-1];
				if (zChar == s) {
					if (match.length >= 2 && match[i-2] == s) {
						return true;
					}
					match[i] = s;
					i++;
				} else {
					match = new char[3];
					i = 0;
					match[i] = s;
					i++;
				}	
			}else{
				match[i] =s;
				i++;
			}
		}
		
		if(i == 3) return true;

		return false;
	}
}
