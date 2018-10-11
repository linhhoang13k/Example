import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MisteriousChar {

	static char mysteriousChar(int n) {
	    Map <Integer, Character> map = new HashMap<>();
	    map.put(1,'Q');map.put(2,'W');map.put(3,'E');map.put(4,'R');map.put(5,'T');map.put(6,'Y');map.put(7,'U');
	    map.put(8,'I');map.put(9,'O');map.put(10,'P');map.put(11,'A');map.put(12,'S');map.put(13,'D');map.put(14,'F');
	    map.put(15,'G');map.put(16,'H');map.put(17,'J');map.put(18,'K');map.put(19,'L');map.put(20,'Z');map.put(21,'X');
	    map.put(22,'C'); map.put(23,'V');map.put(24,'B');map.put(25,'N');map.put(26,'M');
	    
	    return map.get(n);
	        
	}
	
	public static void main(String[] args) {
		//generates a random number in the range of 1 - 26
		
		for(int i=0;i<10;i++){
			int num = (int) (Math.random()*26)+1;
			System.out.println("shot "+(i+1)+" <<Generated Number -> "+ num+" >>\n"+mysteriousChar(num));
		}
	}
}
