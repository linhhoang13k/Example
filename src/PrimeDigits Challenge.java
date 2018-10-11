/*
You are given a positive integer N, your task is to calculate the total number of primes less than or equal to N with additional requirement that each digit of those primes should be a prime number itself.

Example

For N = 11, the output should be
primeDigits(11) = 4.
There are 5 primes less than N or equal to it: 2, 3, 5, 7 and 11. But there is a digit 1 (even two of them) in 11, and 1 is not a prime number. Thus, the answer is 4.

*/

int primeDigits(int N) {
    int count =0;
    boolean isPrime=true;
    String x= "";
    int[] primedigits = {2,3,5,7};
    boolean yes= true;
    for(int i=2; i<=N; i++)
    {
       // isPrime = true;
        x = Integer.toString(i);
        for(int j=0; j<x.length(); j++)
        {
            for(int w=0; w<primedigits.length; w++)
            {
                if(Character.getNumericValue(x.charAt(j)) != primedigits[w])
                {
                    isPrime = false;
                }
                else
                {
                    isPrime = true;
                    break;
                }
            }
            if(!isPrime)
            {
                break;
            }
        }
        if(isPrime)
        {
    //      yes = true;
            for(int b=2; b<i/2; b++)
            {
                if (i%b ==0)
                {
                    yes = false;
                    break;
                }
                else
                {
                    yes = true;
                }
            }
            if(yes)
            {
                count++;
            }
        }
    }
    
    return count;
}
