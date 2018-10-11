package tiendm.codefight.tournament.aug;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tour3008 {
	String lineEncoding(String s) {
	    String result = "";
	    int count = 0;
	    char prev = '#';
	    s += "$";
	    for(int i = 0; i < s.length() ; i++){
	        if(s.charAt(i) == prev || prev == '#'){
	            count++;
	        }else{
	            if(count < 2){
	                result += prev;
	            }else{
	                result += (count + "" + prev);
	            }
	            count = 1;
	        }
	        prev = s.charAt(i);
	    }
	    return result;
	}
	
	int rounders(int n) {
		    String s = n + "";
		    for(int i = s.length() - 1; i > 0; i--){
		        int x = s.charAt(i) - '0';
		        int y = s.charAt(i-1) - '0';
		        if(x >= 5){
		            y++;
		        }
		        x = 0;
		        s = s.substring(0,i-1) + y + x + s.substring(i+1);
		    }
		    return Integer.parseInt(s);
	}
	
	int sequenceElement(int[] a, int n) {
		if(n < 5) return a[n];
		int sum = 0, count = 4, newElement = 0;
		Queue<Integer> q = new LinkedList<>();
		for(int x : a){
			sum += x;
			q.add(x);
		}
		while (count < n) {
			count++;
			newElement = sum % 10;
			int first = q.remove();
			sum += newElement - first;
			q.add(newElement);
			if(isOrginal(a, q)){
                n = n % (count-4);
                count = 4;
            }
		}
		return newElement;
	}
	
	boolean isOrginal(int[] a, Queue<Integer> q){
		int count = 0;
	    for(Iterator<Integer> it = q.iterator(); it.hasNext(); ){
	    	if(it.next() != a[count++]) return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		Tour3008 t = new Tour3008();
		int[][] x = { { 0, 1, 2, 3 }, { 1, 2, 3, 0 }, { 1, 1, 1 } };
		int[] p = { 7, 5, 4, 4, 8 };
		System.out.println(t.sequenceElement(p,521687676));
	}
}
