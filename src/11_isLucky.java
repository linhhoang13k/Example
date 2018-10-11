/*
Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.

Given a ticket number n, determine if it's lucky or not.

Example

    For n = 1230, the output should be
    isLucky(n) = true;
    For n = 239017, the output should be
    isLucky(n) = false.

Input/Output

    [time limit] 3000ms (java)

    [input] integer n

    A ticket number represented as a positive integer with an even number of digits.

    Guaranteed constraints:
    10 ≤ n < 106.

    [output] boolean

    true if n is a lucky ticket number, false otherwise.
*/

boolean isLucky(int n){
    
    //store the single digits in an array
    int number = n;
    String numberString = String.valueOf(n);
    int numberLength = numberString.length();
    int[] numberArray= new int[numberLength];
    for(int digit = numberLength-1; digit >=0 ; digit--){
        numberArray[digit] = number% 10;
        number /= 10;
    }
    
    //calculate first and second half sums
    int firstHalfSum = 0;
    int secondHalfSum = 0;
    for(int digit=0 ; digit < numberLength; digit++){
        if(digit < numberLength/2){
            firstHalfSum += numberArray[digit];
        }else{
            secondHalfSum += numberArray[digit];
        }
    }
    
    //check for lucky ticket number
    boolean isLuckyTicket = false;
    if(firstHalfSum == secondHalfSum){
        isLuckyTicket = true;
    }
    
    return isLuckyTicket;
}

