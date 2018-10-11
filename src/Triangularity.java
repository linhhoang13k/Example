package tiendm.codefight.challenge.april;

public class Triangularity {
	boolean triangularity(int[] s) {
		int l = s.length;
		for(int i = 0; i < l-2; i++){
			for( int j = i + 1 ; j < l - 1 ; j++){
				for(int k = j + 1; k < l ; k ++){
					if(check(s[i],s[j],s[k])) return true;
				}
			}
		}
		return false;
	}

	boolean check(int i, int j, int k) {
		return (i + j > k && i + k > j && j + k > i);
	}

}
