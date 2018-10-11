/*
    Problem discription:

    Emirp is prime spelled backwards. 
    A number is emirp if both the number itself and the same number 
    written backwards are prime. For instance, 13 and 31 are emirps, 
    but 23 is not, since 32 is a composite number.

    Emirps are hiding in a large integer num, waiting for the next
    skilled programmer to find them! They are clustered together,
    so an emirp can be formed from a set of consecutive digits of num.

    Find the sum of all emirps in num. If none can be found, return -1 instead.

    Example:

    For num = 13211, the output should be: emirpMinion(num) = 1350.
    
    In this example, 13, 3, 2, 1321, and 11 are the only emirps,
    and their sum is 13 + 3 + 2 + 11 + 1321 = 1350.

    Input/Output

    [time limit] 3000ms (java)
    [input] integer num

    Large integer where emirps are hiding.

    Constraints:
    10 ≤ num ≤ 2 · 109.

    [output] integer

    Sum of all emirps found in the large integer num.

*/

/**
    Author: Casey Langford
    Date: 8/17/16

    Notes: This was my first submission for codefights.com, and I was just focused on
    solving the problem, rather than making it short or fast.

*/

public class Emirp{
    public static void main(String[] args){
        
        System.out.println(sumEmirp(1028398123));
    }

    // Checks to see if a prime is an emirp
    public static boolean isEmirp(String s){
        if(isPrime(Integer.parseInt(s))){
            int emirp = reverseInt(s);
            if(isPrime(emirp)){
                return true;
            }
        }
        return false;
    }

    // Returns true if an integer is prime. Very slow
    public static boolean isPrime(int n){
        if(n == 1){
            return false;
        }
        // n must be >= 2
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    // Takes a string representation of a number, and reverse it.
    public static int reverseInt(String s){
        Integer reverse;
        String newStr = "";
        String temp = s;
        for(int i = temp.length() - 1; i >= 0; i--){
            newStr += temp.charAt(i);
        }
        reverse = Integer.parseInt(newStr);
        return reverse;
    }

    public static int sumEmirp(int n){
        Integer num = n;
        String temp = num.toString();
        int sum = 0;
        String subStr = "";
        
        for(int i = 0; i < temp.length(); i++){
            for(int j = temp.length(); j > i; j--){
                subStr = temp.substring(i,j);
                num = Integer.parseInt(subStr);
                if(isEmirp(subStr)){
                    System.out.println("Ermip Found: " + num); // Debugging
                    sum += num;
                }
            }
        }
        if(sum == 0){
            return -1;
        }

        return sum;
    }
}