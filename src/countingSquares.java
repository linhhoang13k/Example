    /*
      Given an integer n, find the number of ways to select four points with integer coordinates between 0 and n, such that the four points form the vertices of a square.

Since the number of squares could be very large, return the result mod 109 + 7.

Example

    For n = 3, the output should be countingSquares(n) = 20. There are 20 possible squares with integer coordinates, that fit in a 3 x 3 grid:

    square possibilities*/
    <img src="https://i.imgur.com/ABuAm7u.png">
/*
Input / Output

    [execution time limit] 3 seconds (java)

    [input] integer n

    An integer representing the side length of the boundary that the vertices of the square must fit within.

    Guaranteed constraints:
    0 ≤ n ≤ 109

    [output] integer

    An integer representing the number of different squares that can be formed (mode 109 + 7).

    */
    int countingSquares(int n) {
        if(n<=0){
            return 0;
        }
        long M=1000000007;
        long nmod = n%M;
        long n1mod = (n+1)%M;
        long nsum = multiply(nmod,n1mod);
        System.out.println(nsum);
        long n2mod = (2*n+1)%M;
        long ssum = multiply(nmod,multiply(n1mod,n2mod));
        System.out.println(ssum);
        long csum = multiply(nmod,multiply(nmod,multiply(n1mod,n1mod)));
        System.out.println(csum);
        long twelveInv = modInverse(12,M);
        long res = (add(nsum,add(ssum,csum))*twelveInv)%M;
        return (int)res;
    }

    long multiply(long n, long m){
        long M=1000000007;
        return (n*m)%M;
    }

    long add(long n, long m){
        long M=1000000007;
        return (n+m)%M;
    }

    long modInverse(long a, long m)
    {
        long g = gcd(a, m);
        if (g != 1)
            System.out.println("Inverse doesn't exist");
        else
        {
            // If a and m are relatively prime, then modulo inverse
            // is a^(m-2) mode m
            return power(a, m - 2, m);
        }
        return power(a, m - 2, m);
    }

    // To compute x^y under modulo m
     long power(long x, long y, long m)
    {
        if (y == 0)
            return 1;

        long p = power(x, y / 2, m) % m;
        p = (p * p) % m;

        if (y % 2 == 0)
            return p;
        else
            return (x * p) % m;
    }

    // Function to return gcd of a and b
    long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

