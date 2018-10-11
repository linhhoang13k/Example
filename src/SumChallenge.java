import java.util.LinkedList;
import java.util.Vector;

/* Currently this code is not able to pass all the test cases, Time complexity has to be reduced by dynamic programming */
public class SumChallenge {
	
	
	@SuppressWarnings("unchecked")
	static LinkedList<Integer>[] mat = new LinkedList[62] ;

	static int flag = 0;
	
	static void initializeMatrix() {
	    
	    for(int i = 0; i < 62; i++) {
	    	
	    	long num = (long)Math.pow(2,(i+1));
	        
	    	LinkedList<Integer> list = new LinkedList<Integer>() ;
	    	
	    	while(num > 0) {
	    		list.add((int) (num%10));
	    		num /= 10;
	    	}
	    	mat[i] = list;
	        
	    }
	}

	static int sumDigits(LinkedList<Integer> s) {
	    
	    int sum = 0;
	  
	    for(Integer i : s)
	    	sum += i;
	    return sum;
	}
	
	static LinkedList<Integer> addTwoLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2, int i) {
		LinkedList<Integer> r = new LinkedList<Integer>();
		
		for(int k = 0; k < i; k++) {
			r.add(l1.get(k));
		}
		
		int carry = 0, j = 0;
		
		if(l1.isEmpty()) {
			return l2;
		}
		if(l2.isEmpty()) {
			return l1;
		}
		while(carry > 0 || i < l1.size() || j < l2.size()) {
			
			int sum = (i < l1.size()  ? l1.get(i) : 0) + (j < l2.size() ? l2.get(j) : 0) + carry;
			r.add(sum%10);
			carry = sum/10;		
			i++; j++;
		}
		
		return r;
	}
	
	static LinkedList<Integer> MultiplyTwoLinkedList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> r = new LinkedList<Integer>();
		
		int carry = 0, i = 0, j =0;
		
		if(l1.isEmpty()) {
			return l2;
		}
		if(l2.isEmpty()) {
			return l1;
		}
		int disp = 0;
		while(j < l2.size()) {
			LinkedList<Integer> m = new LinkedList<Integer>();
			carry = 0;
			for(i = 0 ; i < l1.size(); i++) {
				
				int mul =  l1.get(i) * l2.get(j) + carry;
				
				m.add(mul%10); carry = mul/10;		
			}
			if(carry != 0)
				m.add(carry);
			
			r = addTwoLinkedList(r, m,disp);
			disp++;
			j++;
		}
		return r;
		
	}
	static int sum34(int n) {
	    
	    if(flag == 0)
	        initializeMatrix();
	    
	    if(n < 63 ) {  // 1 to 31
	        
	        return sumDigits(mat[n-1]);
	        
	    }
	    
	    else {
	        LinkedList<Integer> r = new LinkedList<Integer>();
	        
	        while( n >= 63) {
	        	r = MultiplyTwoLinkedList(r,mat[61]);
	        	n = n-62;
	        }
	        if ( n > 0) {
	        	  r = MultiplyTwoLinkedList(r,mat[n-1]);
	        }
	        return sumDigits(r);
	    }
	   }


public static void main(String[] args) {
	//System.out.println(sum34(4));
	System.out.println(sum34(19456));
}

}
