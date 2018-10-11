                         package Apple;

public class ReverseInteger {
	
	public static int reverseInt(int n){
		boolean neg = false;
		if(n < 0){
			neg = true;
			n = n*(-1);
		}
		int rev = 0;
		while(n>0){
			rev = rev*10 + n%10;
			n = n/10;
		}
		if(neg){
			return -1*rev;
		}else{
			return rev;
		}
		
	}

	public static void main(String[] args) {
		int n = 4243;
		int ans = reverseInt(n);
		System.out.println(ans);
	}

}
