package tiendm.codefight.tournament.aug;

public class Tour1608 {

	boolean cyclicSequence(int[] a) {
		if(a.length == 1) return true;
	    int cur = a[1], i = 1;
	    while(cur >= a[i-1]){
	        i++;
	        cur = a[i];
	    }
	    for(int x = i+1; x < a.length; x++){
	        if(a[x] < a[x-1]) return false;
	    }
	    return a[0] > a[a.length-1];
	}

	public static void main(String[] args) {
		Tour1608 t = new Tour1608();
		int[] x = { 5, 9, 1, 2, 4 };
		System.out.println(t.cyclicSequence(x));
	}
}
