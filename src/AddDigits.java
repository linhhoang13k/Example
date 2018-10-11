String addDigits(int a, int b, int n) {
    String s = ""+a;
    int mod = a % b;
    for(int i = 0; i < n; i++){
        for(int j = 9; j >= 0; j--){
            if ((mod * 10 + j) % b == 0){
                s += j;
                mod = 0;
                break;
            }
        }
    }    
    return s;
}

/*
Given positive integer numbers a, b and n return the maximum number that can be obtained 
by lengthening number a repeatedly no more than n times.

Lengthening number a means appending exactly one digit (in the decimal notation) 
to the right hand side of a such that the resulting number is divisible by number b. 
If it is impossible to obtain a number that is divisible by b, then the lengthening operation cannot be performed.

For a = 12, b = 11 and n = 2, the output should be
addDigits(a, b, n) = "1210".

Lengthening operations can be 12->121->1210.
*/
