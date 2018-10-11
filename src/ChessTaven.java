package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChessTaven {
	boolean bishopAndPawn(String bishop, String pawn) {
		int x1 = bishop.charAt(0) - 'a';
		int y1 = bishop.charAt(1) - '1';
		int x2 = pawn.charAt(0) - 'a';
		int y2 = pawn.charAt(1) - '1';
		return (x1+y1 == x2+y2) || (x1-y1==x2-y2);
	}
	
	///////////////////////////////////
	int chessKnightMoves(String cell) {
		int x = cell.charAt(0) - 'a';
		int y = cell.charAt(1) - '1';
		int count = 0;
		count += checkKnight(x+2,y+1);
		count += checkKnight(x+1,y+2);
		count += checkKnight(x+2,y-1);
		count += checkKnight(x+1,y-2);
		count += checkKnight(x-1,y-2);
		count += checkKnight(x-2,y-1);
		count += checkKnight(x-2,y+1);
		count += checkKnight(x-1,y+2);
		return count;
	}
	
	int checkKnight(int i, int j) {
		if(i >= 0 && i < 8 && j >= 0 && j < 8) return 1;
		return 0;
	}
	
	///////////////////////////////
	String[] bishopDiagonal(String bishop1, String bishop2) {
		int x1 = bishop1.charAt(0) - 'a';
		int y1 = bishop1.charAt(1) - '1';
		int x2 = bishop2.charAt(0) - 'a';
		int y2 = bishop2.charAt(1) - '1';
		String[] result = new String[2];
		if(x1+y1 == x2+y2){
			while (x1 > 0 && y1 < 7) {
				x1--;
				y1++;
			}
			while (x2 < 7 && y2 > 0) {
				x2++;
				y2--;
			}
			result[0] = (char)(x1 + 'a') + "" + (char)(y1 + '1');
			result[1] = (char)(x2 + 'a') + "" + (char)(y2 + '1');
			return result;
		}else if (x1-y1 == x2-y2){
			while (x1 * y1 > 0) {
				x1--;
				y1--;
			}
			while (x2 < 7 && y2 < 7) {
				x2++;
				y2++;
			}
			result[0] = (char)(x1 + 'a') + "" + (char)(y1 + '1');
			result[1] = (char)(x2 + 'a') + "" + (char)(y2 + '1');
			return result;
		}else {
			if((int)bishop1.charAt(0) < (int)bishop2.charAt(0)){
				return new String[]{bishop1,bishop2};
			}else if ((int)bishop1.charAt(0) > (int)bishop2.charAt(0) ) {
				return  new String[]{bishop2,bishop1};
			} else {
				return (int)bishop1.charAt(1) <= (int)bishop2.charAt(1) ? new String[]{bishop1,bishop2} : new String[]{bishop2,bishop1};
			}
		}
	}
	
	//////////////////////////////////////////
	boolean whoseTurn(String p) {
		String[] arr = p.split(";");
		int wx1 = arr[0].charAt(0) - 'a';
		int wy1 = arr[0].charAt(1) - '1';
		int wx2 = arr[1].charAt(0) - 'a';
		int wy2 = arr[1].charAt(1) - '1';
		int bx1 = arr[2].charAt(0) - 'a';
		int by1 = arr[2].charAt(1) - '1';
		int bx2 = arr[3].charAt(0) - 'a';
		int by2 = arr[3].charAt(1) - '1';
		int w1 = color(wx1, wy1);
		int w2 = color(wx2, wy2);
		int b1 = color(bx1, by1);
		int b2 = color(bx2, by2);
		int sum = 0;
		if(w1 == 0) sum += 1;
		if(w2 == 1) sum += 1;
		if(b1 == 1) sum += 1;
		if(b2 == 0) sum += 1;
		return sum%2 == 1;
	}
	int color(int r, int c){
		return (r+c)%2;
	}
	
	////////////////////////////////////////////////////////////
	int[] chessBishopDream(int[] boardSize, int[] initPosition, int[] initDirection, int k) {
	    int[] pos=new int[2];
	    int lim=boardSize[0]*boardSize[1]*2;
	    
	    pos[0]=initPosition[0];
	    pos[1]=initPosition[1];
	    k=k%(lim);
	    for(int i=0;i<k;i++) {
	        if ((pos[0]==0)&&(initDirection[0]==-1))  initDirection[0]=1;
	        else if ((pos[0]==boardSize[0]-1)&&(initDirection[0]==1)) initDirection[0]=-1;
	        else pos[0]=pos[0]+initDirection[0];

	        if ((pos[1]==0)&&(initDirection[1]==-1)) initDirection[1]=1;
	        else if ((pos[1]==boardSize[1]-1)&&(initDirection[1]==1)) initDirection[1]=-1;
	        else  pos[1]=pos[1]+initDirection[1];
	    }
	 
	    return pos;
	}
	
	////////////////////////////////////////////////////////////
	int chessTriangle(int n, int m) {
		int sum = 0;
		int[][] check = new int[n][m];
		for(int x = 0; x < n; x++){
			for(int y = 0; y < m; y++){
				sum += chessRook(x,y,check);
				sum += chessBishop(x,y,check);
			}
		}
		return sum;
	}


	int chessBishop(int x, int y, int[][] check) {
		List<Integer> lsPoisition = getPosition(x,y,check);
		if(lsPoisition.isEmpty()) return 0;
		int count = 0, limit = Math.max(check.length, check[0].length);
		for(int k = 0; k < lsPoisition.size()-1; k+=2){
			int xb = lsPoisition.get(k), yb = lsPoisition.get(k+1);
			for(int i = 0; i < limit; i++){
				if(valid(xb + i, yb + i, check) && checkBiShopKnight(x,y,xb + i,yb + i)) {
					count++;
				}
				if(valid(xb - i, yb - i, check) && checkBiShopKnight(x,y,xb - i,yb - i)) {
					count++;
				}
				if(valid(xb + i, yb - i, check) && checkBiShopKnight(x,y,xb + i,yb - i)) {
					count++;
				}
				if(valid(xb - i, yb + i, check) && checkBiShopKnight(x,y,xb - i,yb + i)) {
					count++;
				}
			}
		}
		return count;
	}
	
	boolean checkBiShopKnight(int x1,int y1,int x2,int y2) {
		return (x1 == x2 || y1 == y2);
	}

	int chessRook(int x, int y, int[][] check) {
		List<Integer> lsPoisition = getPosition(x,y,check);
		if(lsPoisition.isEmpty()) return 0;
		int count = 0, limit = Math.max(check.length, check[0].length);
		for(int k = 0; k < lsPoisition.size()-1; k+=2){
			int xb = lsPoisition.get(k), yb = lsPoisition.get(k+1);
			for(int i = 0; i < check.length; i++){
				if(valid(xb + i, yb, check) && checkRookKnight(x,y,xb + i,yb)) {
					count++;
				}
				if(valid(xb - i, yb, check) && checkRookKnight(x,y,xb - i,yb)) {
					count++;
				}
				if(valid(xb, yb - i, check) && checkRookKnight(x,y,xb,yb - i)) {
					count++;
				}
				if(valid(xb, yb + i, check) && checkRookKnight(x,y,xb,yb + i)) {
					count++;
				}
			}
		}
		return count;
	}
	
	boolean checkRookKnight(int x1,int y1,int x2,int y2) {
		return (Math.abs(Math.abs(x1) - Math.abs(x2)) == Math.abs(Math.abs(y1) - Math.abs(y2)));
	}

	List<Integer> getPosition(int x, int y, int[][] check) {
		List<Integer> ls = new ArrayList<>();
		if(valid(x+1,y+2,check)){
			ls.add(x+1);
			ls.add(y+2);
		}
		if(valid(x+2,y+1,check)){
			ls.add(x+2);
			ls.add(y+1);
		}
		if(valid(x-1,y-2,check)){
			ls.add(x-1);
			ls.add(y-2);
		}
		if(valid(x-2,y-1,check)){
			ls.add(x-2);
			ls.add(y-1);
		}
		if(valid(x-1,y+2,check)){
			ls.add(x-1);
			ls.add(y+2);
		}
		if(valid(x-2,y+1,check)){
			ls.add(x-2);
			ls.add(y+1);
		}
		if(valid(x+1,y-2,check)){
			ls.add(x+1);
			ls.add(y-2);
		}
		if(valid(x+2,y-1,check)){
			ls.add(x+2);
			ls.add(y-1);
		}
		return ls;
	}
	

	boolean valid(int i, int j, int[][] check) {
		try {
			int c = check[i][j];
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	///////////////////////////////////////////////////
	int[] amazonCheckmate(String king, String amazon) {
		int[][] check = new int[8][8];
		int xKing = 7 - (king.charAt(1) - '1');
		int yKing = king.charAt(0) - 'a';
		int xAmazon = 7 - (amazon.charAt(1) - '1');
		int yAmazon = amazon.charAt(0) - 'a';
		Set<String> setAll = getAll();
		Set<String> setNone = getNone(xKing,yKing,xAmazon,yAmazon,check);
		Set<String> setAmazon = getAmazon(xKing,yKing,xAmazon,yAmazon,check);
		setAmazon.removeAll(setNone);
		Set<String> setSafe = setAll;
		setSafe.removeAll(setAmazon);
		setSafe.removeAll(setNone);

		int[] output = new int[4];
		for(int x = 0; x < 8; x++){
			for(int y = 0; y < 8; y++){
				String s = x + "-" + y;
				if(setNone.contains(s) || (x == xAmazon && y == yAmazon)) continue;
				if(setAmazon.contains(s)){
					if(isCheckMate(xKing,yKing,xAmazon,yAmazon, x, y, check, setAmazon, setSafe, setNone)){
						output[0]++;
					}else {
						output[1]++;
					}
				}else if (setSafe.contains(s)) {
					if(isStale(xKing,yKing,xAmazon,yAmazon, x, y, check, setAmazon, setSafe, setNone)){
						output[2]++;
					}else {
						output[3]++;
					}
				}
			}
		}
		return output;
	}
	
	boolean isCheckMate(int xKing,int yKing,int xAmazon,int yAmazon,int x, int y, int[][] check, Set<String> setAmazon, Set<String> setSafe, Set<String> setNone){
		String sAmazon = xAmazon + "-" + yAmazon;
		for(int i = x-1; i <= x+1; i++){
			for(int j = y-1; j <= y+1; j++){
				if(!valid(i, j, check) || (i == x && j == y)) continue;
				if(setSafe.contains(i + "-" + j)) return false;
				else if (i == xAmazon && j == yAmazon) {
					if(!setNone.contains(sAmazon)) return false;
				}
			}
		}
		return true;
	}
	
	boolean isStale(int xKing,int yKing,int xAmazon,int yAmazon, int x, int y, int[][] check, Set<String> setAmazon, Set<String> setSafe, Set<String> setNone){
		for(int i = x-1; i <= x+1; i++){
			for(int j = y-1; j <= y+1; j++){
				if(!valid(i, j, check) || (i == x && j == y)) continue;
				if(setSafe.contains(i + "-" + j)) return false;;
			}
		}
		return true;
	}
	
	Set<String> getAll() {
		Set<String> setAll = new HashSet<>();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				setAll.add(i + "-" + j);
			}
		}
		return setAll;
	}

	Set<String> getNone(int xKing, int yKing, int xAmazon, int yAmazon, int[][] check) {
		Set<String> s = new HashSet<>();
		if(valid(xKing, yKing+1, check)) s.add(xKing + "-" + (yKing+1));
		if(valid(xKing+1, yKing+1, check)) s.add((xKing+1) + "-" + (yKing+1));
		if(valid(xKing+1, yKing, check)) s.add((xKing+1) + "-" + yKing);
		if(valid(xKing+1, yKing-1, check)) s.add((xKing+1) + "-" + (yKing-1));
		if(valid(xKing, yKing-1, check)) s.add(xKing + "-" + (yKing-1));
		if(valid(xKing-1, yKing-1, check)) s.add((xKing-1) + "-" + (yKing-1));
		if(valid(xKing-1, yKing, check)) s.add((xKing-1) + "-" + yKing);
		if(valid(xKing-1, yKing+1, check)) s.add((xKing-1) + "-" + (yKing+1));
		s.add(xKing + "-" + yKing);
//		s.remove(xAmazon + "-" + yAmazon);
		return s;
	}
	
	Set<String> getAmazon(int xKing, int yKing, int xAmazon, int yAmazon, int[][] check) {
		Set<String> s = new HashSet<>();
		if(valid(xAmazon+1, yAmazon+2, check)) s.add((xAmazon+1) + "-" + (yAmazon+2));
		if(valid(xAmazon+2, yAmazon+1, check)) s.add((xAmazon+2) + "-" + (yAmazon+1));
		if(valid(xAmazon+1, yAmazon-2, check)) s.add((xAmazon+1) + "-" + (yAmazon-2));
		if(valid(xAmazon+2, yAmazon-1, check)) s.add((xAmazon+2) + "-" + (yAmazon-1));
		if(valid(xAmazon-1, yAmazon+2, check)) s.add((xAmazon-1) + "-" + (yAmazon+2));
		if(valid(xAmazon-2, yAmazon+1, check)) s.add((xAmazon-2) + "-" + (yAmazon+1));
		if(valid(xAmazon-1, yAmazon-2, check)) s.add((xAmazon-1) + "-" + (yAmazon-2));
		if(valid(xAmazon-2, yAmazon-1, check)) s.add((xAmazon-2) + "-" + (yAmazon-1));
		for(int i = 1; i < 8; i++){
			if(valid(xAmazon + i, yAmazon + i, check)) s.add((xAmazon+i) + "-" + (yAmazon+i));
			if(valid(xAmazon + i, yAmazon - i, check)) s.add((xAmazon+i) + "-" + (yAmazon-i));
			if(valid(xAmazon - i, yAmazon + i, check)) s.add((xAmazon-i) + "-" + (yAmazon+i));
			if(valid(xAmazon - i, yAmazon - i, check)) s.add((xAmazon-i) + "-" + (yAmazon-i));
			if(valid(xAmazon, yAmazon + i, check)) s.add((xAmazon) + "-" + (yAmazon+i));
			if(valid(xAmazon, yAmazon - i, check)) s.add((xAmazon) + "-" + (yAmazon-i));
			if(valid(xAmazon + i, yAmazon, check)) s.add((xAmazon+i) + "-" + (yAmazon));
			if(valid(xAmazon - i, yAmazon, check)) s.add((xAmazon-i) + "-" + (yAmazon));
		}
		removeChessAfterKing(xKing,yKing,xAmazon,yAmazon,s,check);
		s.add(xAmazon + "-" + yAmazon);
//		s.remove(xKing + "-" + yKing);
		return s;
	}
	
	void removeChessAfterKing(int xKing, int yKing, int xAmazon, int yAmazon,Set<String> s, int[][] check){
		for(int i = 1; i < 8; i++){
			if(valid(xAmazon + i, yAmazon + i, check) && xAmazon+i > xKing 
					&& yAmazon+i > yKing && xKing > xAmazon && yKing > yAmazon && yAmazon-xAmazon == yKing-xKing) 
				s.remove((xAmazon+i) + "-" + (yAmazon+i));
			if(valid(xAmazon + i, yAmazon - i, check) && xAmazon+i > xKing 
					&& yAmazon-i < yKing && xKing > xAmazon && yKing < yAmazon && yAmazon+xAmazon == yKing+xKing) 
				s.remove((xAmazon+i) + "-" + (yAmazon-i));
			if(valid(xAmazon - i, yAmazon + i, check) && xAmazon-i < xKing 
					&& yAmazon+i > yKing && xKing < xAmazon && yKing > yAmazon && yAmazon-xAmazon == yKing-xKing)
				s.remove((xAmazon-i) + "-" + (yAmazon+i));
			if(valid(xAmazon - i, yAmazon - i, check) && xAmazon-i < xKing 
					&& yAmazon-i < yKing && xKing < xAmazon && yKing < yAmazon && yAmazon+xAmazon == yKing+xKing)
				s.remove((xAmazon-i) + "-" + (yAmazon-i));
			if(valid(xAmazon, yAmazon + i, check) && yAmazon+i > yKing && xKing == xAmazon && yKing > yAmazon) 
				s.remove((xAmazon) + "-" + (yAmazon+i));
			if(valid(xAmazon, yAmazon - i, check) && yAmazon-i < yKing && xKing == xAmazon && yKing < yAmazon) 
				s.remove((xAmazon) + "-" + (yAmazon-i));
			if(valid(xAmazon + i, yAmazon, check) && xAmazon+i > xKing && xKing > xAmazon && yKing == yAmazon) 
				s.remove((xAmazon+i) + "-" + (yAmazon));
			if(valid(xAmazon - i, yAmazon, check) && xAmazon-i < xKing && xKing < xAmazon && yKing == yAmazon) 
				s.remove((xAmazon-i) + "-" + (yAmazon));
		}
	}
	
	int[] convertToChess(String s){
		String[] arr = s.split("-");
		int x = Integer.parseInt(arr[0].trim());
		int y = Integer.parseInt(arr[1].trim());
		return new int[]{x,y};
	}
	
	/////////////////////////////////////////////////////////
	String pawnRace(String white, String black, char toMove) {
		final String BLACK = "black", WHITE = "white", DRAW = "draw";
		int x1 = 7 - (white.charAt(1) - '1');
		int y1 = white.charAt(0) - 'a';
		int x2 = 7 - (black.charAt(1) - '1');
		int y2 = black.charAt(0) - 'a';
		if(y1 == y2) {
			if(x2 < x1) return DRAW;
			else {
				if (7 - x2 < x1) return BLACK;
				else if (7 - x2 > x1) {
					return WHITE;
				}else {
					return toMove == 'w' ? WHITE : BLACK;
				}
			}
		}
		if(Math.abs(y1-y2) == 1 && x2 < x1){
			if(x1 == 6){
				if(x2 ==1){
					return 7 - x2 < x1 ? BLACK : WHITE;
				}else {
					if(Math.abs(x1-x2) > 3 ) return WHITE;
					else {
						if(Math.abs(x1-x2) % 2 == 0){
							return toMove == 'w' ? BLACK : WHITE;
						}else {
							return toMove == 'w' ? WHITE : BLACK;
						}
					}
				}
			}else {
				if(x2 ==1 && Math.abs(x1-x2) > 3 ) return BLACK;
				else {
					if(Math.abs(x1-x2) % 2 == 0){
						return toMove == 'w' ? BLACK : WHITE;
					}else {
						return toMove == 'w' ? WHITE : BLACK;
					}
				}
			}
		}else{
			if(((x2 == 1 || x2 == 2) && x1 == 6) || x2 == 1 && x1 == 5){
				return toMove == 'w' ? WHITE : BLACK;
			}else {
				if (7 - x2 < x1) return BLACK;
				else if (7 - x2 > x1) {
					return WHITE;
				}else {
					return toMove == 'w' ? WHITE : BLACK;
				}
			}
		}
	}

	
	public static void main(String[] args) {
		ChessTaven test = new ChessTaven();
		System.out.println(test.pawnRace("e5","f4",'b'));
//		System.out.println(test.amazonCheckmate("d3","e4"));
//		System.out.println(test.amazonCheckmate("a1","g5"));
	}
}
