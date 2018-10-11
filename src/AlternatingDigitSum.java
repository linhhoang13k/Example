/*
Define the alternating digit sum of number "abc..xyz" as z - y + x - ... a, where a ... z are the digits the number consists of.

Given an integer n, your task is to find the alternating digit sum of n! and return it modulo 11.

Example

For n = 4, the output should be
AlternatingDigitSum(n) = 2.

4! = 24, its alternating digit sum is equal to 2, and 2 % 11 = 2, which is the answer.
*/

int AlternatingDigitSum(int n) {
    int s=1,a =0;
    if(n>12)  return 0;
   for(int i=1; i<=n; i++)
   {
       s *=i;
   }
    n = s;
   String w = Integer.toString(n);

    for(int i=w.length()-1; i>=0; i-=2)
    {
        if(i >0)
        {
        a += Character.getNumericValue(w.charAt(i)) - Character.getNumericValue(w.charAt(i-1) ); 
        }
        else
        {
                 a += Character.getNumericValue(w.charAt(i));
            if(w.length()%2==0)
            {
                a -= Character.getNumericValue(w.charAt(i-1) ); 
            }
        }
    }
    int m = a % 11;
while (m<0) m += 11;
   
    
  return m;
  
}
