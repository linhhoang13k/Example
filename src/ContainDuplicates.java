package codefights.common.techniques;

import java.util.HashSet;
import java.util.Set;


public class ContainDuplicates {

	public static void main(String[] args) {
		ContainDuplicates d = new ContainDuplicates();
		int[] a = {1,2,3,1};
		System.out.println(d.containsDuplicates(a));
	}
	
	boolean containsDuplicates(int[] a) {
	    boolean rv = false;
	    Set<Integer> dupes = new HashSet<Integer>();
	    
	    for (int i=0;i<a.length;i++){
	        if (dupes.contains(a[i])){
	            rv = true;
	            break;
	        } else {
	        	dupes.add(a[i]);
	        }
	    }
	    
	    return rv;
	}

}
