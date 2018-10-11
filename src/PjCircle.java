package tiendm.codefight.challenge.sep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PjCircle {
	int[] pjCircle(int students, int winners) {
	    List<Integer> ls = new ArrayList<>();
	    boolean[] eliminated = new boolean[students];
	    Stack<Integer> sWin = new Stack<>();
	    int[] result = new int[winners];
	    for(int i = 1; i <= students; i++){
	    	ls.add(i);
	    }
	    int i = 0;
	    boolean canEliminate = false;
	    while(sWin.size() < students){
	    	int idx = i % students;
	    	if(!eliminated[idx]){
	    		if(canEliminate){
	    			sWin.push(ls.get(idx));
	    			eliminated[idx] = true;
	    		}
	    		canEliminate = !canEliminate;
	    	}
	    	i++;
	    }
	    i = 0;
	    while(i < winners){
	    	result[winners-1-i] = sWin.pop();
	    	i++;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		PjCircle p = new PjCircle();
		System.out.println(p.pjCircle(10, 5));
	}
}
