/*
You are given a non-negative integer N, and your task is to find all the prime integers less than N. Write this numbers down as a string and return the length of the resulting string.

Example

For N = 13, the output should be
primeLength(13) = 6.

There are 5 primes less than N: 2, 3, 5, 7 and 11.
The combination string is 235711 which has the length of 6.
Thus, the final answer is 6.
*/

int primeLength(int N) {

   

    boolean [] isComposite = new boolean [N + 1]; // limit + 1 because we won't use '0'th index of the array
    isComposite[1] = true;
     int x=0;
    // Mark all composite numbers
    for (int i = 2; i < N; i++) {
        if (!isComposite[i]) {
            // 'i' is a prime number
          
            x += String.valueOf(i).length();
            int multiple = 2;
            while (i * multiple < N) {
                isComposite [i * multiple] = true;
                multiple++;
            }
        }
    }
 

   
    

    return x;
}
