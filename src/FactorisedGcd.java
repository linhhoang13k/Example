package codeFight;

public class FactorisedGcd {

	public static void main(String[] args) {
		int a[]  = new int[] {2, 3, 3, 3, 5};
		 int b[]  = new int[] {2, 2, 2, 2, 3, 3};
		int x= factorizedGCD(a, b);
		System.out.println(x);
	}
static int factorizedGCD(int[] a, int[] b) {
	 
	
	  int j = 0,
	      result = 1;
	  for (int i = 0; i < a.length; i++) {
	    while ( j<b.length&&a[i]!=b[j]) {
	      j++;
	    }
	    if (j < b.length && a[i] == b[j]) {
	      result *= a[i];
	      j++;
	    }
	  }
	  return result;
	}

}


/*c++
 * 
 * 
 * int factorizedGCD(std::vector<int> a, std::vector<int> b) {
    std::vector<int> u;
    int ret=1;
    for(const auto & x:a){
        if(std::find(b.begin(),b.end(),x)!=b.end())
            ret*=x,b.erase(std::find(b.begin(),b.end(),x));
    }
    return ret;
}

 * */

/*
 * Find the greatest common divisor of two given integers. Each integer is given in the form of its prime factorization - a sorted array of all prime factors of the number.

Example

For a = [2, 3, 3, 3, 5] and b = [2, 2, 2, 2, 3, 3], the output should be
factorizedGCD(a, b) = 18.

gcd(a, b) = gcd(270, 144)
 */
 
